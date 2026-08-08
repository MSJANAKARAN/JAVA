package com.jana.designpattern.factory;

public class FactoryTest {
//	Creational Design Pattern ###
//	The Factory Design Pattern provides a way to create objects without exposing the object creation logic to the client.
//	or
//  The Factory Pattern encapsulates object creation logic and returns the appropriate object based on the given input.
//	Instead of the client using new directly, it asks a Factory to create the required object.
//
//	A bank supports multiple payment methods:
//
//		UPI
//		Credit Card
//		NEFT
//		RTGS
//
//		The client shouldn't know how each payment object is created.
//	
//	Factory Pattern → Decides which strategy to create.
//	Strategy Pattern → Defines how the chosen algorithm works.
	
	public static void main(String[] args) {
		try {
			Payment payment = PaymentFactory.getPayment("NEFT");
			payment.pay(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
