package camt.cbsd.lab05.controller;


import camt.cbsd.lab05.entity.security.Customer;
import camt.cbsd.lab05.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> customers = this.customerService.getAllCustomers();
        if (customers.size() != 0) {
            return ResponseEntity.ok(customers);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
        Customer customer = this.customerService.getCustomer(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        this.customerService.addCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/customer/{customerId}")
    public boolean deleteCustomer(@PathVariable String customerId) {
        this.customerService.deleteCustomer(customerId);
        return true;
    }
}
