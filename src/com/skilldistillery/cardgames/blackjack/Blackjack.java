package com.skilldistillery.cardgames.blackjack;

import java.util.InputMismatchException;
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
			myTable.startGame();
			
			System.out.println("Would you like to play again?");
			System.out.println("1.) YES, Take my money!!!");
			System.out.println("2.) NO, Computers cheat!!!");
			choice = getIntInput(kb);
			
		} while (choice != 2);
		
		
		kb.close();
	}

	private int getIntInput(Scanner kb) {
		int input = 0;

		do {
			try {
				input = kb.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Expected an Integer. Please enter an integer!");
			}
		} while (input != 0);

		return 0;
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
