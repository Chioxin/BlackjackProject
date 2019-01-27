package com.skilldistillery.cardgames.blackjack;

import java.util.List;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Hand;
import com.skilldistillery.cardgames.common.Rank;

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
		
		if (score > 21) {
			for (Card card : getCards()) {
				if (card.getRank() == Rank.ACE) {
					score -= 10;
					if (score < 21) {
						break;
					}
				}
			}
		}

		return score;
	}

	@Override
	public String displayHand(boolean reveal) {
		String s = "";
		
		if (!reveal) {
			List<Card> hand = getCards();
			s = "" + hand.get(0).getValue() + " - ";
			s = s + hand.get(0).toString() + "[***** of ***]";
		} else {
			s = "" + getHandValue() + " - ";
			List<Card> hand = getCards();
			for (Card card : hand) {
				s = s + card.toString();
			}
		}
		
		return s;
	}

}
