package praticasB.daroca.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Table(name = "Route")
@Entity(name = "Route")
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(name = "dateNow")
    private LocalDate dateNow;

    private double latitude;

    private double longitude;

    private int orderRoute;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    @JsonProperty("driver")
    private Driver driver;

    public Route(LocalDate dateNow, double latitude, double longitude, int orderRoute, Driver driver) {
        this.dateNow = dateNow;
        this.latitude = latitude;
        this.longitude = longitude;
        this.orderRoute = orderRoute;
        this.driver = driver; // Associa o Driver ao objeto Route
    }

    // Getters and setters for driver
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    // Getters and setters for other fields
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDateNow() {
        return dateNow;
    }

    public void setDateNow(LocalDate dateNow) {
        this.dateNow = dateNow;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getOrderRoute() {
        return orderRoute;
    }

    public void setOrderRoute(int orderRoute) {
        this.orderRoute = orderRoute;
    }
}
