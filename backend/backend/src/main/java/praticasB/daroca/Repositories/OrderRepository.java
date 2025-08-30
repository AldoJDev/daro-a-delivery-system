package praticasB.daroca.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import praticasB.daroca.classes.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order , UUID> {
    List<Order> findByWarehouseId(UUID warehouseId);
}
