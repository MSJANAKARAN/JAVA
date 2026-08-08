package com.jana.designpattern.adapter;

public class AdapterTest{
//	Structural Design Pattern ###
//	 Adapter Design Pattern allows two incompatible interfaces to work together by introducing an 
//	 Adapter that converts one interface into another expected by the client.
//
//	 Acts as a bridge between incompatible interfaces so existing code can work with third-party or legacy systems without modification.
//	
//	Suppose a bank supports UPI payments. Now the bank integrates with a third-party payment gateway like Visa or Mastercard.
//	The bank expects: pay(amount). But Visa SDK provides: makePayment(amount)
//	The method names and interfaces don't match.
//	An Adapter solves this problem.
	
	public static void main(String[] args) {

		Payment payment = new VisaAdapter(new VisaGateway());
		
		payment.pay(2000.50);
	}


}
