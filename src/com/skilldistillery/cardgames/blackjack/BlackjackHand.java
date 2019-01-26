package com.skilldistillery.cardgames.blackjack;

import java.util.List;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int score = 0;

		for (Card card : getCards()) {
			score += card.getValue();
		}

		return score;
	}

	@Override
	public String displayHand() {
		String s = "";
		List<Card> hand = getCards();
		for (Card card : hand) {
//			s = s + "[" + 
		}
		
		
		return s;
	}


}
