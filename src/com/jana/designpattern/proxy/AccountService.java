package com.jana.designpattern.proxy;

public class AccountService implements AccountInterface{

	@Override
	public void viewBalance(String accountNo) {
		//Actual balance fetching business layer
		
		//.formatted offcially introduced in java 15
		System.out.println("Available Balance in Bank Account [%s] is Rs.%d.".formatted(accountNo,20000));
		
	}

}
