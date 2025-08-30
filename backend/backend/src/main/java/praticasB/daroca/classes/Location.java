package praticasB.daroca.classes;

import jakarta.persistence.Entity;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;



public class Location {
    private double latitude;
    private double longitude;
    private int orderRoute;
    private LocalDate dateNow;

    public Location(double latitude, double longitude, int orderRoute) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.orderRoute = orderRoute;
        this.dateNow = LocalDate.now();
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getOrderRoute(){
        return  orderRoute;
    }

    public LocalDate getDateNow(){
        return  dateNow;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}