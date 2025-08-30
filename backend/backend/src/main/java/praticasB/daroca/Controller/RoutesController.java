package praticasB.daroca.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import praticasB.daroca.Services.DriverService;
import praticasB.daroca.Services.RouteService;
import praticasB.daroca.Services.RoutesService;
import praticasB.daroca.classes.Driver;
import praticasB.daroca.classes.Location;
import praticasB.daroca.classes.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/routes")
public class RoutesController {

    private final RestTemplate restTemplate;
    private final RoutesService routesService;
    private final RouteService routeService;
    private final DriverService driverService;
    private static final String API_BASE_URL = "https://daroca.glitch.me";

    public RoutesController(RestTemplate restTemplate, RoutesService routesService, RouteService routeService, DriverService driverService) {
        this.restTemplate = restTemplate;
        this.routesService = routesService;
        this.routeService = routeService;
        this.driverService = driverService;
    }

    @PostMapping("/{driverId}")
    public ResponseEntity<List<Location>> getNearestNeighborRoute(@PathVariable("driverId") UUID driverId) {
        List<Location> nearestNeighborRoute = routesService.getNearestNeighborRoute(driverId);
        List<Route> routes = new ArrayList<>();

        // Obter o objeto Driver com base no driverId
        Driver driver = driverService.findById(driverId);

        for (Location location : nearestNeighborRoute) {
            Route route = new Route(location.getDateNow(), location.getLatitude(), location.getLongitude(), location.getOrderRoute(), driver);
            routes.add(route);
        }

        routeService.saveAll(routes);
        return ResponseEntity.ok(nearestNeighborRoute);
    }
}
