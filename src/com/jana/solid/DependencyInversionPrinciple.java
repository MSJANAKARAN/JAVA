package com.jana.solid;

public class DependencyInversionPrinciple {

//	Depend on abstractions, not concrete implementations.
//
//	Suppose after every transfer, the bank sends a notification.
//
//	class SMSService {
//	    void send() {
//	        System.out.println("SMS Sent");
//	    }
//	}
//
//	class FundTransferService {
//	    private SMSService sms = new SMSService();
//	    void transfer() {
//	        // Transfer
//	        sms.send();
//	    }
//	}
//
//	Problem: If tomorrow Email, Push Notification, WhatsApp is required,
//
//	FundTransferService must change.
	interface NotificationService {
		void send();
	}

	class SMSService implements NotificationService {
		public void send() {
			System.out.println("SMS Sent");
		}
	}
	class EmailService implements NotificationService{
		public void send() {
			System.out.println("Email Sent");
		}
	}
	
	class FundTransferService {
		private NotificationService notification;
		public FundTransferService(NotificationService notify) {
			this.notification = notify;
		}
		void transfer() {
			//transfer
			notification.send();
		}
	}
	
//	Usage -> Later you can switch to email without changing FundTransferService:
	NotificationService notify = new SMSService();
	FundTransferService service = new FundTransferService(notify);
	
}
