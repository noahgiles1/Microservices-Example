package com.noah.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
  
  private final CustomerService customerService;
  
  @PostMapping("/register")
  public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
    log.info("New customer registration {}", customerRequest);
    customerService.registerCustomer(customerRequest);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
    return null;
  }
}
