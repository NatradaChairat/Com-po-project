package camt.cbsd.lab05.service.customer;

import camt.cbsd.lab05.dao.customer.CustomerDao;
import camt.cbsd.lab05.entity.security.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerDao.getAllCustomers();
    }

    @Override
    public void addCustomer(Customer customer) {
        this.customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomer(String customerId) {
        return this.customerDao.getCustomerById(customerId);
    }

    @Override
    public void deleteCustomer(String customerId) {
        this.customerDao.deleteCustomer(customerId);
    }
}
