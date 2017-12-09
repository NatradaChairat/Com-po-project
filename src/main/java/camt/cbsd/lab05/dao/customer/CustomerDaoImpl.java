package camt.cbsd.lab05.dao.customer;

import camt.cbsd.lab05.entity.security.Customer;
import camt.cbsd.lab05.repository.CustomerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return Lists.newArrayList(this.customerRepository.findAll());
    }

    @Override
    public void addCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return this.customerRepository.findByCustomerId(customerId);
    }

    @Override
    public void deleteCustomer(String customerId) {
        Customer customer = this.getCustomerById(customerId);
        this.customerRepository.delete(customer);

    }
}
