package praticasB.daroca.Services;
import org.springframework.stereotype.Service;
import praticasB.daroca.Repositories.WarehouseRepository;
import praticasB.daroca.classes.Warehouse;
import java.util.List;
import java.util.UUID;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public void saveAll(List<Warehouse> warehouses) {
        warehouseRepository.saveAll(warehouses);
    }

    public List<Warehouse> getAll(){  return warehouseRepository.findAll(); }

    public Warehouse findId(UUID id) {
        return warehouseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Motorista não encontrado")); }
}