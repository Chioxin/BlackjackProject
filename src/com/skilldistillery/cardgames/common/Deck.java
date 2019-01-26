package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck;

	public Deck() {
		deck = new ArrayList<>();
		Suit[] mySuits = Suit.values();
		Rank[] myRanks = Rank.values();
		for (Suit suit : mySuits) {
			for (Rank rank : myRanks) {
				Card myCard = new Card(suit, rank);
				deck.add(myCard);
			}

		}
		
	}
	
	public int checkDeckSize() {
		return deck.size();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card dealCard() {
		if (deck.get(0) != null) {
			return deck.remove(0);
		}
		return null;
	}

}
