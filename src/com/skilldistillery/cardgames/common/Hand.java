package com.skilldistillery.cardgames.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	private List<Card> myHand;

	public Hand() {
		myHand = new ArrayList<>();

	}

	public abstract int getHandValue();
	
	public abstract String displayHand();

	public void addCard(Card c) {
		myHand.add(c);
	}

	public void clearHand() {
		myHand = new ArrayList<>();
	}

	public List<Card> getCards() {
		List<Card> handCopy = new ArrayList<>();
		handCopy.addAll(myHand);
		return handCopy;
	}

	public String toString() {
		String s = "";
		
		for (Card card : myHand) {
			s = s + card.toString() + " ";
		}
		
		return s;
	}

}
