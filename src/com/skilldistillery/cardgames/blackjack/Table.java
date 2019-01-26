package com.skilldistillery.cardgames.blackjack;

import java.util.List;

import com.skilldistillery.cardgames.common.Deck;

public class Table {
	
	private Deck deck;
	private Dealer dealer;
	private List<Player> players;
	
	public Table() {
		
	}
	
	public void performHit(Player player) {
		
		
	}
	
	public void performStand(Player player) {
		
	}
	
	public void dealOut() {
		
	}
	
	public void checkDeckRefresh() {
		if (deck.checkDeckSize() < 15) {
			deck = new Deck();
		}
	}

}
