package com.jana.solid;

public class LiskovSubstitutionPrinciple {

//	A child class should be replaceable for its parent without breaking the program.
//
//	Suppose every account supports transfer.
//	class Account {
//	    void transfer(double amount) {
//	        System.out.println("Transfer Successful");
//	    }
//	}
//
//	Savings Account
//	class SavingsAccount extends Account {
//
//	}
//
//	Current Account
//	class CurrentAccount extends Account {
//
//	}
//
//	Now
//	Account account = new SavingsAccount();
//	account.transfer(1000);
//
//	Works perfectly.
//	Now imagine
//
//	class FixedDepositAccount extends Account {
//	    @Override
//	    void transfer(double amount) {
//	        throw new UnsupportedOperationException();
//	    }
//	}
//
//	FD accounts cannot transfer money.
//	Now
//	Account account = new FixedDepositAccount();
//	account.transfer(1000);
//	Application crashes.
//
//	LSP is violated because FixedDepositAccount cannot safely replace Account.

	class Account {

	}

	class TransferrableAccount extends Account {
		void transfer(double amount) {
			System.out.println("Transfer Successful");
		}
	}

	class SavingsAccount extends TransferrableAccount {

	}

	class CurrentAccount extends TransferrableAccount {

	}

	class FixedDepositAccount extends Account{
		
	}
}
