package oving5.card;

public class Card {

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
		return suit+face;		
	}
}
