package oving6;

public class Card implements Comparable<Card> {

	String suit;
	int face;

	public Card(String suit, int face) {
		if (suit == "S" || suit == "H" || suit == "D" || suit == "C") {
			this.suit = suit;
		} else {
			this.suit = null;
		}

		if (face >= 1 && face <= 13) {
			this.face = face;
		} else {
			this.face = -1;
		}

	}

	public Card() {

	}

	public String getSuit() {
		return this.suit;
	}

	public int getFace() {
		return this.face;
	}

	public String toString() {
		return suit + face;
	}
	
	public int getFaceValue() {
		if (this.getFace() == 1) {
			return 14;
		} else {
			return this.getFace();
		} 
	}
	
	public int getSuitValue() {
		switch (this.getSuit().charAt(0)) {
		case 'S': {return 3;}
		case 'H': {return 2;}
		case 'D': {return 1;}
		case 'C': {return 0;}
		}
		return 0;
	}

	@Override
	public int compareTo(Card o) {
		if (this.getFaceValue() == o.getFaceValue()) {
			return this.getSuitValue() - o.getSuitValue();
		} else {
			return this.getFaceValue() - o.getFaceValue();
		}
	}
}
