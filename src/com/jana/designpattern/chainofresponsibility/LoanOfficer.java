package com.jana.designpattern.chainofresponsibility;

public class LoanOfficer extends LoanApprover {

	@Override
	public void approve(double amount) {
		if (amount <= 500000) {
			System.out.print("Loan is approved by Loan officer.");
			return;
		}

		nextApprover.approve(amount);
	}

}
