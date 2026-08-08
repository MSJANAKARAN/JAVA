package com.jana.designpattern.decorator;

public class DecoratorTest {

//	Structural Design Pattern
//	Decorator Pattern allows you to add new functionality to an object dynamically without modifying its existing code.
//	Instead of creating many subclasses, you wrap the original object with one or more decorators.
//	The Decorator pattern adds responsibilities to an object dynamically by wrapping it with decorator objects, without changing the original class.
//	Real Banking Scenario
//	Suppose a bank offers a Savings Account.
//	Some customers opt for additional features:
//	Cashback
//	Accident Insurance
//	Reward Points
//	Premium Support
//	Instead of creating classes like:
//		SavingsAccount
//		SavingsAccountWithCashback
//		SavingsAccountWithInsurance
//		SavingsAccountWithCashbackAndInsurance
//		SavingsAccountWithInsuranceAndRewards
//		...
//	the number of subclasses grows rapidly. Decorator solves this problem.
	
	public static void main(String[] args) {

		Account account = new RewardsDecorator(new InsuranceDecorator(new CashbackDecorator(new SavingsAccount())));
		
		account.features();
	}

//	Why not use inheritance?
//		Because every feature combination would require a new subclass. With 5 optional features, inheritance can lead to dozens of classes. Decorators let you mix and match features dynamically.
//	Can multiple decorators be applied?
//		Yes.
//		Account account =
//			    new RewardPointsDecorator(
//			        new InsuranceDecorator(
//			            new CashbackDecorator(
//			                new SavingsAccount())));
//		Each decorator wraps the previous one.
}
