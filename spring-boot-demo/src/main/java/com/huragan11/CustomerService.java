package com.huragan11;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElseThrow();
    }

    public void createCustomer(String name, String email, Integer age) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAge(age);
        customerRepository.save(customer);
    }


    public void updateCustomer(Integer id, String name, String email) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (!customer.isPresent()) {
            throw new NoSuchElementException();
        }

        customer.get().setName(name);
        customer.get().setEmail(email);

        customerRepository.save(customer.get());
    }

    public void deleteCustomer(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }

}
