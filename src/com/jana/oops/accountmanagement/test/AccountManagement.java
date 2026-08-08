package com.jana.oops.accountmanagement.test;

public class AccountManagement {

	public static void main(String[] args) {

		Account acc1 = new CurrentAccount("ACC1", "Name1", 100000.00);

		Account acc2 = new SavingsAccount("ACC2", "Name2", 150000.00);

		Account acc3 = new FixedDepositAccount("ACC3", "Name3", 200000.00);

		acc1.deposit(2000);

		acc2.deposit(5000);

		acc3.deposit(3000);

		acc1.withdraw(20000);

		acc2.withdraw(2500);

		acc3.withdraw(40000);

		acc1.displayBalance();

		acc2.displayBalance();

		acc3.displayBalance();

	}

}
