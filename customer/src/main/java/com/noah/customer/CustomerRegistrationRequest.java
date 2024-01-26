package com.noah.customer;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email
) {}
