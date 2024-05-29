package bbzbl.m246.teamautovermietung.backend.car;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

    
@Entity
@Data
@Table(name = "cars")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "color", nullable = false)
    private String color;
    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;
    @Column(name = "mileage", nullable = false)
    private int mileage;
    @Column(name = "engine_power", nullable = false)
    private int enginePower;
    @Column(name = "fuel_type", nullable = false)
    private String fuelType;
    @Column(name = "number_of_seats", nullable = false)
    private int numberOfSeats;
    @Column(name = "rental_price", nullable = false) //daily
    private int rentalPrice; 
    @Column(name = "consumption", nullable = false) // per 100km
    private int consumption; 
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
}


