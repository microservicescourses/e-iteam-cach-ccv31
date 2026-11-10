package tn.iteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iteam.entities.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // select * from customer
    Optional<Customer> findByMobileNumber (String mobileNumber);
}
