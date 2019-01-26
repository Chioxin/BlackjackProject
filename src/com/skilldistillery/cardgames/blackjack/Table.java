package com.skilldistillery.cardgames.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;

public class Table {

	private Deck deck;
	private Dealer dealer;
	private List<Player> players;
	private Scanner kb;

	public Table(int numPlayers, Scanner kb) {
		this.kb = kb;
		deck = new Deck();
		dealer = new Dealer();
		players = new ArrayList<>();

		// Populate player list with users.
		// Preplanning for multiplayer.
		for (int i = 0; i < numPlayers; i++) {
			Player aPlayer = new User(kb);
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

	public void cleanTable() {
		dealer.discardHand();
		for (Player p : players) {
			p.discardHand();
		}
		checkDeckRefresh(15);
	}

	public GameAction getPlayerDecision() {

		return null;
	}

	public void performHit(Player player) {
		Card c = deck.dealCard();
		player.addCard(c);
	}

	public void performStand(Player player) {
		// Probably not needed.
	}

	public void dealOutARound() {
		for (Player player : players) {
			Card c = deck.dealCard();
			player.addCard(c);
		}
	}

	public void checkDeckRefresh(int n) {
		if (deck.checkDeckSize() < n) {
			deck = new Deck();
		}
	}

}
