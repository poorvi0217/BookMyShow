package project.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.BookMyShow.entity.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer , Long> {

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByPhone(String phone);
}
