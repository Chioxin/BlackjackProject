package com.skilldistillery.cardgames.blackjack;

import java.util.Scanner;

public class User extends Player {
	
	private Scanner kb;
	
	public User(Scanner kb) {
		this.kb = kb;
	}

	@Override
	public GameAction getAction() {
		
		return null;
	}
	
	

}
