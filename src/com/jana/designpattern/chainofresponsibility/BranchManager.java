package com.jana.designpattern.chainofresponsibility;

public class BranchManager extends LoanApprover {

	@Override
	public void approve(double amount) {
		if(amount<=2500000) {
			System.out.print("Loan is approved by Branch Manager.");
			return;
		}
		nextApprover.approve(amount);
	}

}
