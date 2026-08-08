package com.jana.designpattern.strategy;

public class StrategyTest {

//	Behavioural Design Pattern ###
//	Strategy Design Pattern defines a family of algorithms, encapsulates each one 
//	into a separate class, and allows the algorithm to be selected at runtime.
//	Instead of using multiple if-else or switch statements, each algorithm is placed in its own class.
//	Strategy allows you to change the behaviour of an object at runtime by 
//	selecting different implementations of a common interface.
//	
//	Real Banking Scenario
//	A bank supports multiple payment methods:
//	UPI
//	Credit Card
//	NEFT
//	RTGS
//
//	The payment process differs for each method, but the client simply wants to make a payment.
//	
//	Factory Pattern → Decides which strategy to create.
//	Strategy Pattern → Defines how the chosen algorithm works.

	public static void main(String[] args) {
		Payment strategy = new UpiPayment();

		PaymentService service = new PaymentService(strategy);

		service.makePayment(1000);
		
//		We can call strategy.pay() directly in simple programs, but in enterprise applications 
//		the service layer contains the complete business workflow, such as validation, balance checks, 
//		transaction persistence, notifications, and auditing. The Strategy pattern is used only for the part of the 
//		workflow that varies, such as UPI, Card, or NEFT payment processing. This separation keeps the 
//		business process centralized, avoids code duplication, and follows the Single Responsibility Principle.
	}

}
