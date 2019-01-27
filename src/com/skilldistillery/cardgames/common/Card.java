package com.skilldistillery.cardgames.common;

public class Card {
	private Suit mySuit;
	private Rank myRank;
	
	public Card (Suit s, Rank r) {
		mySuit = s;
		myRank = r;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myRank == null) ? 0 : myRank.hashCode());
		result = prime * result + ((mySuit == null) ? 0 : mySuit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (myRank != other.myRank)
			return false;
		if (mySuit != other.mySuit)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "[" + myRank.getRankToString() + " of " + mySuit.getSuit() + "'s]";
	}

	public int getValue() {
		return this.myRank.getValue();
	}
	public Rank getRank() {
		return myRank;
	}

}
