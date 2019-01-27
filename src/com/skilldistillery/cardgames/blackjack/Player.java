package com.skilldistillery.cardgames.blackjack;

import com.skilldistillery.cardgames.common.Card;

public abstract class Player {

	private BlackjackHand hand;

	private boolean isBust;
	
	public abstract GameAction getAction ();

	public Player () {
		hand = new BlackjackHand();
		isBust = false;
	}

	public void addCard(Card c) {
		hand.addCard(c);
	}
	
	public void discardHand() {
		hand.clearHand();
	}
	
	public int returnHandValue() {
		return hand.getHandValue();
	}
	
	public String showHand(boolean reveal) {
		return hand.displayHand(reveal);
	}

	public boolean isBust() {
		return isBust;
	}

	public void setBust(boolean isBust) {
		this.isBust = isBust;
	}
}
