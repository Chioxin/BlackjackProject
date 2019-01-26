package com.skilldistillery.cardgames.common;

public enum Rank {
	TWO (2, "  2  "),
	THREE (3, "  3  "),
	FOUR (4, "  4  "),
	FIVE (5, "  5  "),
	SIX (6, "  6  "),
	SEVEN (7, "  7  "),
	EIGHT (8, "  8  "),
	NINE (9, "  9  "),
	TEN (10, " 10  "),
	JACK (10, "JACK "),
	QUEEN (10, "QUEEN"),
	KING (10, "KING "),
	ACE (11, " ACE ");
	
	Rank (int i, String s) {
		this.Rank = i;
		this.RankToString = s;
	}
	
	private int Rank;
	private String RankToString;

	public int getValue() {
		return Rank;
	}
	
	public String getRankToString() {
		return RankToString;
	}

}
