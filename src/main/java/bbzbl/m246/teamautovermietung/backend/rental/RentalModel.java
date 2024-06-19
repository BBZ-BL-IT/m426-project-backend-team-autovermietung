package bbzbl.m246.teamautovermietung.backend.rental;

import bbzbl.m246.teamautovermietung.backend.car.CarModel;
import bbzbl.m246.teamautovermietung.backend.user.UserModel;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "rentals")
public class RentalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CarModel car;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserModel user;

    @Column(name = "rental_start", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate rentalStart;

    @Column(name = "rental_end", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate rentalEnd;

    @Column(name = "total_cost", nullable = false)
    private double totalCost;

    @Column(name = "status", nullable = false)
    private String status;

    
}
