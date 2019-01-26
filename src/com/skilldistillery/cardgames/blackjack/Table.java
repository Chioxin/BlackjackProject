package com.skilldistillery.cardgames.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;

public class Table {
	
	private Deck deck;
	private Dealer dealer;
	private List<Player> players;
	
	public Table(int numPlayers) {
		deck = new Deck();
		dealer = new Dealer();
		players = new ArrayList<>();
		
		//Populate player list with users.
		for (int i = 0; i < numPlayers; i++) {
			Player aPlayer = new User();
			players.add(aPlayer);
		}
		
		
	}
	
	public void startGame() {
		for (int i = 0; i < 2; i++) {
			dealOutARound();
			Card c = deck.dealCard();
			dealer.addCard(c);
		}
	}
	
	public void performHit(Player player) {
		Card c = deck.dealCard();
		player.addCard(c);
	}
	
	public void performStand(Player player) {
		//Probably not needed.
	}
	
	public void dealOutARound() {
		for (Player player : players) {
			Card c = deck.dealCard();
			player.addCard(c);
		}		
	}
	
	public void checkDeckRefresh() {
		if (deck.checkDeckSize() < 15) {
			deck = new Deck();
		}
	}

}
