package oving6;

public class SavingsAccount implements Account{

	int balance;
	int credit;
	
	public SavingsAccount() {
		balance = 0;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public int getCredit() {
		return this.credit;
	}
	
	public int deposit(int meh) {
		if (meh > 0) {
			balance += meh;
			return balance;
		} else {
			return balance;
		}
	}
	
	public int withdraw(int meh) {
		if (meh <= balance && meh > 0) {
			balance -= meh;
			return meh;
		} else {
			return 0;
		}
		
	}
}
