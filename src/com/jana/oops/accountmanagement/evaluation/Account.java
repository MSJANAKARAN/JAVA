package com.jana.oops.accountmanagement.evaluation;

//Abstraction
abstract class Account {

	abstract void deposit(double amt);

	abstract void withdraw(double amt);

	void displayBalance() {
		
		System.out.println(getAccountNo() + " Balance: " + getBalance());
	}

	// Encapsulation

	private String AccountNo;

	private String custName;

	private double balance;

	public Account(String acc, String name, double bal) {
		this.AccountNo = acc;
		this.custName = name;
		this.balance = bal;
	}

	public String getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [AccountNo=" + AccountNo + ", custName=" + custName + ", balance=" + balance
				+ ", getAccountNo()=" + getAccountNo() + ", getCustName()=" + getCustName() + ", getBalance()="
				+ getBalance() + "]";
	}

	
}
