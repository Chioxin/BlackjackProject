package com.skilldistillery.cardgames.common;

public enum Suit {
	HEART ("\u2665", "Heart"),
	DIAMOND ("\u2666", "Diamond"),
	SPADE ("\u2660", "Spade"),
	CLUB ("\u2663", "Club");
	
	Suit (String suitIcon, String suitName) {
		this.Suit = suitIcon;
		this.SuitToString = suitName;
	}
	
	final private String Suit;
	final private String SuitToString;

	public String getSuit() {
		return Suit;
	}
	
	public String getSuitToString() {
		return SuitToString;
	}
	
}

