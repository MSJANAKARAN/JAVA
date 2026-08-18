package com.jana.solid.paymentsystem;

import java.util.UUID;

public class UPIPayment implements Payment {

	@Override
	public PaymentResult pay(PaymentRequest request) {

		return new PaymentResult(true, "UPI" + UUID.randomUUID().toString(), "UPI Payment successfull");
		
	}
}
