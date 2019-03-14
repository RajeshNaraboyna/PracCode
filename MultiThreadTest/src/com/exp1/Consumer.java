package com.exp1;

public class Consumer {

	Account account;
	
	public Consumer(Account account) {
		this.account=account;
	}
	
	public double getAmount(double deducAmt){
		double amount=(account.getAmount()-deducAmt);
		return amount;
	}
	
	
}
