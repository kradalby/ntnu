package oving6;

public class CreditAccount implements Account {

	int balance;
	int credit;
	int fees;

	public CreditAccount(int meh) {
		this.balance = 0;
		this.credit = meh;
		this.fees = 0;
	}

	@Override
	public int getBalance() {
		return this.balance;
	}

	@Override
	public int getCredit() {
		return this.credit;
	}

	@Override
	public int deposit(int meh) {
		if (meh > 0) {
			balance += meh;
			return balance;
		} else {
			return balance;
		}
	}

	@Override
	public int withdraw(int meh) {
		if (meh < 0) {
			return 0;
		}
		if (this.getBalance() + this.getCredit() >= meh + 50) {
			if (this.getBalance() < meh) {
				this.balance -= 50;
				this.fees += 50;
			}
			this.balance -= meh;	
		} else {
			return 0;
		}
		return meh;
	}

	public int getFees() {
		return this.fees;
	}
}
