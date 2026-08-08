package com.jana.designpattern.decorator;

//A decorator is completely useless by itself; it exists only to wrap another object. By making the 
//class abstract, you guarantee that nobody can mistakenly instantiate a generic, empty decorator
public abstract class AccountDecorator implements Account {

	protected Account account;

	AccountDecorator(Account acc) {
		account = acc;
	}

	@Override
	public void features() {
		account.features();
	}

}
