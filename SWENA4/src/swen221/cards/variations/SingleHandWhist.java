package swen221.cards.variations;

import java.util.List;
import java.util.Map;
import java.util.Set;

import swen221.cards.core.Card;
import swen221.cards.core.CardGame;
import swen221.cards.core.IllegalMove;
import swen221.cards.core.Player;
import swen221.cards.core.Trick;
import swen221.cards.core.Player.Direction;
import swen221.cards.util.AbstractCardGame;

/**
 * A simple variation of Whist where only a single hand is played.
 *
 * @author David J. Pearce
 *
 */
public class SingleHandWhist extends AbstractCardGame {


	@Override
	public String getName() {
		return "Single Hand Whist";
	}

	@Override
	public boolean isGameFinished() {
		for (Player.Direction d : Player.Direction.values()) {
			if (scores.get(d) == 1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deal(List<Card> deck) {
		currentTrick = null;
		for (Player.Direction d : Player.Direction.values()) {
			players.get(d).getHand().clear();
		}
		Player.Direction d = Player.Direction.NORTH;
		for (int i = 0; i < deck.size(); ++i) {
			Card card = deck.get(i);
			players.get(d).getHand().add(card);
			d = d.next();
		}
	}

	public SingleHandWhist clone() {
		SingleHandWhist clonedGame = new SingleHandWhist();
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
		if (currentTrick != null) {
			clonedGame.currentTrick = currentTrick.clone();
		}
		
		
				
		return clonedGame;
	}
}
