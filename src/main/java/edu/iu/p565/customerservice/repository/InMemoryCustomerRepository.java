package edu.iu.p565.customerservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.iu.p565.customerservice.model.Customer;


public class InMemoryCustomerRepository {

    private List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll() {
        return customers;
    }
    
    public int create(Customer customer) {
        int id = customers.size() + 1; //generate id
        customer.setId(id);

        customers.add(customer); //add customer to list
        return id;
    }

    private  Customer getCustomerById(int id){
        return customers.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

    public void update(Customer customer, int id) {

        Customer x = getCustomerById(id);
        if (x != null){
            x.setName(customer.getName());
            x.setEmail(customer.getEmail());
        }else{
            throw new IllegalStateException("customer with this is not found");
        }
    }

    public void delete(int id) {

        Customer x = getCustomerById(id);
        if (x != null){
           customers.remove(x);
        }else{
            throw new IllegalStateException("customer with this is not found");
        }
    }
}
