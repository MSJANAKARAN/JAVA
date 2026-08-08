package com.jana.designpattern.facade;

public class FundTransfer {

	private AuthenticationService auth = new AuthenticationService();
	
	private AccountService account = new AccountService();

	private BalanceService balance =  new BalanceService();
	
	private TransactionService transaction = new TransactionService();
	
	private NotificationService notification= new NotificationService();
	
	private AuditService audit = new AuditService();
	
	
	public void transferMoney(String user, String fromAccount, String toAccount, double bal, double amount ) {
		if(!auth.authenticate(user)) {
			return;
		}
		
		if(!balance.hasSufficientBalance(bal, amount)) {
			return;
		}
		
		account.debit(fromAccount,amount);
		
		account.credit(toAccount,amount);

		transaction.save();
		
		notification.send();
		
		audit.log();
	}
}
