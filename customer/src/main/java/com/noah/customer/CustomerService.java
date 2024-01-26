package com.noah.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
  
  public void registerCustomer(CustomerRegistrationRequest customerRequest) {
    Customer customer = Customer.builder()
        .firstName(customerRequest.firstName())
        .lastName(customerRequest.lastName())
        .email(customerRequest.email()).build();
    // TODO: check if email valid
    // TODO: check email taken
    customerRepository.save(customer);
  }
}
