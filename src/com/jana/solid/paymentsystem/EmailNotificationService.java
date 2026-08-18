package com.jana.solid.paymentsystem;

public class EmailNotificationService implements NotificationService{

	public void send(PaymentResult result) {
		System.out.println("Email Sent: "+result.message());
	}
}
