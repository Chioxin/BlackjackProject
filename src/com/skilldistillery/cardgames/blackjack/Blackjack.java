package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;

public class Blackjack {

	public static void main(String[] args) {
		Blackjack app = new Blackjack();
		app.run();
//		app.TEST_ONLY();
	}

	private void run() {
		Scanner kb = new Scanner(System.in);
		Table myTable = new Table(1, kb);
		int choice;
		
		do {
//			myTable.startGame();
			
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
//			choice = getIntInput(kb);
			if (choice < 1 || choice > 2) {
				System.out.println();
				System.out.println("\t" + choice + " is not a valid choice. Try again.");
				System.out.println();
			}
			
		} while (choice != 2);
		
		return choice;
	}

	private int getIntInput(Scanner kb) {
		int input = 0;

		do {
			try {
				System.out.print(">> ");
				input = Integer.parseInt(kb.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Expected an Integer. Please enter an integer!");
			}
		} while (input == 0);

		return input;
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

}
