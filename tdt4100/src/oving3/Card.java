package oving3;

public class Card {

	String suit;
	int face;
	
	public Card(String suit, int face) {
		this.suit = suit;
		this.face = face;		
	}
	
	public Card() {
		
	}
	
	public String toString() {
		return suit+face;		
	}
}
