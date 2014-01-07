package oving6;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class AccountOverview {
	
	ArrayList<Account> accounts;
	
	public AccountOverview() {
		this.accounts = new ArrayList<Account>();
	}
	
	public int getAccountCount() {
		return this.accounts.size();
	}
	
	public Account getAccount(int meh) {
		return this.accounts.get(meh);
	}
	
	public void addAccount(Account meh) {
		if (!this.accounts.contains(meh)) {
			this.accounts.add(meh);
		}
	}
	
	public int getTotalBalance() {
		int b = 0;
		for (int i = 0; i < this.getAccountCount(); i++) {
			b += this.getAccount(i).getBalance();
		}
		return b;
	}
	
	public int getTotalCredit() {
		int c = 0;
		for (int i = 0; i < this.getAccountCount(); i++) {
			c += this.getAccount(i).getCredit();
		}
		return c;
	}
	
	public int getTotalFees() {
		int f = 0;
		for (int i = 0; i < this.getAccountCount(); i++) {
			if (this.getAccount(i) instanceof CreditAccount) {
				f += ((CreditAccount) this.getAccount(i)).getFees();
			}	
		}
		return f;
	}
}
