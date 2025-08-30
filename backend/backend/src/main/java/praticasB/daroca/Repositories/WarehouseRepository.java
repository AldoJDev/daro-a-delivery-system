package praticasB.daroca.Repositories;// WarehouseRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import praticasB.daroca.classes.Warehouse;

import java.util.UUID;

public interface WarehouseRepository extends JpaRepository<Warehouse, UUID> {

}