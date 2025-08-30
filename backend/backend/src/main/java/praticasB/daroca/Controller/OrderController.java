package praticasB.daroca.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import praticasB.daroca.Services.OrderService;
import praticasB.daroca.classes.Order;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
@RestController
@RequestMapping("/api")

public class OrderController {
    private final RestTemplate restTemplate; //REST

    private final OrderService orderService;
    private static final String API_BASE_URL = "https://daroca.glitch.me";

    public OrderController(RestTemplate restTemplate, OrderService orderService) {
        this.restTemplate = restTemplate;
        this.orderService = orderService;
    }

    //refresh
    @GetMapping("/refreshOrder")

    public String refresh() {
        String url = API_BASE_URL + "/orders/-1/350";
        ResponseEntity<Order[]> response = restTemplate.getForEntity(url, Order[].class);


        //intelliJ indicou que ussasse "Objects.requireNonNull"
        List<Order> ordersAPI = Arrays.asList(Objects.requireNonNull(response.getBody()));
        List<Order> ordersBD = orderService.getAll();

        // Método stream() é utilizado para converter a lista de pedidos obtida da API em um fluxo (stream) de elementos.
        // Método filter() é aplicado ao fluxo de elementos (stream) para filtrar apenas os elementos que correspondem à condição especificada.
        // Neste caso, estamos filtrando os pedidos que não estão presentes no banco de dados.
        List<Order> newOrders = ordersAPI.stream().filter(obj -> !ordersBD.contains(obj)).toList();
        if (!newOrders.isEmpty()) {
            orderService.saveAll(newOrders);
            return "Banco de dados atualizado";
        } else {
            return "Não há novos dados para atualizar";
        }
    }

    @GetMapping("/getAllOrders")
    public List<Order> getAll(){ return orderService.getAll(); }


    public void deleteOrders(List<Order> orders) {
        orderService.delete(orders);
    }

}
