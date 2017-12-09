package camt.cbsd.lab05.repository;

import camt.cbsd.lab05.entity.security.Cart;
import camt.cbsd.lab05.entity.security.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAll();
    Customer findByCustomerId(String customerId);
}
