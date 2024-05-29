package bbzbl.m246.teamautovermietung.backend.car;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
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
