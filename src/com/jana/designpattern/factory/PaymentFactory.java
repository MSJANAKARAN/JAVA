package com.jana.designpattern.factory;

public class PaymentFactory {

	public static Payment getPayment(String type) throws Exception {

		if (type.equalsIgnoreCase("NEFT")) {
			return new NeftPayment();
		} else if (type.equalsIgnoreCase("RTGS")) {
			return new RtgsPayment();
		} else if (type.equalsIgnoreCase("UPI")) {
			return new UpiPayment();
		} else if (type.equalsIgnoreCase("CARD")) {
			return new CardPayment();
		}

		throw new RuntimeException("Invalid Payment Type");
	}

}
