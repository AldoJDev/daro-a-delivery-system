package praticasB.daroca.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import praticasB.daroca.Services.CustomerService;
import praticasB.daroca.classes.Customer;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private final RestTemplate restTemplate; //REST

    private final CustomerService customerService;
    private static final String API_BASE_URL = "https://daroca.glitch.me";

    public CustomerController(RestTemplate restTemplate, CustomerService customersService) {
        this.restTemplate = restTemplate;
        this.customerService = customersService;
    }

    //refresh
    @GetMapping("/refreshCustomer")

    public String refresh() {
        String url = API_BASE_URL + "/customers/-1/350";
        ResponseEntity<Customer[]> response = restTemplate.getForEntity(url, Customer[].class);

        //intelliJ indicou que ussasse "Objects.requireNonNull"
        List<Customer> customersAPI = Arrays.asList(Objects.requireNonNull(response.getBody()));
        List<Customer> customersBD = customerService.getAll();

        // Método stream() é utilizado para converter a lista de Clientes obtida da API em um fluxo (stream) de elementos.
        // Método filter() é aplicado ao fluxo de elementos (stream) para filtrar apenas os elementos que correspondem à condição especificada.
        // Neste caso, estamos filtrando os Clientes que não estão presentes no banco de dados.
        List<Customer> newCostumers = customersAPI.stream().filter(obj -> !customersBD.contains(obj)).toList();
        if (!newCostumers.isEmpty()) {
            customerService.saveAll(newCostumers);
            return "Banco de dados atualizado";
        } else {
            return "Não há novos dados para atualizar";
        }
    }

        @GetMapping("/getAllCustomers")
    public List<
                Customer> getAll(){
        return customerService.getAll();
    }





    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/getCostumerId/{id}")
    public Customer getCostumerById(@PathVariable UUID id){
        String url = API_BASE_URL + "/customers/" + id;
        return restTemplate.getForObject(url, Customer.class);
    }

    @GetMapping("/getCostumerLimit/{id}/{amount}")
    public List<Customer> getCostumerWithLimit(@PathVariable UUID id, @PathVariable Integer amount) {
        String url = API_BASE_URL + "/customers/" + id + "/" + amount;
        ResponseEntity<Customer[]> response = restTemplate.getForEntity(url, Customer[].class);
        return Arrays.asList(response.getBody());
    }
}
