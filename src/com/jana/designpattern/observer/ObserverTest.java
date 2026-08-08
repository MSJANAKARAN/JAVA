package com.jana.designpattern.observer;

public class ObserverTest {

//	Behavioural Design Pattern
//	Observer Design Pattern defines a one-to-many relationship between objects. When one object (called the Subject) changes its state,
//	it automatically notifies all its dependent objects (called Observers).
//	The Observer pattern allows one object to notify multiple dependent objects automatically whenever its state changes.
//	
//	Real Banking Scenario
//
//	A customer transfers ₹10,000.
//	After a successful transaction, multiple actions should happen:
//	Send SMS
//	Send Email
//	Send Push Notification
//	Update Analytics
//	Write Audit Log
//
//	The TransactionService should not call each service directly.
//	Instead, it simply publishes an event, and all interested observers react.
	
	public static void main(String[] args) {

		TransactionService service = new TransactionService();
		service.addObserver(new SMSObserver());
		service.addObserver(new EmailObserver());
		service.addObserver(new AuditObserver());
		service.transfer(1000);
	}

//	Spring Boot already provides the Observer pattern through events.
//	public class TransactionCompletedEvent {
//
//	    private final double amount;
//
//	    public TransactionCompletedEvent(double amount) {
//	        this.amount = amount;
//	    }
//
//	    public double getAmount() {
//	        return amount;
//	    }
//	}
//	
//	@Service
//	public class TransactionService {
//
//	    private final ApplicationEventPublisher publisher;
//
//	    public TransactionService(ApplicationEventPublisher publisher) {
//	        this.publisher = publisher;
//	    }
//
//	    public void transfer(double amount) {
//
//	        // Business logic
//
//	        publisher.publishEvent(
//	            new TransactionCompletedEvent(amount));
//	    }
//	}
//	
//	@Component
//	public class SmsListener {
//
//	    @EventListener
//	    public void sendSms(
//	        TransactionCompletedEvent event) {
//
//	        System.out.println("SMS Sent");
//	    }
//	}
}
