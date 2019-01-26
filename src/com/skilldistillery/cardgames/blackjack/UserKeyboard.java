package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

public class UserKeyboard {
		
	public int getInt(Scanner kb) {
		int input = 0;

		do {
			try {
				System.out.print(">> ");
				input = Integer.parseInt(kb.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("\tExpected an Integer. Please enter an integer!");
				System.out.println();
			}
		} while (input == 0);

		return input;
	}

}
