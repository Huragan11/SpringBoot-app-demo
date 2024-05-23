package com.huragan11;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Integer id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public void createCustomer(String name, String email, Integer age) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAge(age);
        customerRepository.save(customer);
    }


    public void updateCustomer(Integer id, String name, String email) {
        if (customerRepository.existsById(id)) {
            Customer c = customerRepository.findById(id).orElseThrow();
            c.setName(name);
            c.setEmail(email);
            customerRepository.save(c);
        }
    }

    public void deleteCustomer(Integer id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        }
    }
}
