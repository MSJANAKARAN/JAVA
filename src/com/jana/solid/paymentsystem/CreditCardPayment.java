package com.jana.solid.paymentsystem;

import java.util.UUID;

public class CreditCardPayment implements Payment {

	@Override
	public PaymentResult pay(PaymentRequest request) {

		return new PaymentResult(true, "CC" + UUID.randomUUID().toString(), "Credit Card Payment successfull");
		
	}
}