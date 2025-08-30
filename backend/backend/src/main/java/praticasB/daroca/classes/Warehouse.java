package praticasB.daroca.classes;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Table(name = "Warehouse")
@Entity(name = "Warehouse")
@Embeddable
@Setter

@NoArgsConstructor
public class Warehouse {
    @Id
    private UUID id;
    private String name;
    private String city;
    private String state;
    private double latitude;
    private double longitude;

    public Warehouse(UUID id, String name, String city, String state, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Double.compare(warehouse.latitude, latitude) == 0 &&
                Double.compare(warehouse.longitude, longitude) == 0 &&
                Objects.equals(id, warehouse.id) &&
                Objects.equals(name, warehouse.name) &&
                Objects.equals(city, warehouse.city) &&
                Objects.equals(state, warehouse.state);
    }

    @Override
    public int hashCode() { //estrutura de dados; valor numérico usado para comparação nesse contexto.
        return Objects.hash(id, name, city, state, latitude, longitude);
    }

    public UUID getId() {
        return  id;
    }

    public double getLongitude() {
        return  longitude;
    }

    public double getLatitude() {
        return  latitude;
    }

    public String getName() {
        return  name;
    }

    public String getState() {
        return  state;
    }
    public String getCity() {
        return  city;
    }
}