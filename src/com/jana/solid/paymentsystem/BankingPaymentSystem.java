package com.jana.solid.paymentsystem;

import java.util.Map;

public class BankingPaymentSystem {
	
	public static void main(String[] args) {

		Map<PaymentType, Payment> paymentMethods = Map.of(PaymentType.UPI, new UPIPayment(), PaymentType.CREDITCARD,
				new CreditCardPayment(), PaymentType.BANKTRANSFER, new BankTransferPayment());

		NotificationService notificationService = new EmailNotificationService();
		PaymentService pay = new PaymentService(paymentMethods, notificationService);

		PaymentResult result = pay.makePayment(new PaymentRequest("JANAKARAN", 5000, PaymentType.CREDITCARD));
		System.out.println(result.toString());
	}

//	Scenario
//
//	You are building a simple payment processing system for a banking application.
//
//	The system should support multiple payment methods:
//
//	Credit Card
//	UPI
//	Bank Transfer
//
//	Each payment method has its own way of processing a payment.
//
//	The application should also support sending a notification after a successful payment:
//
//	Email
//	SMS
//	Requirements
//	1. Payment
//
//	Create a design where you can do something like:
//
//	PaymentService paymentService = ...;
//
//
//	paymentService.makePayment(
//	    new PaymentRequest("JANAKARAN", 5000, PaymentType.UPI)
//	);
//
//	The system should:
//
//	Validate the payment amount.
//	Process the payment using the appropriate payment method.
//	Send a notification after successful payment.
//	Return a payment result.
//	2. Payment Methods
//
//	Support:
//
//	Credit Card
//	UPI
//	Bank Transfer
//
//	Each payment method should have its own implementation.
//
//	For example:
//
//	CreditCardPayment
//	UPIPayment
//	BankTransferPayment
//
//	You should be able to add:
//
//	CryptoPayment
//	WalletPayment
//	NetBankingPayment
//
//	without modifying existing payment implementations.
//
//	3. Notifications
//
//	Support:
//
//	Email
//	SMS
//
//	For example:
//
//	EmailNotification
//	SMSNotification
//
//	You should be able to add:
//
//	PushNotification
//	WhatsAppNotification
//
//	without modifying existing notification implementations.
//
//	4. Payment Result
//
//	Your system should return something similar to:
//
//	PaymentResult
//	-----------------------
//	success
//	transactionId
//	message
//
//	Example:
//
//	Payment successful
//	Transaction ID: TXN12345
//
//	You can generate the transaction ID yourself.

}
