package camt.cbsd.lab05.dao.customer;

import camt.cbsd.lab05.entity.security.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getAllCustomers();
    void addCustomer(Customer customer);
    Customer getCustomerById(String customerId);
    void deleteCustomer(String customerId);
}
