package com.skilldistillery.cardgames.blackjack;

import java.util.List;

import com.skilldistillery.cardgames.common.Card;

public abstract class Player {
	
	private BlackjackHand hand;
	
	public abstract String hitOrStand ();
	
	public void addCard(Card c) {
		hand.addCard(c);
	}
	
}
