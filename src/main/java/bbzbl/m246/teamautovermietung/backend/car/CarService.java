package bbzbl.m246.teamautovermietung.backend.car;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bbzbl.m246.teamautovermietung.backend.rental.RentalRepository;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final RentalRepository rentalRepository;

    public CarService(CarRepository carRepository, RentalRepository rentalRepository) {
        this.carRepository = carRepository;
        this.rentalRepository = rentalRepository;
    }

    public List<CarModel> getAllCars() {
        return carRepository.findByEnabled(true);
    }

    public CarModel getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public CarModel getCarByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }

    public List<CarModel> getCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<CarModel> getCarsByModel(String model) {
        return carRepository.findByModel(model);
    }

    public List<CarModel> getCarsByColor(String color) {
        return carRepository.findByColor(color);
    }

    public List<CarModel> getCarsByFuelType(String fuelType) {
        return carRepository.findByFuelType(fuelType);
    }

    public List<CarModel> getCarsByNumberOfSeats(int numberOfSeats) {
        return carRepository.findByNumberOfSeats(numberOfSeats);
    }

    public List<CarModel> getCarsByRentalPrice(int rentalPrice) {
        return carRepository.findByRentalPrice(rentalPrice);
    }

    public List<CarModel> getCarsByConsumption(int consumption) {
        return carRepository.findByConsumption(consumption);
    }

    public List<CarModel> getCarsByEnginePower(int enginePower) {
        return carRepository.findByEnginePower(enginePower);
    }

    public List<CarModel> getCarsByMileage(int mileage) {
        return carRepository.findByMileage(mileage);
    }

    public List<CarModel> getCarsByEnabled(boolean enabled) {
        return carRepository.findByEnabled(enabled);
    }

    public List<CarModel> getCarsByDate(LocalDate startDate, LocalDate endDate) {
        return this.carRepository.findAll().stream()
                .filter(car -> isCarAvailable(car, startDate, endDate))
                .collect(Collectors.toList());
    }

    private boolean isCarAvailable(CarModel car, LocalDate startDate, LocalDate endDate) {
        return this.rentalRepository.findByCarId(car.getId()).stream()
                .noneMatch(rental -> rental.getRentalStart().isBefore(endDate.plusDays(1)) && rental.getRentalEnd().isAfter(startDate.minusDays(1)));
    }

    public CarModel saveCar(CarModel car) {
        return carRepository.save(car);
    }

    public CarModel updateCar(CarModel car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
