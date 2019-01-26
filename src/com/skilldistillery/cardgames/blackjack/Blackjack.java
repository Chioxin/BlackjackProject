package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;

public class Blackjack {

	public static void main(String[] args) {
		Blackjack app = new Blackjack();
		app.run();
	}

	private void run() {
		Scanner kb = new Scanner(System.in);
		
		
		
		
		
		
		
		
		
		
		kb.close();
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
	
	private int getInput (Scanner kb) {
	
	return 0;
	}

}
