package com.jana.designpattern.builder;

public class BuilderTest {
//	Creational Design Pattern ###
//	Builder Design Pattern is used to construct complex objects step by step, 
//	especially when an object has many optional fields.
//	Builder pattern separates the construction of a complex object from its representation, 
//	allowing the same construction process to create different object configurations.
//	
//	Instead of using large constructors with many parameters, Builder creates the object in a 
//	readable and flexible way. Creates a new object every time
//	
//	Real Banking Scenario
//
//	Suppose a customer applies for a loan.
//
//	A loan application contains:
//	Customer Name (Mandatory)
//	Loan Amount (Mandatory)
//	Interest Rate
//	Tenure
//	Co-applicant
//	Insurance
//	Processing Fee
//	EMI Option
//	Collateral
//
//	Using a constructor becomes difficult.
//	
//	HttpClient, WebClient, RestClient follow builder design pattern
//	Instead of writing the Builder manually, can also use Lombok @Builder in spring boot, 

	public static class Builder {

		// Mandatory fields
		private String customerName;
		private double loanAmount;
		// Optional fields
		private double interestRate;
		private int tenure;
		private boolean insurance;
		private String collateral;

		public Builder(String customerName, double loanAmount) {
			this.customerName = customerName;
			this.loanAmount = loanAmount;
		}

	}

	public static void main(String[] args) {

		LoanApplication loan = new LoanApplication.Builder("John", 10000)
				.interestRate(6.5).collateral("House").insurance(true).build();
		
		System.out.println("Loan Created");

	}

}
