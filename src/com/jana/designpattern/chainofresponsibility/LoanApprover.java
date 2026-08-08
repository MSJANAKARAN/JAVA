package com.jana.designpattern.chainofresponsibility;

public abstract class LoanApprover {

	protected LoanApprover nextApprover;

	public abstract void approve(double amount);

	public void setNext(LoanApprover appr) {
		this.nextApprover = appr;
	}
}
