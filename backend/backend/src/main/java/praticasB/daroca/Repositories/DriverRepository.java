package praticasB.daroca.Repositories;// DriverRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import praticasB.daroca.classes.Driver;

import java.util.UUID;

public interface DriverRepository extends JpaRepository<Driver, UUID> {
    // Métodos personalizados, se necessário
}