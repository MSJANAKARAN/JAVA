package com.jana.designpattern.chainofresponsibility;

public class HeadOfficer extends LoanApprover{

	@Override
	public void approve(double amount) {
		System.out.print("Loan is approved by Head Officer.");
	}

}
