package oving6;

import java.util.ArrayList;

public class CardDeck{
	ArrayList<Card> cards = new ArrayList<Card>();
	
	
	public CardDeck() {
		for (int f = 0; f < 4; f++) {
			for (int s = 1; s < 14; s++) {
				if (f==0) {
					Card meh = new Card("S",s);
					cards.add(meh);
				} else if (f == 1) {
					Card meh = new Card("H",s);
					cards.add(meh);
				} else if (f == 2) {
					Card meh = new Card("D",s);
					cards.add(meh);
				} else if (f == 3) {
					Card meh = new Card("C",s);
					cards.add(meh);
				}
			}
		}
	}
	
	public int getCardCount() {
		return cards.size();
	}
	
	
	public Card getCard(int meh) {
		if (meh < 0 || meh > cards.size()) {
			return null;
		} else {
			return cards.get(meh);
		}
	}
	
	public ArrayList<Card> deal(int meh) {
		if (meh <= getCardCount()) {
			ArrayList<Card> deck = new ArrayList<Card>();
			for (int i = 0; i < meh; i++) {
				int cardsSize = getCardCount();
				deck.add(getCard(cardsSize-1));
				cards.remove(cardsSize-1);
			
			}
			return deck;
		} else {
			
			return null;
		}
		
	}

}