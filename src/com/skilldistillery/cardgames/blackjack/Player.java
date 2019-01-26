package com.skilldistillery.cardgames.blackjack;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Hand;

public abstract class Player {

	private BlackjackHand hand;
	
	public Player () {
		hand = new BlackjackHand();
	}

	public abstract String hitOrStand ();

	public void addCard(Card c) {
		hand.addCard(c);
	}
	
	public void discardHand() {
		hand.clearHand();
	}
	
	public int returnHandValue() {
		return hand.getHandValue();
	}

}
