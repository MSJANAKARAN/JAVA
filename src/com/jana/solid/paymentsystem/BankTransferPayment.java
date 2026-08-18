package com.jana.solid.paymentsystem;

import java.util.UUID;

public class BankTransferPayment implements Payment {


	@Override
	public PaymentResult pay(PaymentRequest request) {

		return new PaymentResult(true, "BT" + UUID.randomUUID().toString(), "Bank Transfer Payment successfull");
		
	}
}