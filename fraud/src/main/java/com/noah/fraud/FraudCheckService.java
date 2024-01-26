package com.noah.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
  
  private final FraudRepository fraudRepository;

  public boolean isFraudulentCustomer(Integer customerId) {
    // TODO actually check
    boolean isFraudulent = false;
    fraudRepository.save(
        FraudCheckHistory.builder()
            .customerId(customerId)
            .isFraudster(isFraudulent)
            .createdAt(LocalDateTime.now())
            .build()
    );
    return isFraudulent;
  }
}
