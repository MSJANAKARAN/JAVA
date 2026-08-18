package com.jana.solid.paymentsystem;

public record PaymentResult(boolean status, String transactionId, String message) {

}
