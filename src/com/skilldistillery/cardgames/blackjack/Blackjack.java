package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;

public class Blackjack {

	public static void main(String[] args) {
		Blackjack app = new Blackjack();
//		app.run();
		app.TEST_ONLY();
	}

	private void run() {
		Scanner kb = new Scanner(System.in);
		Table myTable = new Table(1, kb);
		int choice;
		
		do {
			myTable.startGame();
			myTable.runGame();
			
			choice = askToPlayAgain(kb);
			
		} while (choice != 2);
			
		System.out.println("Bring more money next time!");
		
		
		kb.close();
	}private int askToPlayAgain(Scanner kb) {
		UserKeyboard getInput = new UserKeyboard();
		int choice;
		
		System.out.println("Would you like to play again?");
		do {
			System.out.println("1.) YES, Take my money!!!");
			System.out.println("2.) NO, Computers cheat!!!");
			choice = getInput.getInt(kb);
			if (choice < 1 || choice > 2) {
				System.out.println();
				System.out.println("\t" + choice + " is not a valid choice. Try again.");
				System.out.println();
			}
			
		} while (choice != 2);
		
		return choice;
	}

	private void TEST_ONLY() {
		Deck myDeck = new Deck();
		myDeck.shuffle();
		Card c = myDeck.dealCard();
		System.out.println(c.toString());
	}

}
