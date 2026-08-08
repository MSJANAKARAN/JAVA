package com.jana.designpattern.observer;

public class EmailObserver implements Observer{
	
	@Override
	public void update(Transaction transaction) {
		System.out.println("Email sent for transaction of Rs."+transaction.amount());
	}
}
