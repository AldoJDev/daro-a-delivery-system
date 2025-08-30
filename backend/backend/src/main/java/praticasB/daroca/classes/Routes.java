package praticasB.daroca.classes;

import praticasB.daroca.Services.OrderService;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Routes {
    private final List<Order> orders;
    private final Driver driver;
    private final OrderService orderService;

    public Routes(List<Order> orders, Driver driver, OrderService orderService) {
        this.orders = new ArrayList<>(orders);
        this.driver = driver;
        this.orderService = orderService;
    }

    public List<Location> optimizeRoute() {
        List<Location> optimizedRoute = new ArrayList<>();
        List<Order> deliveredOrders = new ArrayList<>();
        int orderRoute = 1;

        final Location initialLocation = new Location(driver.getWarehouse().getLatitude(),
                driver.getWarehouse().getLongitude(), orderRoute);

        optimizedRoute.add(initialLocation); // Inicia no depósito
        orderRoute++;

        // Convertendo LocalTime para LocalDateTime
        LocalDateTime currentTime = driver.getShiftStart().atDate(LocalDate.now());
        double tempoIda = 0.0; // tempo gasto para a ida
        int numeroEncomendas = 0;
        final int LIMITE_HORAS = 8; // limite máximo de horas de trabalho (ajuste conforme necessário)

        Location currentLocation = initialLocation;

        // Ordena os pedidos pela distância do depósito (do mais longe para o mais perto)
        orders.sort(Comparator.comparingDouble((Order order) -> order != null && order.getCustomer() != null
                ? calculateDistance(initialLocation, new Location(order.getCustomer().getLatitude(), order.getCustomer().getLongitude(), 0))
                : Double.MAX_VALUE).reversed());

        while (tempoIda < LIMITE_HORAS && numeroEncomendas < 6) {
            double menorDistancia = Double.POSITIVE_INFINITY;
            int proximaEntrega = -1;

            // Encontra a entrega mais próxima
            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                if (order != null && order.getCustomer() != null) {
                    double distancia = calculateDistance(currentLocation, new Location(order.getCustomer().getLatitude(), order.getCustomer().getLongitude(), 0));
                    if (distancia < menorDistancia) {
                        menorDistancia = distancia;
                        proximaEntrega = i;
                    }
                }
            }
            // Se não houver mais entregas próximas, saia do loop
            if (proximaEntrega == -1) {
                break;
            }
            Order currentOrder = orders.get(proximaEntrega);
            Location currentAddress = new Location(currentOrder.getCustomer().getLatitude(),
                    currentOrder.getCustomer().getLongitude(), orderRoute);
            optimizedRoute.add(currentAddress);
            orderRoute++;

            deliveredOrders.add(currentOrder);
            orders.remove(proximaEntrega);

            double travelTime = calculateTravelTime(currentLocation, currentAddress, driver.getSpeed());
            tempoIda += travelTime;
            numeroEncomendas++;

            currentTime = currentTime.plus(Duration.ofHours((long) travelTime));
            currentLocation = currentAddress;
        }

        // Adiciona o tempo de volta ao depósito
        if (!currentLocation.equals(initialLocation)) {
            double returnTravelTime = calculateTravelTime(currentLocation, initialLocation, driver.getSpeed());
            tempoIda += returnTravelTime;
            Location finalLocation = new Location(driver.getWarehouse().getLatitude(),
                    driver.getWarehouse().getLongitude(), orderRoute);
            optimizedRoute.add(finalLocation); // Termina no depósito
        }

        orderService.delete(deliveredOrders);

        return optimizedRoute;
    }

    // Função para calcular a distância em km entre duas coordenadas geográficas usando a fórmula de Haversine
    private double calculateDistance(Location location1, Location location2) {
        double result = 0.0;
        double lat1 = location1.getLatitude();
        double lon1 = location1.getLongitude();
        double lat2 = location2.getLatitude();
        double lon2 = location2.getLongitude();

        final double R = 6371.0; // Raio da Terra em km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        result = R * c;
        
        return result;
    }

    private double calculateTravelTime(Location location1, Location location2, double speed) {
        double distance = calculateDistance(location1, location2);
        return distance / speed;
    }

    private boolean canDeliverOrder(LocalTime estimatedDeliveryTime, Driver driver) {
        return estimatedDeliveryTime.isBefore(driver.getBreakStart()) &&
                estimatedDeliveryTime.isBefore(driver.getShiftEnd());
    }
}
