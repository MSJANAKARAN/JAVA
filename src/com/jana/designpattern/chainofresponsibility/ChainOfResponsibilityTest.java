package com.jana.designpattern.chainofresponsibility;

public class ChainOfResponsibilityTest {

//	Behavioural Design Pattern
//	Chain of Responsibility (CoR) pattern passes a request through a chain of handlers. 
//	Each handler decides whether it can process the request. If it cannot, it forwards the request to the next handler in the chain.
//	The Chain of Responsibility pattern allows multiple objects to handle a request 
//	sequentially without the sender knowing which object will ultimately process it.
//	
//	Real Banking Scenario
//	Suppose a customer applies for a loan.
//	Approval limits are:
//	Loan Officer → Up to ₹5 Lakhs
//	Branch Manager → Up to ₹25 Lakhs
//	Regional Manager → Up to ₹1 Crore
//	Head Office → Above ₹1 Crore
//
//	The customer doesn't know who will approve the loan.
//	The request simply moves through the chain.
//	Each handler decides:
//		Can I approve?
//		If yes → Approve.
//		If no → Pass to the next handler.
	public static void main(String[] args) {

		LoanApprover officer = new LoanOfficer();

		LoanApprover manager = new BranchManager();

		LoanApprover regional = new RegionalManager();

		LoanApprover head = new HeadOfficer();

		officer.setNext(manager);

		manager.setNext(regional);

		regional.setNext(head);

		officer.approve(333222);
	}

}
