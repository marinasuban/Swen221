package swen221.cards.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import swen221.cards.core.Card;
import swen221.cards.core.Hand;
import swen221.cards.core.Player;
import swen221.cards.core.Player.Direction;
import swen221.cards.core.Trick;

/**
 * Implements a simple computer player who plays the highest card available when
 * the trick can still be won, otherwise discards the lowest card available. In
 * the special case that the player must win the trick (i.e. this is the last
 * card in the trick), then the player conservatively plays the least card
 * needed to win.
 * 
 * @author David J. Pearce
 * 
 */
public class SimpleComputerPlayer extends AbstractComputerPlayer {

	public SimpleComputerPlayer(Player player) {
		super(player);
	}
	
	@Override
	public Card getNextCard(Trick trick) {
		Iterable<Card> PossibleCards; // potential cards
		Card FirstCard = null;
		Card NextCard = null;
		Card highestNow =null;
		
		// check if this is the first card played
		if (trick.getCardsPlayed().isEmpty()) { 
			// get the highest card in my hand
			PossibleCards = this.player.getHand(); 
			NextCard = getTheHighestCard(PossibleCards, trick);
		} 
		//if I am the last card played (3 other players played)
		else if (trick.getCardsPlayed().size() == 3) {	
			FirstCard = trick.getCardsPlayed().get(0);
			highestNow = getTheHighestCard(trick.getCardsPlayed(), trick);
			//if have card of the same suit played
			if (!this.player.getHand().matches(FirstCard.suit()).isEmpty()) {
				PossibleCards = this.player.hand.matches(FirstCard.suit());
				// I have same suit cards and I can win, select the smallest card to win
				for (Card c : PossibleCards) { 
					if (getHigher(c,highestNow,trick).equals(c)) {
						NextCard = c;
						break;
					}
				}
				//if I cannot win select my smallest card to discard
				NextCard = getTheSmallestCard(PossibleCards, trick);// I cannot win
			}
			else {
				PossibleCards = this.player.getHand();
				// get my highest card of same suit
				NextCard = getTheHighestCard(PossibleCards, trick); 
				if(getHigher(NextCard,highestNow,trick).equals(NextCard)) {
					for (Card c : PossibleCards) {
						if (getHigher(c,highestNow,trick).equals(c)){
							NextCard = c;
							break;
						}
					}
				}
				// I cannot win
				else {
					NextCard = getTheSmallestCard(PossibleCards, trick);
				}
			}
		} 
		// If I'm not the first or last player
		else {
			 // get the last card
			FirstCard = trick.getCardsPlayed().get(0);
			// if I have same suit cards
			if (!this.player.hand.matches(FirstCard.suit()).isEmpty()) {
				PossibleCards = this.player.hand.matches(FirstCard.suit());
				// get my highest card of same cards
				NextCard = getTheHighestCard(PossibleCards, trick);
				highestNow = getTheHighestCard(trick.getCardsPlayed(), trick);
				//If my highest card is equal to the current highest card play my lowest card
				if(getHigher(NextCard,highestNow,trick).equals(highestNow)|| (getHigher(NextCard,highestNow,trick).hashCode()<highestNow.hashCode())) {
					NextCard = getTheSmallestCard(PossibleCards, trick);
				}
			// when I have no same suit cards
			} else {
				 // choose the highest card of my hand
				PossibleCards = this.player.getHand();
				NextCard = getTheHighestCard(PossibleCards, trick);
				highestNow = getTheHighestCard(trick.getCardsPlayed(), trick);
				if(getHigher(NextCard,highestNow,trick).equals(highestNow)|| (getHigher(NextCard,highestNow,trick).hashCode()<highestNow.hashCode())) {
					NextCard = getTheSmallestCard(PossibleCards, trick);
				}
			}
		}
		return NextCard;
	}

	/**
	 * check every card and get the highest one
	 * @param s
	 * @param trick
	 * @return
	 */
	public Card getTheHighestCard(Iterable<Card> s, Trick trick) { 
		Iterator<Card> it = s.iterator();
		Card Highest = it.next();
		while (it.hasNext()) {
			Card next = it.next();
			Highest = getHigher(Highest, next, trick);
		}
		return Highest;
	}

	/**
	 * check every card and get the smallest one
	 * @param s
	 * @param trick
	 * @return
	 */
	public Card getTheSmallestCard(Iterable<Card> s, Trick trick) {
		Iterator<Card> it = s.iterator();
		Card Smallest = it.next();
		while (it.hasNext()) {
			Card next = it.next();
			Smallest = getSmaller(Smallest, next, trick);
		}
		return Smallest;
	}

	/**
	 * compare two cards and get bigger one
	 * @param c1
	 * @param c2
	 * @param trick
	 * @return
	 */
	public Card getHigher(Card c1, Card c2, Trick trick) { 
		int v1 = c1.hashCode();
		int v2 = c2.hashCode();
		if (trick.getTrumps() != null) { // if there is Trumps, it should be considered
			if (c1.suit().equals(trick.getTrumps())) {
				v1 += 2000;
			}
			if (c2.suit().equals(trick.getTrumps())) {
				v2 += 2000;
			}
		}
		if (v1 > v2)
			return c1;
		else
			return c2;
	}

	/**
	 * compare two cards and get smaller one
	 * @param c1
	 * @param c2
	 * @param trick
	 * @return
	 */
	public Card getSmaller(Card c1, Card c2, Trick trick) { 
		int v1 = c1.hashCode();
		int v2 = c2.hashCode();
		if (trick.getTrumps() != null) { // if there is Trumps, it should be considered
			if (c1.suit().equals(trick.getTrumps())) {
				v1 += 2000;
			}
			if (c2.suit().equals(trick.getTrumps())) {
				v2 += 2000;
			}
		}
		if (v1 < v2)
			return c1;
		else
			return c2;
	}

}



