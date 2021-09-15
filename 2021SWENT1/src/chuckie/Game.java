// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie;

import chuckie.events.Event;
import chuckie.events.GameOver;
import chuckie.events.PlayerMove;
import chuckie.events.PlayerMove.Direction;

import static chuckie.tiles.Air.AIR;
import chuckie.tiles.*;
import chuckie.util.Position;

/**
 * Represents the state of a game of Chuckie Egg. In particular, the game holds
 * the position of each piece on the board and the list of events.
 *
 * @author David J. Pearce
 *
 */
public class Game {

	/**
	 * Stores the width of the board.
	 */
	private int width;

	/**
	 * Stores the height of the board.
	 */
	private int height;

	/**
	 * A 2-dimensional array representing the board itself.
	 */
	private Tile[][] board;

	/**
	 * The array of event which make up this game.
	 */
	private Event[] events;

	/**
	 * Construct a game of Chuckie Egg
	 *
	 * @param width  Width of the board (in cells)
	 * @param height Height of the board (in cells)
	 *
	 * @param events --- The events that make up the game
	 */
	public Game(int width, int height, Event[] events) {
		this.events = events;
		this.width = width;
		this.height = height;
		board = new Tile[height][width];
	}

	public boolean isGameOver = false;

	/**
	 * Get the height of the game board.
	 *
	 * @return Board height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get the width of the game board.
	 * 
	 * @return Board width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Run this game to produce the final board, whilst also checking each move
	 * against the rules of Chuckie Egg.
	 */
	public void run() {
		for (int i = 0; i != events.length; ++i) {
			Event move = events[i];
			move.apply(this);
//			if (isGameOver) {
//				return;
//			}		
			// Apply post moves
			applyGravity();
		}
	}

	/**
	 * Get the tile at a given position on the board. If the position is outside the
	 * board dimensions, it just returns empty air.
	 *
	 * @param position Board position to get tile from
	 * @return Tile at given position
	 */
	public Tile getTile(Position position) {
		final int x = position.getX();
		final int y = position.getY();
		if (x < 0 || x >= width) {
			return AIR;
		} else if (y < 0 || y >= height) {
			return AIR;
		} else {
			return board[position.getY()][position.getX()];
		}
	}

	/**
	 * Set the tile at a given position on the board. Note, this will overwrite the
	 * record of any other tile being at that position.
	 *
	 * @param position Board position to place piece on
	 * @param tile     The tile to put at the given position.
	 */
	public void setTile(Position position, Tile tile) {
		final int x = position.getX();
		final int y = position.getY();
		if (x < 0 || x >= width) {
			return;
		} else if (y < 0 || y >= height) {
			return;
		} else {
			board[position.getY()][position.getX()] = tile;
		}
	}

	/**
	 * Locate a given tile on the board.
	 *
	 * @param tile Tile to be located
	 * @return Position containing tile
	 */
	public Position locateTile(Tile tile) {
		for (int y = 0; y != height; ++y) {
			for (int x = 0; x != width; ++x) {
				if (board[y][x] == tile) {
					return new Position(x, y);
				}
			}
		}
		throw new IllegalArgumentException("Tile not located on board!");
	}

	/**
	 * Apply gravity to the player, meaning that it moves down until such time as
	 * either leaves the board entirely or is stopped by some obstruction.
	 */
	private void applyGravity() {
		// NOTE: to implement this method, we need to find the player. Then we need to
		// decide if the player is supported. Finally, if the player is not supported,
		// then we need to move it down. At this point, we repeat the process until the
		// player is supported or has fallen off the board.
		boolean applied = false;
		boolean swappedLadders = false;
		while (applied == false) {
			if (!findEgg(this)) {
				isGameOver = true;
				return;
			}
			
			Position player = findPlayer(this);
			if (player == null) {
				isGameOver = true; // fell off map
				return;
			}
			Position posBelow = new Position(player.getX(), player.getY() - 1);
			Tile tileBelow = getTile(posBelow);

			// check player is supported
			boolean isSupported = tileBelow.providesSupport();

			if (!isSupported) {
				// delete old player tile
				if (getTile(new Position(player.getX(), player.getY() + 1)) instanceof Ladder && !swappedLadders) {
					setTile(player, new Ladder());
					swappedLadders = true;
				} else {
					setTile(player, Air.AIR);
				}
				player = player.move(Direction.DOWN);
				if (player.getY() <= 0) { // fell off the map
					System.out.println("test");
					isGameOver = true;
					applied = true;
					return;
				}

				setTile(player, new Player());
			} else {
				applied = true;
			}

		}
	}

	private boolean findEgg(Game game) {
		// Search through board
		for (int y = 0; y != game.getHeight(); ++y) {
			for (int x = 0; x != game.getWidth(); ++x) {
				Tile t = game.getTile(new Position(x, y));
				// Check whether tile is egg or not
				if (t instanceof Egg) {
					return true;
				}
			}
		}
		//
		return false;
	}

	public Position findPlayer(Game game) {
		// Find all sections
		for (int x = 0; x < game.getWidth(); ++x) {
			for (int y = 0; y < game.getHeight(); ++y) {
				Position p = new Position(x, y);
				// Extract tile at x,y position
				Tile t = game.getTile(p);
				// Check whether is part of snake
				if (t instanceof Player) {
					return p;
				}
			}
		}
		return null;
	}

	/**
	 * Provide a human-readable view of the current game board. This is particularly
	 * useful to look at when debugging your code!
	 */
	@Override
	public String toString() {
		String r = "";
		for (int i = height - 1; i >= 0; --i) {
			r += (i % 10) + "|";
			for (int j = 0; j != width; ++j) {
				Tile p = board[i][j];
				r += p.toString();
			}
			r += "|\n";
		}
		r += "  ";
		// Do the X-Axis
		for (int j = 0; j != width; ++j) {
			r += (j % 10);
		}
		return r;
	}

	/**
	 * Initialse the board from a given input board. This includes the placement of
	 * all terrain and pieces.
	 *
	 * @param boardString String representing board.
	 */
	public void initialiseBoard(String boardString) {
		// You don't need to understand this!
		String[] rows = boardString.split("\n");
		for (int y = 0; y != height; ++y) {
			String row = rows[y];
			for (int x = 0; x != width; ++x) {
				char c = row.charAt(x + 2);
				board[height - (y + 1)][x] = createPieceFromChar(c);
			}
		}
	}

	private Tile createPieceFromChar(char c) {
		switch (c) {
		case ' ':
			return AIR; // blank space
		case 'O':
		case '@':
			return new Player();
		case '=':
			return new Platform();
		case '*':
			return new Egg();
		case '#':
			return new Ladder();
		}
		throw new IllegalArgumentException("invalid character");
	}
}
