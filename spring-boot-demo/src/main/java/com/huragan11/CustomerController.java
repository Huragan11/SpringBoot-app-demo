package com.huragan11;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") Integer customerId) {
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }

    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody NewCustomerRequest request) {
        customerService.createCustomer(request.getName(), request.getEmail(), request.getAge());
        return ResponseEntity.ok("Customer created");
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted");

    }

    @PutMapping("{customerId}")
    public ResponseEntity<String> updateCustomer(
            @PathVariable("customerId") Integer id,
            @RequestBody UpdateCustomerRequest customerRequest) {
        customerService.updateCustomer(id, customerRequest.getName(), customerRequest.getEmail());
        return ResponseEntity.ok("Customer updated");
    }

}
