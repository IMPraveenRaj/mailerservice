package com.springheaven.Mailer.repository;




import com.springheaven.Mailer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByMembershipExpiryDateBefore(LocalDate date);
}
