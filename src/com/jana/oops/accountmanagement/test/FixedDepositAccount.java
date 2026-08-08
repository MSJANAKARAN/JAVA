package com.jana.oops.accountmanagement.test;

public class FixedDepositAccount extends Account{

	AccountDTO acc2 = new AccountDTO();

	public FixedDepositAccount(String accNo, String name, double bal) {
		super.displayBalance();
		acc2.setAccountNo(accNo);
		acc2.setCustName(name);
		acc2.setBalance(bal);
	}

	@Override
	void deposit(double amt) {
		throw new RuntimeException("Exceeds Deposit limit");
		
	}

	@Override
	void withdraw(double amt) {
		throw new RuntimeException("Withdrawal not allowed before maturity.");

	}
	
	
	@Override
	void displayBalance() {
		System.out.println(acc2.getAccountNo() + " Balance: " + acc2.getBalance());
	}
	

}
