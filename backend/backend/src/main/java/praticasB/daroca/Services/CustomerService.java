package praticasB.daroca.Services;
import org.springframework.stereotype.Service;
import praticasB.daroca.Repositories.CustomerRepository;
import praticasB.daroca.classes.Customer;

import java.util.List;

@Service

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveAll(List<Customer> drivers) {
        customerRepository.saveAll(drivers);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}