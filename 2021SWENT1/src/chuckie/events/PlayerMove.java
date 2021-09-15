// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.events;

import chuckie.Game;
import chuckie.io.GameError;
import chuckie.tiles.Egg;
import chuckie.tiles.Ladder;
import chuckie.tiles.Player;
import chuckie.tiles.Tile;
import static chuckie.tiles.Air.AIR;
import chuckie.util.Position;

/**
 * Represents a directional move of the player within a given input sequence.
 *
 * @author David J. Pearce
 *
 */
public class PlayerMove implements Event {
	/**
	 * Represents one of the four directions in which the snake can move (Up, Down,
	 * Left and Right).
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	/**
	 * Indicates the direction in which the player moves.
	 */
	private final Direction direction;

	/**
	 * Construct a new player move object for a given direction.
	 *
	 * @param direction Indicates which direction the player is moving
	 */
	public PlayerMove(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void apply(Game game) {
		// Find player's position on the board.
		//check for eggs;
		if (!findEgg(game)) { //if no eggs, return
			if (direction == Direction.LEFT || direction == Direction.RIGHT) {
				throw new GameError("there arent any eggs left!");
			}
		}
		Position playerpos;
		try {
			playerpos = findPlayer(game);
		}
		catch (IllegalArgumentException e){
			throw new GameError("cant find the player - probably lost");
		}
		// Calculate player's new position
		Position next = playerpos.move(direction);
		// Get the players tile
		Player playertile = (Player) game.getTile(playerpos);
		// Check whether moving left or right
		if (direction == Direction.LEFT || direction == Direction.RIGHT) {
			// Get tile at target position
			Tile nexttile = game.getTile(next);
			boolean wasOnLadder = playertile.isOnLadder;
			if (nexttile instanceof Ladder) {
				playertile.isOnLadder = true;
			}
			else {
				playertile.isOnLadder = false;
			}
			if (!nexttile.isObstruction()) {
				game.setTile(next, playertile);
				if (wasOnLadder == true) {
					
					game.setTile(playerpos, new Ladder());
				}
				else {				
				game.setTile(playerpos, AIR);
				}
			}
			// Only move left or right if not obstructed
			//find egg
			
		}
		
		if (direction == Direction.UP || direction == Direction.DOWN) {
			if (!playertile.isOnLadder) return; //do nothing
			
			Tile nexttile = game.getTile(next);
			game.setTile(next, playertile);
			game.setTile(playerpos, nexttile);
		}	
	}

	private static boolean findEgg(Game game) {
		// Search through board
		for (int y = 0; y != game.getHeight(); ++y) {
			for (int x = 0; x != game.getWidth(); ++x) {
				Tile t = game.getTile(new Position(x,y));
				// Check whether tile is egg or not
				if(t instanceof Egg) {
					return true;
				}
			}
		}
		//
		return false;
	}
	/**
	 * Find the position where the player is currently located.
	 *
	 * @param game The game board in which to find the player.
	 * @return Position of player tile on board
	 */
	public static Position findPlayer(Game game) {
		// Find all sections
		for (int x = 0; x < game.getWidth(); ++x) {
			for (int y = 0; y < game.getHeight(); ++y) {
				Position p = new Position(x,y);
				// Extract tile at x,y position
				Tile t = game.getTile(p);
				// Check whether is part of snake
				if(t instanceof Player) {
					return p;
				}
			}
		}
		throw new IllegalArgumentException("Player not located on the board!");
	}
}
