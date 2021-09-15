package swen221.cards.core;

public class Card implements Comparable<Card>, Cloneable{
	
	@Override
	public Card clone() {
		Card clone = new Card(this.suit, this.rank);
		return clone;
	}

	/**
	 * Represents a card suit.
	 * 
	 * @author David J. Pearce
	 *
	 */
	public enum Suit {
		HEARTS, CLUBS, DIAMONDS, SPADES;
	}

	/**
	 * Represents the different card "numbers".
	 * 
	 * @author David J. Pearce
	 *
	 */
	public enum Rank {
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
	}

	// =======================================================
	// Card stuff
	// =======================================================

	private Suit suit; // HEARTS, CLUBS, DIAMONDS, SPADES
	private Rank rank; // 2 <= number <= 14 (ACE)

	/**
	 * Construct a card in the given suit, with a given number
	 * 
	 * @param suit   --- between 0 (HEARTS) and 3 (SPADES)
	 * @param number --- between 2 and 14 (ACE)
	 */
	public Card(Suit suit, Rank number) {
		this.suit = suit;
		this.rank = number;
	}

	/**
	 * Get the suit of this card, between 0 (HEARTS) and 3 (SPADES).
	 * 
	 * @return
	 */
	public Suit suit() {
		return suit;
	}

	/**
	 * Get the number of this card, between 2 and 14 (ACE).
	 * 
	 * @return
	 */
	public Rank rank() {
		return rank;
	}

	private static String[] suits = { "Hearts", "Clubs", "Diamonds", "Spades" };
	private static String[] ranks = { "2 of ", "3 of ", "4 of ", "5 of ", "6 of ", "7 of ", "8 of ", "9 of ", "10 of ",
			"Jack of ", "Queen of ", "King of ", "Ace of " };

	public String toString() {
		return ranks[rank.ordinal()] + suits[suit.ordinal()];
	}
	
	
	public int hashCode() {
		//create int value of card - suit ordinal multiplied by 100 to ensure that rank does not effect outcome
		return (this.rank.ordinal() + (this.suit.ordinal() * 100));
	}

	/**
	 * Method used to determine if two cards are equal
	 */
	@Override
	public boolean equals(Object obj) {
		//if card is not null and is an instance of card
		if(obj != null && obj instanceof Card) {
			//return true if the card is of the same rank and suit
			return ((this.rank == ((Card)obj).rank) && (this.suit == ((Card)obj).suit));
		}
		//else return false
		return false;	
	}

	/**
	 * Method used to compare two cards
	 */
	@Override
	public int compareTo(Card cTwo) {
		//get hashcode (value of card) for current and other card
		double cardOne = this.hashCode();
        double cardTwo = cTwo.hashCode();
        
        //if card one is greater
        if (cardOne - cardTwo > 0) {
            return 1;
        } 
        //if card two is greater
        else if (cardOne - cardTwo < 0) {
            return -1;
        } 
        //else equal
        else {
            return 0;
        }
	}
}
