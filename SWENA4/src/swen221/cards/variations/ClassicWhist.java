package swen221.cards.variations;

import java.util.List;

import swen221.cards.core.Card;
import swen221.cards.core.CardGame;
import swen221.cards.core.Player;
import swen221.cards.core.Trick;
import swen221.cards.core.Player.Direction;
import swen221.cards.util.AbstractCardGame;

/**
 * An implementation of the "classical" rules of Whist.
 *
 * @author David J. Pearce
 *
 */
public class ClassicWhist extends AbstractCardGame {

	public ClassicWhist() {

	}

	@Override
	public String getName() {
		return "Classic Whist";
	}

	@Override
	public boolean isGameFinished() {
		for (Player.Direction d : Player.Direction.values()) {
			if (scores.get(d) == 5) {
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

	public ClassicWhist clone() {
		ClassicWhist clonedGame = new ClassicWhist();
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
