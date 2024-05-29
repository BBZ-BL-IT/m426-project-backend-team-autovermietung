package bbzbl.m246.teamautovermietung.backend.rental;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalModel, Long>{
    public List<RentalModel> findByUserId(Long userId);
    public List<RentalModel> findByCarId(Long carId);
    public List<RentalModel> findByStatus(String status);
    public List<RentalModel> findByUserIdAndCarId(Long userId, Long carId);
}
