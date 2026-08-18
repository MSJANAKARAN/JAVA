package com.jana.solid.paymentsystem;

public class SMSNotificationService implements NotificationService{

	public void send(PaymentResult result) {
		System.out.println("SMS Sent: "+result.message());
	}
}