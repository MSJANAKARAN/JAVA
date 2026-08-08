package com.jana.oops.accountmanagement.evaluation;

public class CurrentAccount extends Account {

	public static final double CURRENT_LIMIT = -10000;
	
	public CurrentAccount(String accNo, String name, double bal) {
		super(accNo,name,bal);

	}

	@Override
	void deposit(double amt) {
		setBalance(getBalance() + amt);
	}

	@Override
	void withdraw(double amt) {
		double newBal = getBalance() - amt;
		if (newBal <= CURRENT_LIMIT) {
			throw new IllegalStateException("Exceeds Overdraft limit");
		}
		setBalance(newBal);
	}

}
