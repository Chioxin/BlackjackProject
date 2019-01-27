package com.skilldistillery.cardgames.blackjack;

public class Dealer extends Player {

	@Override
	public GameAction getAction() {

		if (returnHandValue() < 17) {
			return GameAction.HIT;

		} else {
			return GameAction.STAND;
		}
		
	}
	
}
