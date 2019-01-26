package com.skilldistillery.cardgames.blackjack;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;

public class Blackjack {

	public static void main(String[] args) {
		Blackjack app = new Blackjack();
		app.run();
	}

	private void run() {
		TEST_ONLY();

	}
	
	
	private void TEST_ONLY() {
		Deck myDeck = new Deck();
		myDeck.shuffle();
		
		BlackjackHand myHand = new BlackjackHand();
		int i = 0;
		
		while (i < 4) {
			Card myCard = myDeck.dealCard();
			myHand.addCard(myCard);
			i++;
		}
		System.out.println(myHand.toString() + " TOTAL OF: " + myHand.getHandValue());
		
		myHand.clearHand();
		
		System.out.println(myHand.toString() + "Nothing to see here.");
		
	}

}
