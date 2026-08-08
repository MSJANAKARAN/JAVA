package com.jana.oops.accountmanagement.evaluation;

public class SavingsAccount extends Account {

	public static final double SAVINGS_LIMIT = 1000;

	public SavingsAccount(String accNo, String name, double bal) {
		super(accNo, name, bal);

	}

	@Override
	void deposit(double amt) {
		setBalance(getBalance() + amt);

	}

	@Override
	void withdraw(double amt) {
		double newBal = getBalance() - amt;
		if (newBal < SAVINGS_LIMIT) {
			throw new IllegalStateException("Exceeds Withdrawal limit");
		}
		setBalance(newBal);
	}

}
