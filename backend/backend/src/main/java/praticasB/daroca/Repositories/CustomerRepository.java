package praticasB.daroca.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import praticasB.daroca.classes.Customer;


import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
