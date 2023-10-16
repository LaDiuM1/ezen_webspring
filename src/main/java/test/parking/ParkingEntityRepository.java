package test.parking;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingEntityRepository extends JpaRepository<ParkingEntity, Integer> {
}
