package com.jana.oops.accountmanagement.test;

public class SavingsAccount extends Account {

	AccountDTO acc3 = new AccountDTO();

	public SavingsAccount(String accNo, String name, double bal) {
		acc3.setAccountNo(accNo);
		acc3.setCustName(name);
		acc3.setBalance(bal);
	}
	

	@Override
	void deposit(double amt) {
		acc3.setBalance(acc3.getBalance() + amt);

		
	}

	@Override
	void withdraw(double amt) {
		double newBal = acc3.getBalance() - amt;
		if (newBal < 1000) {
			throw new RuntimeException("Exceeds Withdrawal limit");
		}
		acc3.setBalance(newBal);
	}
	
	@Override
	void displayBalance() {
		System.out.println(acc3.getAccountNo() + " Balance: " + acc3.getBalance());
	}
}
