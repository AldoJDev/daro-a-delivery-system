package praticasB.daroca.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import praticasB.daroca.classes.Route;

import java.util.UUID;

public interface RouteRepository extends JpaRepository<Route, UUID> {

}
