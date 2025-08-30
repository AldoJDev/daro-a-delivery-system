package praticasB.daroca.Services;// DriverService.java
import org.springframework.stereotype.Service;
import praticasB.daroca.Repositories.DriverRepository;
import praticasB.daroca.classes.Driver;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void saveAll(List<Driver> drivers) {
        driverRepository.saveAll(drivers);
    }

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    public Driver findById(UUID driverId) {
        return driverRepository.findById(driverId) .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
    }
}

