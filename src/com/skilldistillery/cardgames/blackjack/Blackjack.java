package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

import com.skilldistillery.cardgames.common.Card;
import com.skilldistillery.cardgames.common.Deck;

public class Blackjack {

	public static void main(String[] args) {
		Blackjack app = new Blackjack();
		app.run();
	}

	private void run() {
		Scanner kb = new Scanner(System.in);
		welcomeScreen(kb);
		kb.close();
	}

	private void game(Scanner kb) {
		Table myTable = new Table(1, kb);
		int choice;
		do {
			myTable.startGame();
			if (!myTable.checkForBlackjack()) {
				myTable.runGame();
			}
			choice = askToPlayAgain(kb);

		} while (choice != 2);
		System.out.println("Bring more money next time!");
	}

	private int askToPlayAgain(Scanner kb) {
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

		} while (choice < 1 || choice > 2);

		return choice;
	}

	private void welcomeScreen(Scanner kb) {
		UserKeyboard getInput = new UserKeyboard();
		int choice = 0;

		System.out.println();
		System.out.println("888     888                888       d8b                888 ");
		System.out.println("888     888                888       Y8P                888 ");
		System.out.println("888     888                888                          888 ");
		System.out.println("88888b. 888 8888b.  .d8888b888  888 8888 8888b.  .d8888b888  888");
		System.out.println("888 \"88b888    \"88bd88P\"   888 .88P \"888    \"88bd88P\"   888 .88P ");
		System.out.println("888  888888.d888888888     888888K   888.d888888888     888888K ");
		System.out.println("888 d88P888888  888Y88b.   888 \"88b  888888  888Y88b.   888 \"88b ");
		System.out.println("88888P\" 888\"Y888888 \"Y8888P888  888  888\"Y888888 \"Y8888P888  888 ");
		System.out.println("                                     888                 ");
		System.out.println("                                    d88P                        ");
		System.out.println("                                  888P\"                          ");
		System.out.println();
		System.out.println();
		System.out.println("\t\tWant to play a game?");
		System.out.println("\t\t1.) YES! Take my money!!!");
		System.out.println("\t\t2.) NO! Computers cheat!!!");
		int c = 0;
		do {
			System.out.print("\t\t");
			choice = getInput.getInt(kb);
			if (choice < 1 || choice > 2) {
				if (c < 2) {
					System.out.println(choice + " is an invalid answer!");
					c++;
				} else {
					System.out.println("Alright then, taking your money is going to be SO easy...");
					choice = 1;
				}
			}

		} while (choice < 1 || choice > 2);
		
		if (choice == 1) {
			game(kb);
		} else {
			System.out.println();
			System.out.println("We promise not to count the cards if you're winning...");
			System.out.println("Oh alright, come again!");
		}
		
	}

}
