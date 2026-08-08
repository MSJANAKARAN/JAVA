package com.jana.designpattern.adapter;

public class VisaAdapter implements Payment{

	private VisaGateway visaGateway;
	
	public VisaAdapter(VisaGateway visa) {
		this.visaGateway =visa;
	}
	
	@Override
	public void pay(double amount) {

		visaGateway.makePayment(amount);
		
	}

	
}
