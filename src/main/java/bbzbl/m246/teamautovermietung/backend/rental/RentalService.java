package bbzbl.m246.teamautovermietung.backend.rental;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RentalService {
    
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public RentalModel createRental(RentalModel rental) {
        return rentalRepository.save(rental);
    }

    public RentalModel updateRental(RentalModel rental) {
        return rentalRepository.save(rental);
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }

    public RentalModel getRental(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public List<RentalModel> getAllRentals() {
        return rentalRepository.findAll();
    }

    public List<RentalModel> getRentalsByUserId(Long userId) {
        return rentalRepository.findByUserId(userId);
    }

    public List<RentalModel> getRentalsByCarId(Long carId) {
        return rentalRepository.findByCarId(carId);
    }

    public List<RentalModel> getRentalsByStatus(String status) {
        return rentalRepository.findByStatus(status);
    }

    public List<RentalModel> getRentalsByUserIdAndCarId(Long userId, Long carId) {
        return rentalRepository.findByUserIdAndCarId(userId, carId);
    }

    public List<RentalModel> getByDate(LocalDate startDate, LocalDate endDate) {
        return rentalRepository.findAll().stream()
                .filter(rental -> rental.getRentalStart().isAfter(startDate) && rental.getRentalEnd().isBefore(endDate))
                .collect(Collectors.toList());
    }

    public List<RentalModel> getByDateAndUserId(Long id, LocalDate startDate, LocalDate endDate) {
        return rentalRepository.findByUserId(id).stream()
                .filter(rental -> rental.getRentalStart().isAfter(startDate) && rental.getRentalEnd().isBefore(endDate))
                .collect(Collectors.toList());

    }
}
