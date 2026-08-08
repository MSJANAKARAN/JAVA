package com.jana.designpattern.adapter;

public class VisaGateway {

	public void makePayment(double amount) {
		System.out.println("Visa payment made for Rs."+amount);
	}
}
