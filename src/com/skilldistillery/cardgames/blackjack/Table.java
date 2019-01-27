package com.skilldistillery.cardgames.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;

public class Table {

	private Deck deck;
	private Dealer dealer;
	private List<Player> players; //We are using a list to prepare for multiplayer.
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
		deck.shuffle();
		for (int i = 0; i < 2; i++) { // This is done very intentionally, so as to accurately simulate dealing out to
			dealOutARound();          // the table. Just in case the Blackjack Authorities check.
			Card c = deck.dealCard(); // Deals all the players a card first, then the dealer. Repeat one more time.
			dealer.addCard(c);
		}
	}

	public void runGame() {
		displayTable(false);
		
		for (Player p : players) { // preparing for multiplayer.
			runTurn(p);
		}

		boolean arePlayersBust = true;
		for (Player p : players) {
			if (!p.isBust()) {
				arePlayersBust = false;
			}
		}
		
		System.out.println();
		displayTable(true);
		if (!arePlayersBust) {       //if at least one player is not bust.
			runTurn(dealer);         //run dealer turn.
			if (dealer.isBust()) {   //if dealer is bust.
				printPlayerWins();   //Print that the player has won!
			} else {                 
				findWinner();        //Otherwise, no one is bust. Find out who won.
			}
		} else {
			printHouseWins();        //All players were bust, print out the house won.
		}
		
		clearTable();
	}

	private void findWinner() {
		for (Player p : players) {
			if (p.returnHandValue() > dealer.returnHandValue()) {
				printPlayerWinsScore();
			} else if (p.returnHandValue() == dealer.returnHandValue()) {
				printTie();
			} else {
				printHouseWinsScore();
			}
		}
	}


	private void runTurn(Player p) {
		GameAction playerAction;
		boolean revealTable;
		if (p instanceof Dealer) {
			revealTable = true;
		} else {
			revealTable = false;
		}

		do {
			playerAction = p.getAction();
			if (playerAction == GameAction.HIT) {
				performHit(p);
				displayTable(revealTable);
			}
			p.setBust(checkBust(p));
		} while (playerAction != GameAction.STAND && !p.isBust());
		if (p.isBust()) {
			displayBust(p);
		}

	}


	private void clearTable() {
		dealer.discardHand();
		dealer.setBust(false);
		for (Player p : players) {
			p.discardHand();
			p.setBust(false);
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

	public boolean checkForBlackjack() {
		boolean dealerBlackjack = false;
		boolean playerBlackjack = false;
		if (dealer.returnHandValue() == 21) {
			dealerBlackjack = true;
		}
		
		for (Player p : players) {
			if (p.returnHandValue() == 21) {
				playerBlackjack = true;
			}
		}
		
		if (dealerBlackjack && playerBlackjack) {
			displayTable(true);
			System.out.println();
			System.out.println("\tBoth Dealer and Player have Blackjack!!!");
			System.out.println();
			clearTable();
			return true;
		} else if (dealerBlackjack) {
			displayTable(true);
			System.out.println();
			System.out.println("\tDealer had Blackjack! House wins!!!");
			System.out.println();
			clearTable();
			return true;
		} else if (playerBlackjack) {
			displayTable(true);
			System.out.println();
			System.out.println("\tPlayer had Blackjack! Player wins!!!");
			System.out.println();
			clearTable();
			return true;
		}
		
		return false;
	}
	
	private boolean checkBust(Player p) {
		if (p.returnHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	private void displayBust(Player p) {
		System.out.println();
		if (p instanceof User) {
			System.out.println("\tYou went over 21! That's a bust!");
		} else {
			System.out.println("\tDealer went over 21! That's a bust!");
		}
		System.out.println();
	}

	private void printHouseWins() {
		System.out.println();
		System.out.println("\tPlayers are bust! House wins!!!");
		System.out.println();
	}
	
	private void printHouseWinsScore() {
		System.out.println();
		System.out.println("\tHouse has a better score! House wins!!!");
		System.out.println();
	}

	private void printPlayerWins() {
		System.out.println();
		System.out.println("\tHouse is bust! Player win!!!");
		System.out.println();
	}
	
	private void printPlayerWinsScore() {
		System.out.println();
		System.out.println("\tPlayer has a better score! Player win!!!");
		System.out.println();
	}

	private void printTie() {
		System.out.println();
		System.out.println("\tNobody won this round.");
		System.out.println();
		
	} 

	private void displayTable(boolean reveal) {
		System.out.println();
		System.out.println("*************************************************************");
		System.out.println("*************************************************************");
		System.out.println();
		System.out.println("====DEALER====");
		System.out.println(dealer.showHand(reveal));

		for (Player p : players) {
			System.out.println();
			System.out.println("====PLAYER====");
			System.out.println(p.showHand(true)); //We always want to have the player's hand revealed no matter what.
		}

	}
}
