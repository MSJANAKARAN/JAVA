package com.jana.oops.accountmanagement.evaluation;

//Here Liskov Substitution Principle Violated
public class FixedDepositAccount extends Account {

	public FixedDepositAccount(String accNo, String name, double bal) {
		super(accNo, name, bal);

	}

	@Override
	void deposit(double amt) {
		throw new UnsupportedOperationException("Exceeds Deposit limit");

	}

	@Override
	void withdraw(double amt) {
		throw new UnsupportedOperationException("Withdrawal not allowed before maturity.");

	}

}
