package com.jana.designpattern.proxy;

public class ProxyTest {

//	Structural Design Pattern
//	Proxy Design Pattern provides a placeholder or surrogate for another object to control access to it.
//	Instead of the client communicating directly with the real object, it communicates through a Proxy, which can perform additional tasks such as:
//	Authentication
//	Authorization
//	Logging
//	Caching
//	Lazy Loading
//	Validation
//
//	The Proxy pattern controls access to a real object by placing another object (the proxy) in front of it.
//	
//	Real Banking Scenario
//	Suppose a customer wants to view their account balance.
//	Before showing the balance, the bank must:
//	Verify JWT token
//	Check user authentication
//	Check account ownership
//	Log the request
//	Then fetch the balance
//
//	The client should not directly access the account service.
	public static void main(String[] args) {

		AccountInterface account = new AccountProxy();
		
		account.viewBalance("SBI000123");
		
	}

}
