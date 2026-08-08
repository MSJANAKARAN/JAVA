package com.jana.designpattern.observer;

public class SMSObserver implements Observer {

	@Override
	public void update(Transaction transaction) {
		System.out.println("SMS sent for transaction of Rs." + transaction.amount());

	}

}
