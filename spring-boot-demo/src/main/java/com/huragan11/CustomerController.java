package com.huragan11;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Integer customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        customerService.createCustomer(request.name(), request.email(), request.age());
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody UpdateCustomerRequest customerRequest) {
        customerService.updateCustomer(id, customerRequest.name(), customerRequest.email());
    }

    record UpdateCustomerRequest(
            @RequestParam("name") String name,
            @RequestParam("email") String email
    ) {
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ) {
    }

}
