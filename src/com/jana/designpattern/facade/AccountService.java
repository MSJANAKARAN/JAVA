package com.jana.designpattern.facade;

import java.util.Objects;

public class AccountService {

	public void authenticate(String user) {
		if (Objects.isNull(user)) {
			System.out.println("User Authentication Failed");
		} else {
			System.out.println("User Authentication Successfull");

		}

	}

	public void debit(String fromAccount, double amount) {
		// TODO Auto-generated method stub
		System.out.println("Rs." + amount + " debited successfully from Account: " + fromAccount);

	}

	public void credit(String toAccount, double amount) {
		// TODO Auto-generated method stub
		System.out.println("Rs." + amount + " credited successfully to Account: " + toAccount);

	}
}
