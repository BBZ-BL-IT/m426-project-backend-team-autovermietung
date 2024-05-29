package bbzbl.m246.teamautovermietung.backend.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarModel, Long>{
    public CarModel findByLicensePlate(String licensePlate);
    public List<CarModel> findByBrand(String brand);
    public List<CarModel> findByModel(String model);
    public List<CarModel> findByColor(String color);
    public List<CarModel> findByFuelType(String fuelType);
    public List<CarModel> findByNumberOfSeats(int numberOfSeats);
    public List<CarModel> findByEnabled(boolean enabled);
    public List<CarModel> findByRentalPrice(int rentalPrice);
    public List<CarModel> findByConsumption(int consumption);
    public List<CarModel> findByEnginePower(int enginePower);
    public List<CarModel> findByMileage(int mileage);
}
