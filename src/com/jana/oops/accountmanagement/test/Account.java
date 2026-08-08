package com.jana.oops.accountmanagement.test;

//Abstraction
abstract class Account {

	abstract void deposit(double amt);
	
	abstract void withdraw(double amt) ;
	
	void displayBalance() {
		System.out.println("No Valid Account to show Balance");
	}
	
}
