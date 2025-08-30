package praticasB.daroca.Services;
import org.springframework.stereotype.Service;
import praticasB.daroca.Repositories.OrderRepository;
import praticasB.daroca.classes.Order;
import java.util.List;

@Service

public class OrderService {

    private  final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveAll(List<Order> orders) {
        orderRepository.saveAll(orders);
    }

    public void delete(List<Order> orders) {
        for (Order order : orders) {
            orderRepository.delete(order);
        }
    }

    public List<Order> getAll() { return orderRepository.findAll(); }
}
