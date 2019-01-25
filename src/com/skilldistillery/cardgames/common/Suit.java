package com.skilldistillery.cardgames.common;

public enum Suit {
	HEART ("Heart"),
	DIAMOND ("Diamond"),
	SPADE ("Spade"),
	CLUB ("Club");
	
	Suit (String s) {
		this.Suit = s;
	}
	
	final private String Suit;

	public String getSuit() {
		return Suit;
	}
	
}

