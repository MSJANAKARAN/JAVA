package com.jana.designpattern.builder;

public class LoanApplication {

	private String customerName;
	private double loanAmount;
	private double interestRate;
	private int tenure;
	private boolean insurance;
	private String collateral;

	//private constructor, so that we cannot create object with constructor injection
	private LoanApplication(Builder builder) {
		this.customerName = builder.customerName;
		this.loanAmount = builder.loanAmount;
		this.interestRate = builder.interestRate;
		this.tenure = builder.tenure;
		this.insurance = builder.insurance;
		this.collateral = builder.collateral;
	}

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

		public Builder interestRate(double rate) {
			this.interestRate = rate;
			return this;
		}

		public Builder tenure(int months) {
			this.tenure = months;
			return this;
		}

		public Builder insurance(boolean insurance) {
			this.insurance = insurance;
			return this;
		}

		public Builder collateral(String collateral) {
			this.collateral = collateral;
			return this;
		}

		public LoanApplication build() {
			return new LoanApplication(this);
		}

	}
}
