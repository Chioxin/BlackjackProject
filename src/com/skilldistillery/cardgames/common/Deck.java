package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> Deck;

	public Deck() {
		Deck = new ArrayList<>();
		Suit[] mySuits = Suit.values();
		Rank[] myRanks = Rank.values();
		for (Suit suit : mySuits) {
			for (Rank rank : myRanks) {
				Card myCard = new Card(suit, rank);
				Deck.add(myCard);
			}

		}
	}
	
	public int checkDeckSize() {
		return Deck.size();
	}
	
	public void shuffle() {
		Collections.shuffle(Deck);
	}
	
	public Card dealCard() {
		if (Deck.get(0) != null) {
			return Deck.remove(0);
		}
		return null;
	}

}
