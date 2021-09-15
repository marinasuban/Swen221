package swen221.cards.core;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Represents a trick being played. This includes the cards that have been
 * played so far, as well as what the suit of trumps is for this trick.
 * 
 * @author David J. Pearce
 * 
 */
public class Trick implements Cloneable{
	private Card[] cards = new Card[4];
	private Player.Direction lead;
	private Card.Suit trumps;
	
	@Override
	public Trick clone() {
		Trick clone = new Trick(this.lead, this.trumps);
		for(int i=0; i<cards.length; i++) {
			if (cards[i] != null) {
				clone.cards[i] = cards[i].clone();
			}
		}
		return clone;
	}

	/**
	 * Contruct a new trick with a given lead player and suit of trumps.
	 * 
	 * @param lead   --- lead player for this trick.
	 * @param trumps --- maybe null if no trumps.
	 */
	public Trick(Player.Direction lead, Card.Suit trumps) {
		this.lead = lead;
		this.trumps = trumps;
	}

	/**
	 * Determine who the lead player for this trick is.
	 * 
	 * @return
	 */
	public Player.Direction getLeadPlayer() {
		return lead;
	}

	/**
	 * Determine which suit are trumps for this trick, or null if there are no
	 * trumps.
	 * 
	 * @return
	 */
	public Card.Suit getTrumps() {
		return trumps;
	}

	/**
	 * Get the list of cards played so far in the order they were played.
	 * 
	 * @return
	 */
	public List<Card> getCardsPlayed() {
		ArrayList<Card> cs = new ArrayList<Card>();
		for (int i = 0; i != 4; ++i) {
			if (cards[i] != null) {
				cs.add(cards[i]);
			} else {
				break;
			}
		}
		return cs;
	}

	/**
	 * Get the card played by a given player, or null if that player has yet to
	 * play.
	 * 
	 * @param p --- player
	 * @return
	 */
	public Card getCardPlayed(Player.Direction p) {
		Player.Direction player = lead;
		for (int i = 0; i != 4; ++i) {
			if (player.equals(p)) {
				return cards[i];
			}
			player = player.next();
		}
		// deadcode
		return null;
	}

	/**
	 * Determine the next player to play in this trick.
	 * 
	 * @return
	 */
	public Player.Direction getNextToPlay() {
		Player.Direction dir = lead;
		for (int i = 0; i != 4; ++i) {
			if (cards[i] == null) {
				return dir;
			}
			dir = dir.next();
		}
		return null;
	}

	/**
	 * Determine the winning player for this trick. This requires looking to see
	 * which player led the highest card that followed suit; or, was a trump.
	 * 
	 * @return
	 */
	public Player.Direction getWinner() {
		Player.Direction player = lead;
		Player.Direction winningPlayer = null;
		Card winningCard = cards[0];
		for (int i = 0; i != 4; ++i) {
			if (cards[i].suit() == winningCard.suit() && cards[i].compareTo(winningCard) >= 0) {
				winningPlayer = player;
				winningCard = cards[i];
			} else if (trumps != null && cards[i].suit() == trumps && winningCard.suit() != trumps) {
				// in this case, the winning card is a trump
				winningPlayer = player;
				winningCard = cards[i];
			}
			player = player.next();
		}
		return winningPlayer;
	}

	/**
	 * Player attempts to play a card. This method checks that the given player is
	 * entitled to play, and that the played card follows suit. If either of these
	 * are not true, it throws an IllegalMove exception.
	 */
	public void play(Player p, Card c) throws IllegalMove {
	
			//player cannot play turn if not have card
				if (!(p.getHand().contains(c))) {
					throw new IllegalMove("The player at " + p.getDirection().toString() + " does not have " + c.toString() + " in their hand.");
		        }
				
			// if a player attempts to play when its not their turn throw exception
				if(this.getNextToPlay() != p.getDirection()) {
					throw new IllegalMove("It's not the turn of " + p.getDirection().toString() + " player to play.");
									
				}
				//card must follow lead if it exists
				if(getCardPlayed(lead) != null) {
					Card.Suit leadSuit = getCardPlayed(lead).suit();
					//player must play card in matching suit when possible if they aren't the lead
					if (p.getDirection() != lead && !p.getHand().matches(leadSuit).isEmpty() && !p.getHand().matches(leadSuit).contains(c)) {
						throw new IllegalMove("Player " + p.getDirection().toString()+ " Cannot play "+ c.toString() + "- doesn't follow lead");
					}
				}
		
		// Finally, play the card.
		for (int i = 0; i != 4; ++i) {
			if (cards[i] == null) {
				cards[i] = c;
				p.getHand().remove(c);
				break;
			}
		}
	}
}
