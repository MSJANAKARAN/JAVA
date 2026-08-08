package com.jana.solid;

public class OpenClosedPrinciple {

//	Open for extension but closed for modification.
//
//	Suppose the bank charges different transfer fees.
//
//	❌ Bad Design
//	class FeeCalculator {
//	    double calculate(String accountType) {
//	        if(accountType.equals("Savings"))
//	            return 5;
//	        if(accountType.equals("Current"))
//	            return 10;
//	        return 0;
//	    }
//	}
//
//	Tomorrow,
//	Salary Account
//	Premium Account
//	NRI Account
//	Every time you edit this class.
	
	interface FeeCalculator{
		double calculate();
	}
	
	class SavingsCalculator implements FeeCalculator{
		@Override
		public double calculate() {
			return 5;
		}
	}
	
	class CurrentCalculator implements FeeCalculator{
		@Override
		public double calculate() {
			return 10;
		}
	}
//	If we need to create new calculator, Existing code remains unchanged.
}
