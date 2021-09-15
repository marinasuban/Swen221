package swen221.cards.variations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import swen221.cards.core.Card;
import swen221.cards.core.CardGame;
import swen221.cards.core.IllegalMove;
import swen221.cards.core.Player;
import swen221.cards.core.Trick;
import swen221.cards.core.Player.Direction;
import swen221.cards.util.AbstractCardGame;

public class KnockOutWhist extends AbstractCardGame {
	private int hand = 13;
	
	public KnockOutWhist() {

	}

	public String getName() {
		return "Knock-Out Whist";
	}
	
	public boolean isGameFinished() {
		return hand == 0;		
	}
		
	public void deal(List<Card> deck) {		
		currentTrick = null;
		for (Player.Direction d : Player.Direction.values()) {
			players.get(d).getHand().clear();
		}
		Player.Direction d = Player.Direction.NORTH;
		for (int i = 0; i < hand * 4; ++i) {
			Card card = deck.get(i);
			players.get(d).getHand().add(card);
			d = d.next();
		}			
	}	
	
	public void endHand() {
		super.endHand();
		hand = hand - 1;
	}

	@Override
	public KnockOutWhist clone() {
		
		KnockOutWhist clonedGame = new KnockOutWhist();
		for(Player play : players.values()) {
			Player player = new Player(play.direction);
			player.hand = play.hand.clone();
			clonedGame.players.put(play.direction, player);
			
		}
		for(Player.Direction playTrick : tricks.keySet()) {
			clonedGame.tricks.put(playTrick, tricks.get(playTrick) );			
		}
		for(Player.Direction playScores : scores.keySet()) {
			clonedGame.scores.put(playScores, scores.get(playScores) );			
		}
		clonedGame.trumps = this.trumps;
		clonedGame.currentTrick = currentTrick.clone();
		return clonedGame;
	}
}
