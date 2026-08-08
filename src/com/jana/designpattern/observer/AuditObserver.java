package com.jana.designpattern.observer;

public class AuditObserver implements Observer{

	@Override
	public void update(Transaction transaction) {
		System.out.println("Audit sent for transaction of Rs."+transaction.amount());

	}

}
