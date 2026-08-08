package com.jana.designpattern.proxy;

public class AccountProxy implements AccountInterface{

	AccountService service = new AccountService();
	@Override
	public void viewBalance(String accountNo) {

		if(isAuthenticated(accountNo)) {
			service.viewBalance(accountNo);
		}else {
			System.out.println("Access is denied");
		}
	}
	
	private boolean isAuthenticated(String accountNo) {

		//Authentication logic, returning success
		return true;
	}

}
