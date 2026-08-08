package com.jana.designpattern.decorator;

public class CashbackDecorator extends AccountDecorator{

	CashbackDecorator(Account acc) {
		super(acc);
	}
	
	@Override
	public void features() {
		super.features();
		System.out.println("Account Service with Cashback");
	}

}
