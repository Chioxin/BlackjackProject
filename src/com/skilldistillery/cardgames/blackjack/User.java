package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

public class User extends Player {
	
	private Scanner kb;
	
	public User(Scanner kb) {
		super();
		this.kb = kb;
	}

	@Override
	public GameAction getAction() {
		UserKeyboard userInput = new UserKeyboard();
		int choice = 0;
		
		do {
		System.out.println();
		System.out.println("Which action would you like to perform?");
		System.out.println("1.) HIT");
		System.out.println("2.) STAND");
		
		choice = userInput.getInt(kb);
		
		if (choice < 1 || choice > 2) {
			System.out.println();
			System.out.println("\t" + choice + " is an invalid menu option.");
			System.out.println();
		}
		
		} while (choice < 1 || choice > 2);
		
		switch (choice) {
		case 1:
			return GameAction.HIT;
		case 2:
			return GameAction.STAND;
		}		
		return null; // If we are returning null, something went horribly wrong.
	}
	
	

}
