package com.jana.designpattern.strategy;

public class PaymentService {

	private Payment payment;
	
	public PaymentService(Payment payment) {
		this.payment = payment;
	}
	
	public void makePayment(double amount) {
		payment.pay(amount);
	}

}
