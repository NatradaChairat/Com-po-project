package camt.cbsd.lab05.service.customer;

import camt.cbsd.lab05.entity.security.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void addCustomer(Customer customer);
    Customer getCustomer(String customerId);
    void deleteCustomer(String customerId);
}
