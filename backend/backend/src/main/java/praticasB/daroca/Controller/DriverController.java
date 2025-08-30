package praticasB.daroca.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import praticasB.daroca.classes.Driver;
import praticasB.daroca.Services.DriverService;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class DriverController {
    private final RestTemplate restTemplate;
    private final DriverService driverService;
    private static final String API_BASE_URL = "https://daroca.glitch.me";

    public DriverController(RestTemplate restTemplate, DriverService driverService) {
        this.restTemplate = restTemplate;
        this.driverService = driverService;
    }


    @GetMapping("/refreshDriver")
    public String refresh() {
        String url = API_BASE_URL + "/drivers";
        ResponseEntity<Driver[]> response = restTemplate.getForEntity(url, Driver[].class);

        //intelliJ indicou que ussasse "Objects.requireNonNull"
        List<Driver> driversAPI = Arrays.asList(Objects.requireNonNull(response.getBody()));
        List<Driver> driversBD = driverService.getAll();

        // Método stream() é utilizado para converter a lista de motoristas obtida da API em um fluxo (stream) de elementos.
        // Método filter() é aplicado ao fluxo de elementos (stream) para filtrar apenas os elementos que correspondem à condição especificada.
        // Neste caso, estamos filtrando os motoristas que não estão presentes no banco de dados.
        List<Driver> newDrivers = driversAPI.stream().filter(obj -> !driversBD.contains(obj)).toList();
        if (!newDrivers.isEmpty()) {
            driverService.saveAll(newDrivers);
            return "Banco de dados atualizado";
        } else {
            return "Não há novos dados para atualizar";
        }
    }

    @GetMapping("/getAllDrivers")
    public List<Driver> getAll(){
        return driverService.getAll();
    }




    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/getDriver/{id}")
    public Driver getDriverById(@PathVariable UUID id) {
        String url = API_BASE_URL + "/drivers/" + id;
        return restTemplate.getForObject(url, Driver.class);
    }


    @GetMapping("/getDriversLimit/{id}/{amount}")
    public List<Driver> getDriversWithLimit(@PathVariable UUID id, @PathVariable Integer amount) {
        String url = API_BASE_URL + "/drivers/" + id + "/" + amount;
        ResponseEntity<Driver[]> response = restTemplate.getForEntity(url, Driver[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

}