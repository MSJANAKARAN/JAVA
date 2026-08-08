package com.jana.solid;

public class InterfaceSegregationPrinciple {

//	Clients should not be forced to implement methods they don't need.
//
//	Suppose we create
//
//	interface BankingOperations {
//	    void transfer();
//	    void withdraw();
//	    void deposit();
//	    void calculateInterest();
//	}
//
//	Savings Account
//	class SavingsAccount implements BankingOperations {
//	    // all methods
//	}
//
//	Current accounts don't earn interest.
//	Still, calculateInterest() must be implemented.
//	Violation.

//	Split Interfaces
	interface Transfer {
		void transfer();
	}

	interface Withdraw {
		void withdraw();
	}

	interface Deposit {
		void deposit();
	}

	interface Interest {
		void calculateInterest();
	}
	
	class SavingsAccount implements Transfer, Withdraw, Deposit, Interest{

		@Override
		public void calculateInterest() {
			
		}

		@Override
		public void deposit() {
			
		}

		@Override
		public void withdraw() {
			
		}

		@Override
		public void transfer() {
			
		}
		
	}
	
	class CurrentAccount implements Transfer, Withdraw, Deposit{

		@Override
		public void deposit() {
			
		}

		@Override
		public void withdraw() {
			
		}

		@Override
		public void transfer() {
			
		}
		
	}
}
