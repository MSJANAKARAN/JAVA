package com.jana.designpattern.factory;

public class CardPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("Card payment of Rs."+amount+" has been successfull.");
	}

}
