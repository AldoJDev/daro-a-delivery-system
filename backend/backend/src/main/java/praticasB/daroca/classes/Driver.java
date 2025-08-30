package praticasB.daroca.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;




import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

@Table(name = "Driver")
@Entity(name = "Driver")
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @JsonProperty("warehouse")
    private Warehouse warehouseId;


    private String name;

    @JsonProperty("shift_start")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime shiftStart;

    @JsonProperty("shift_end")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime shiftEnd;

    @JsonProperty("break_start")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime breakStart;

    @JsonProperty("break_end")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime breakEnd;

    private double speed;

    public void Entregar(Order order) {
        // a fazer
    }

    public boolean EstaNoCentro() {
        // a fazer
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Double.compare(driver.speed, speed) == 0 &&
                Objects.equals(id, driver.id) &&
                Objects.equals(warehouseId, driver.warehouseId) &&
                Objects.equals(name, driver.name) &&
                Objects.equals(shiftStart, driver.shiftStart) &&
                Objects.equals(shiftEnd, driver.shiftEnd) &&
                Objects.equals(breakStart, driver.breakStart) &&
                Objects.equals(breakEnd, driver.breakEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, warehouseId, name, shiftStart, shiftEnd, breakStart, breakEnd, speed);
    }

    public UUID getId() {
        return id;
    }

    public Warehouse getWarehouse() {
        return warehouseId;
    }

    @JsonIgnore
    public UUID getWarehouseId() {
        return warehouseId.getId();
    }

    public String getName() {
        return name;
    }

    public LocalTime getShiftStart() {
        return shiftStart;
    }

    public LocalTime getShiftEnd() {
        return shiftEnd;
    }

    public LocalTime getBreakStart() {
        return breakStart;
    }

    public LocalTime getBreakEnd() {
        return breakEnd;
    }

    public double getSpeed() {
        return speed;
    }


}
