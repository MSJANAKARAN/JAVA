package com.jana.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

	List<Observer> observers = new ArrayList<>();

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	public void transfer(double amt) {
		System.out.println("Transferred Rs."+amt);
		
		Transaction transaction = new Transaction(amt);
	    updateObserver(transaction);
	}

	private void updateObserver(Transaction t) {
		for (Observer observer : observers) {
			observer.update(t);
		}
	}

}
