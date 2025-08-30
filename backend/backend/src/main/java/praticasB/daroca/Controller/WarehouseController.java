package praticasB.daroca.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import praticasB.daroca.Repositories.WarehouseRepository;
import praticasB.daroca.classes.Warehouse;
import praticasB.daroca.Services.WarehouseService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class WarehouseController {

    private final RestTemplate restTemplate;
    private final WarehouseService warehouseService;
    private final String API_BASE_URL = "https://daroca.glitch.me";

    public  WarehouseController(RestTemplate restTemplate,WarehouseService warehouseService) {
        this.restTemplate = restTemplate;
        this.warehouseService = warehouseService;
    }
    @GetMapping("/refreshWarehouse")
    public String refresh() {
        String url = API_BASE_URL + "/warehouses";

        ResponseEntity<Warehouse[]> response = restTemplate.getForEntity(url, Warehouse[].class);
        List<Warehouse> warehousesAPI = Arrays.asList(Objects.requireNonNull(response.getBody()));
        List<Warehouse> warehousesBD = warehouseService.getAll();

        // Método stream() é utilizado para converter a lista de CD obtida da API em um fluxo (stream) de elementos.
        // Método filter() é aplicado ao fluxo de elementos (stream) para filtrar apenas os elementos que correspondem à condição especificada.
        // Neste caso, estamos filtrando os CD que não estão presentes no banco de dados.
        List<Warehouse> newWarehouses = warehousesAPI.stream().filter(obj -> !warehousesBD.contains(obj)).toList();
        if (!newWarehouses.isEmpty()) {
            warehouseService.saveAll(newWarehouses);
            return "Banco de dados atualizado";
        } else {
            return "Não há novos dados para atualizar";
        }
    }

    @GetMapping("/getAllWarehouses")
    public List<Warehouse> getAll(){
        return warehouseService.getAll();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/getWarehouse/{id}")
    public Warehouse getDriverById(@PathVariable UUID id) {
        Warehouse warehouse = warehouseService.findId(id);
        return  warehouse;
    }


    @GetMapping("/getWarehouseLimit/{id}/{amount}")
    public List<Warehouse> getDriversWithLimit(@PathVariable UUID id, @PathVariable Integer amount) {
        String url = API_BASE_URL + "/warehouses/" + id + "/" + amount;
        ResponseEntity<Warehouse[]> response = restTemplate.getForEntity(url, Warehouse[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

}
