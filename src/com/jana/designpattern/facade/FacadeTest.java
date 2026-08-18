package com.jana.designpattern.facade;

public class FacadeTest {
//	Structural Design Pattern ###
//	The Facade Pattern provides a single, simplified interface to a set of complex subsystems.
//	or The Facade pattern hides the complexity of multiple subsystems by providing a single, unified interface.
//	Instead of the client interacting with many classes, it interacts with one Facade class.
//
//	Suppose a customer transfers ₹10,000.
//
//	Many operations happen internally:
//
//	Authenticate user
//	Validate account
//	Check balance
//	Perform debit
//	Perform credit
//	Save transaction
//	Send SMS/Email
//	Write audit log
//
//	The client should not call all these services individually.
	
	 public static void main(String[] args) {

	        FundTransfer facade =
	                new FundTransfer();

	        facade.transferMoney(
	                "Hana",
	                "ACC1001",
	                "ACC2002",
	                50000,
	                10000);
	    }
	 
}
