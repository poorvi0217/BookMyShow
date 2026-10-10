package project.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.BookMyShow.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomerPhoneOrderByBookedAtDesc(String customerPhone);

    Optional<Booking> findByIdAndCustomerPhone(Long id ,String customerPhone);

    List<Booking> findByCustomerIdOrderByBookedAtDesc(Long customerId);

    Optional<Booking> findByIdAndCustomerId(Long id , Long customerId);
}
