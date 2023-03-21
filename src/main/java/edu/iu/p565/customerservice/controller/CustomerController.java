package edu.iu.p565.customerservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.iu.p565.customerservice.model.Customer;
import edu.iu.p565.customerservice.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository repository;

    
    public CustomerController(CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    @GetMapping
    public List<Customer> findALL() {
        return repository.findAll();
    }

    @PostMapping
    public int create(@RequestBody Customer customer) {
        return repository.create(customer);
    }
    
}
