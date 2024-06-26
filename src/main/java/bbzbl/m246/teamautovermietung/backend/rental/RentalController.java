package bbzbl.m246.teamautovermietung.backend.rental;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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

@RestController
@RequestMapping("/api/rental")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public ResponseEntity<List<RentalModel>> getAllRentals() {
        List<RentalModel> rentals = rentalService.getAllRentals();
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalModel> getRentalById(@PathVariable Long id) {
        RentalModel rental = rentalService.getRental(id);
        if (rental == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rental);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RentalModel>> getRentalsByUserId(@PathVariable Long userId) {
        List<RentalModel> rentals = rentalService.getRentalsByUserId(userId);
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<RentalModel>> getRentalsByCarId(@PathVariable Long carId) {
        List<RentalModel> rentals = rentalService.getRentalsByCarId(carId);
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<RentalModel>> getRentalsByStatus(@PathVariable String status) {
        List<RentalModel> rentals = rentalService.getRentalsByStatus(status);
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/user/{userId}/car/{carId}")
    public ResponseEntity<List<RentalModel>> getRentalsByUserIdAndCarId(@PathVariable Long userId,
            @PathVariable Long carId) {
        List<RentalModel> rentals = rentalService.getRentalsByUserIdAndCarId(userId, carId);
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/byDate")
    public ResponseEntity<List<RentalModel>> getRentalsByDate(
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(rentalService.getByDate(startDate, endDate));
    }

    @GetMapping("/byDate/user/{id}")
    public ResponseEntity<List<RentalModel>> getRentalsByUserIdAndDate(@PathVariable Long id,
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(rentalService.getByDateAndUserId(id, startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<RentalModel> createRental(@RequestBody RentalModel rental) {
        RentalModel createdRental = rentalService.createRental(rental);
        return ResponseEntity.ok(createdRental);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalModel> updateRental(@PathVariable Long id, @RequestBody RentalModel rental) {
        rental.setId(id);
        RentalModel updatedRental = rentalService.updateRental(rental);
        return ResponseEntity.ok(updatedRental);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
        return ResponseEntity.ok().build();
    }

}
