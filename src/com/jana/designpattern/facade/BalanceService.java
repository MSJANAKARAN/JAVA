package com.jana.designpattern.facade;

public class BalanceService {

	public boolean hasSufficientBalance(double balance,double amount) {
		// TODO Auto-generated method stub
		if(balance>=amount) {
			System.out.println("Account Balance Verified.");
			return true;
		}
		
		System.out.println("Insufficient Account Balance Detected.");
		
		return false;
	}

}
