package com.jana.oops.accountmanagement.test;

public class AccountDTO {

	//Encapsulation

	private String AccountNo;
	
	private String custName;
	
	private double balance;

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
		return "AccountDTO [AccountNo=" + AccountNo + ", custName=" + custName + ", balance=" + balance + "]";
	}
	
	
}
