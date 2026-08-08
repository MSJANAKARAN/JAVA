package com.jana.designpattern.chainofresponsibility;

public class RegionalManager extends LoanApprover{

	@Override
	public void approve(double amount) {
		if(amount<=10000000) {
			System.out.print("Loan is approved by Regional Manager.");
			return;
		}
		nextApprover.approve(amount);
	}

}
