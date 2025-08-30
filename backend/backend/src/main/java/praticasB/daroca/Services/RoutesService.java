package praticasB.daroca.Services;

import org.springframework.stereotype.Service;
import praticasB.daroca.Repositories.DriverRepository;
import praticasB.daroca.Repositories.OrderRepository;
import praticasB.daroca.Repositories.WarehouseRepository;
import praticasB.daroca.classes.*;

import java.util.List;
import java.util.UUID;

@Service
public class RoutesService {

    private final OrderRepository orderRepository;
    private final WarehouseRepository warehouseRepository;
    private final DriverRepository driverRepository;
    private final OrderService orderService;

    public RoutesService(OrderRepository orderRepository, WarehouseRepository warehouseRepository, DriverRepository driverRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.warehouseRepository = warehouseRepository;
        this.driverRepository = driverRepository;
        this.orderService = orderService;
    }

    public List<Location> getNearestNeighborRoute(UUID driverId) {
        List<Location> response;
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));

        Warehouse warehouse = warehouseRepository.findById(driver.getWarehouseId())
                .orElseThrow(() -> new RuntimeException("Armazém não encontrado"));

        List<Order> orders = orderRepository.findByWarehouseId(warehouse.getId());

        Routes routes = new Routes(orders, driver, orderService);

        response = routes.optimizeRoute();
        return response;
    }
}
