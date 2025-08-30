package praticasB.daroca.Services;

import org.springframework.stereotype.Service;
import praticasB.daroca.Controller.RoutesController;
import praticasB.daroca.Repositories.RouteRepository;
import praticasB.daroca.classes.Driver;
import praticasB.daroca.classes.Route;

import java.util.List;

@Service
public class RouteService {

    public RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository){
        this.routeRepository = routeRepository;

    }
    public void saveAll(List<Route> drivers) {
        routeRepository.saveAll(drivers);
    }

    public List<Route> getAll() {
        return routeRepository.findAll();
    }
}
