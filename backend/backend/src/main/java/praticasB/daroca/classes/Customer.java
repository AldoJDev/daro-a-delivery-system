package praticasB.daroca.classes;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "Customer")
@Entity(name = "Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    private UUID id;

    private String name;
    private String city;
    private String state;
    private Double latitude;
    private Double longitude;

    public double getLatitude() {
        return  latitude;
    }

    public double getLongitude() {
        return  longitude;
    }
}