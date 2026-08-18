package com.jana.oops.accountmanagement.evaluation;

public class AccountManagement {

	public static void main(String[] args) {

		Account current = new CurrentAccount("ACC1", "Name1", 100000.00);

		Account savings = new SavingsAccount("ACC2", "Name2", 150000.00);

		Account fd = new FixedDepositAccount("ACC3", "Name3", 200000.00);

		current.deposit(2000);

		savings.deposit(5000);

		try {
			fd.deposit(3000);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		current.withdraw(20000);

		savings.withdraw(2500);

		try {
			fd.withdraw(40000);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		current.displayBalance();

		savings.displayBalance();

		fd.displayBalance();

		System.out.println(current.toString());
		System.out.println(savings.toString());
		System.out.println(fd.toString());

	}

}
