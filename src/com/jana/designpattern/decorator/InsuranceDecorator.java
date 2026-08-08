package com.jana.designpattern.decorator;

public class InsuranceDecorator extends AccountDecorator{

	InsuranceDecorator(Account acc){
		super(acc);
	}
	
	@Override
	public void features() {
		super.features();
		System.out.println("Account Service with Insurance");

	}
}
