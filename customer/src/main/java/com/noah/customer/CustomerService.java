package com.noah.customer;

import com.noah.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
  
  private final CustomerRepository customerRepository;
  private final RestTemplate restTemplate;
  
  public void registerCustomer(CustomerRegistrationRequest customerRequest) {
    Customer customer = Customer.builder()
        .firstName(customerRequest.firstName())
        .lastName(customerRequest.lastName())
        .email(customerRequest.email()).build();
    // TODO: check if email valid
    // TODO: check email taken
    customerRepository.saveAndFlush(customer);
    
    FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
        "http://localhost:8081/api/v1/fraud-check/{customerId}",
        FraudCheckResponse.class,
        customer.getId()
    );
    
    assert fraudCheckResponse != null;
    if (Boolean.TRUE.equals(fraudCheckResponse.isFraudster())) {
      throw new IllegalStateException("uh oh");
    }
    // TODO: send notification
  }
}
