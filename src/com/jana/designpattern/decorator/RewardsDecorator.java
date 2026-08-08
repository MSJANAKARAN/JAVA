package com.jana.designpattern.decorator;

public class RewardsDecorator extends AccountDecorator{

	RewardsDecorator(Account acc){
		super(acc);
	}
	
	@Override
	public void features() {
		super.features();
		System.out.println("Account Service with Rewards");

	}
}
