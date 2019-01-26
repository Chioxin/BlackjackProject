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
		for (int i = 0; i < 2; i++) { // This is done very intentionally, so as to accurately simulate dealing out to the table.
			dealOutARound();          // Just in case the Blackjack Authorities check.
			Card c = deck.dealCard(); // Deals all the players a card first, then the dealer. Repeat one more time.
			dealer.addCard(c);
		}
	}

	public void runGame() {
		
		for (Player p : players) {
			handleTurn(p);
		}
		handleTurn(dealer);
		clearTable();
	}

	private void handleTurn(Player p) {
		GameAction playerAction = null;
		boolean isBust = checkBust(p);

		do {
			playerAction = p.getAction();
			if (playerAction == GameAction.HIT) {
				performHit(p);
				isBust = checkBust(p);
			}
		} while (playerAction != GameAction.STAND || isBust);

		if (isBust) {
			System.out.println();
			if (p instanceof User) {
				System.out.println("\tYou went over 21! That's a bust!");
			} else {
				System.out.println("\1Dealer went over 21! That's a bust!");
			}
			System.out.println();
		}

	}
	
	private void displayTable() {
		
	}

	private void clearTable() {
		dealer.discardHand();
		for (Player p : players) {
			p.discardHand();
		}
		checkDeckRefresh(15);
	}

	private void performHit(Player player) {
		Card c = deck.dealCard();
		player.addCard(c);
	}

	private void dealOutARound() {
		for (Player player : players) {
			Card c = deck.dealCard();
			player.addCard(c);
		}
	}

	private void checkDeckRefresh(int n) {
		if (deck.checkDeckSize() < n) {
			deck = new Deck();
		}
	}

	private boolean checkBlackjack(Player p) {
		if (p.returnHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkBust(Player p) {
		if (p.returnHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

}
