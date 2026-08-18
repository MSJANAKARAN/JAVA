package com.jana.solid.paymentsystem;

public record PaymentRequest(String accName, double amt, PaymentType type) {
}
