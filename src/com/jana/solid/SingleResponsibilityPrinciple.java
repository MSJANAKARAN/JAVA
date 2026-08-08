package com.jana.solid;

public class SingleResponsibilityPrinciple {
//	A class should have only one responsibility (one reason to change).

//	Bad Design
//	class FundTransferService {
//	    void transferMoney() {
//	        // Transfer money
//	    }
//	    void saveTransaction() {
//	        // Save transaction
//	    }
//	    void sendSMS() {
//	        // Send SMS
//	    }
//	    void sendEmail() {
//	        // Send Email
//	    }
//	}
//
//	This class does 4 different jobs.
//	If SMS changes,
//	or database changes,
//	or transfer logic changes,
//	this class changes.
//
//	Violation of SRP

	class TransferMoneyService {
		void transferMoney() {
			// Transfer Money
		}
	}

	class TransactionService {
		void saveTransaction() {
			// Save Transaction
		}
	}

	class NotificationService {
		void sendSMS() {
			// Send SMS
		}

		void sendEmail() {
			// Send Email
		}
	}
//	Now every class has one responsibility.
}
