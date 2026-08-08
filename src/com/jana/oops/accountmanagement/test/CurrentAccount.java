package com.jana.oops.accountmanagement.test;

public class CurrentAccount extends Account {

	AccountDTO acc1 = new AccountDTO();

	public CurrentAccount(String accNo, String name, double bal) {
		acc1.setAccountNo(accNo);
		acc1.setCustName(name);
		acc1.setBalance(bal);
	}

	@Override
	void deposit(double amt) {
		acc1.setBalance(acc1.getBalance() + amt);
	}

	@Override
	void withdraw(double amt) {
		double newBal = acc1.getBalance() - amt;
		if (newBal <= -10000) {
			throw new RuntimeException("Exceeds Overdraft limit");
		}
		acc1.setBalance(newBal);
	}

	@Override
	void displayBalance() {
		System.out.println(acc1.getAccountNo() + " Balance: " + acc1.getBalance());
	}

}
