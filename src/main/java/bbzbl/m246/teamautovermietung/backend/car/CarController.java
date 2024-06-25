package bbzbl.m246.teamautovermietung.backend.car;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarModel>> getEnabledCars() {
        return ResponseEntity.ok(carService.getCarsByEnabled(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarModel> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/licensePlate/{licensePlate}")
    public ResponseEntity<CarModel> getCarByLicensePlate(@PathVariable String licensePlate) {
        return ResponseEntity.ok(carService.getCarByLicensePlate(licensePlate));
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<CarModel>> getCarsByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(carService.getCarsByBrand(brand));
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<CarModel>> getCarsByModel(@PathVariable String model) {
        return ResponseEntity.ok(carService.getCarsByModel(model));
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<CarModel>> getCarsByColor(@PathVariable String color) {
        return ResponseEntity.ok(carService.getCarsByColor(color));
    }

    @GetMapping("/fuelType/{fuelType}")
    public ResponseEntity<List<CarModel>> getCarsByFuelType(@PathVariable String fuelType) {
        return ResponseEntity.ok(carService.getCarsByFuelType(fuelType));
    }

    @GetMapping("/numberOfSeats/{numberOfSeats}")
    public ResponseEntity<List<CarModel>> getCarsByNumberOfSeats(@PathVariable int numberOfSeats) {
        return ResponseEntity.ok(carService.getCarsByNumberOfSeats(numberOfSeats));
    }

    @GetMapping("/rentalPrice/{rentalPrice}")
    public ResponseEntity<List<CarModel>> getCarsByRentalPrice(@PathVariable int rentalPrice) {
        return ResponseEntity.ok(carService.getCarsByRentalPrice(rentalPrice));
    }

    @GetMapping("/consumption/{consumption}")
    public ResponseEntity<List<CarModel>> getCarsByConsumption(@PathVariable int consumption) {
        return ResponseEntity.ok(carService.getCarsByConsumption(consumption));
    }

    @GetMapping("/enginePower/{enginePower}")
    public ResponseEntity<List<CarModel>> getCarsByEnginePower(@PathVariable int enginePower) {
        return ResponseEntity.ok(carService.getCarsByEnginePower(enginePower));
    }

    @GetMapping("/mileage/{mileage}")
    public ResponseEntity<List<CarModel>> getCarsByMileage(@PathVariable int mileage) {
        return ResponseEntity.ok(carService.getCarsByMileage(mileage));
    }

    @GetMapping("/disabled")
    public ResponseEntity<List<CarModel>> getDisabledCars() {
        return ResponseEntity.ok(carService.getCarsByEnabled(false));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarModel>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping
    public ResponseEntity<CarModel> createCar(@RequestBody CarModel car) {
        return ResponseEntity.ok(carService.saveCar(car));
    }

    @GetMapping("/byDate")
    public ResponseEntity<List<CarModel>> getCarsByDate(
        @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, 
        @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return ResponseEntity.ok(carService.getCarsByDate(startDate, endDate));
    }

    @GetMapping("/byDate/{id}")
    public ResponseEntity<Boolean> getCarsByDate(
        @PathVariable() Long id,
        @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, 
        @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return ResponseEntity.ok(carService.isCarAvailable(id, startDate, endDate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarModel> updateCarById(@PathVariable Long id, @RequestBody CarModel car) {
        car.setId(id);
        return ResponseEntity.ok(carService.updateCar(car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
