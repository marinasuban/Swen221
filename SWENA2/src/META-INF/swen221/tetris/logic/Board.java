// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.logic;

import java.util.Arrays;
import java.util.Iterator;

import swen221.tetris.tests.Part2Tests;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.O_Tetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * A Board instance represent a board configuration for a game of Tetris. It is
 * represented as an array of rows, where every row contains a given number of
 * columns.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 */
public class Board {
	/**
	 * The width of the board in columns.
	 */
	private final int width;
	/**
	 * The height of the board in rows.
	 */
	private final int height;

	/**
	 * A row-major representation of the board. Each location contains a reference
	 * to the tetromino located there.
	 */
	private final Tetromino[] cells;

	/**
	 * The active tetromino is the one currently being controlled.
	 */
	private ActiveTetromino activeTetromino;

	public Board(Iterator<Tetromino> sequence, int width, int height) {
		this.width = width;
		this.height = height;
		this.cells = new Tetromino[width * height];
	}

	/**
	 * Create an identical copy of a given board.
	 *
	 * @param other The board being copied.
	 */
	public Board(Board other) {
		this.width = other.width;
		this.height = other.height;
		this.cells = Arrays.copyOf(other.cells, other.cells.length);
		this.activeTetromino = other.activeTetromino;
	}

	/**
	 * Get the width of this board.
	 *
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Get the height of this board.
	 *
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get the active tetromino. This is the tetromino currently being manipulated
	 * on the board. This may be <code>null</code> if there is no active tetromino.
	 *
	 * @return
	 */
	public ActiveTetromino getActiveTetromino() {
		return activeTetromino;
	}

	/**
	 * Get any tetromino (including the active one) located at a given position on
	 * the board. If the position is out of bounds, an exception is raised.
	 * Likewise, if no Tetromino exists at that position then <code>null</code> is
	 * returned.
	 *
	 * @param x The x-coordinate of the cell to check
	 * @param y The y-coordinate of the cell to check
	 *
	 * @return is null if x and/or y points out of the board.
	 */
	public Tetromino getTetrominoAt(int x, int y) {
		if (activeTetromino != null && activeTetromino.isWithin(x, y)) {
			return activeTetromino;
		} else {
			return getPlacedTetrominoAt(x, y);
		}
	}

	/**
	 * Update the active tetromino for this board. If the tetromino has landed, it
	 * will be placed on the board and any full rows will be removed.
	 *
	 * @param tetromino
	 */
	public void setActiveTetromino(ActiveTetromino tetromino) {
		// Update the active tetromino
		this.activeTetromino = tetromino;
	}

	/**
	 * Get the placed tetromino (if any) located at a given position on the board.
	 * If the position is out of bounds, an exception is raised. Likewise, if no
	 * tetromino exists at that position then <code>null</code> is returned.
	 *
	 * @param x The x-coordinate of the cell to check
	 * @param y The y-coordinate of the cell to check
	 * @return is null if x and/or y points out of the board. *
	 */
	public Tetromino getPlacedTetrominoAt(int x, int y) {
		if (x < 0 || x >= width) {
			throw new IllegalArgumentException("Invalid column (" + x + ")");
		}
		if (y < 0 || y >= height) {
			throw new IllegalArgumentException("Invalid row (" + y + ")");
		}
		// Not part of active tetromino, so try placed ones.
		return cells[(y * width) + x];
	}

	/**
	 * Set the placed tetromino at a given position on the board. If the position is
	 * out of bounds, an exception is raised.
	 *
	 * @param x The x-coordinate of the cell to check
	 * @param y The y-coordinate of the cell to check
	 * @param t The tetromino to place, which can be <code>null</code> if the cell
	 *          is to be cleared.
	 */
	public void setPlacedTetrominoAt(int x, int y, Tetromino t) {
		if (x < 0 || x >= width) {
			throw new IllegalArgumentException("Invalid column (" + x + ")");
		}
		if (y < 0 || y >= height) {
			throw new IllegalArgumentException("Invalid row (" + y + ")");
		}
		cells[(y * width) + x] = t;
	}

	/**
	 * Check whether we can place a tetromino on the board. That is, whether or not
	 * the cells occupied by the tetromino are currently free and used by another
	 * placed tetromino. This is useful, for example, to detect the game is over as
	 * we cannot place a new tetromino on the board.
	 *
	 * @param t
	 * @return
	 */
	public boolean canPlaceTetromino(Tetromino t) {
		Rectangle r = t.getBoundingBox();
		//
		for (int x = r.getMinX(); x <= r.getMaxX(); ++x) {
			for (int y = r.getMinY(); y <= r.getMaxY(); ++y) {
				int id = (y * width) + x;
				if (t.isWithin(x, y) && (id < 0 || id >= cells.length || cells[id] != null)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Place a given Tetromino on the board by filling out each square it contains
	 * on the board.
	 *
	 * @param t Tetromino to place; cannot be null
	 */
	public void placeTetromino(Tetromino t) {
		Rectangle r = t.getBoundingBox();
		//
		for (int x = r.getMinX(); x <= r.getMaxX(); ++x) {
			for (int y = r.getMinY(); y <= r.getMaxY(); ++y) {
				if (t.isWithin(x, y)) {
					cells[(y * width) + x] = t;
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		for (int y = height - 1; y >= 0; y -= 1) {
			res.append("|");
			for (int x = 0; x < width; x += 1) {
				Tetromino tetromino = getTetrominoAt(x, y);
				if (tetromino == null) {
					res.append("_");
				} else {
					res.append(tetromino.getColor().toString().charAt(0));
				}
				res.append("|");
			}
			res.append("\n");
		}
		return res.toString();
	}

	/**
	 * landed method returns true when tet which is not null is on floor or landed
	 * on another tet otherwise return false 
	 * >REQUIRED FOR {@link Part2Tests}
	 * >METHOD USED IN DROPMOVE
	 * 
	 * @param activeTetromino
	 * @return
	 */
	public boolean landed(ActiveTetromino activeTet) {
		if (activeTet != null) {
			// check if tet on floor
			// for each block on floor return true if contains tet
			for (int x = 0; x < getWidth(); x++) {
				if (activeTet.isWithin(x, 0)) {
					return true;
				}

				// check if any tet below current tet
				// if a tet exsist below current tet return true
				Rectangle box = activeTet.getBoundingBox();
				for (int x1 = box.getMinX(); x1 <= box.getMaxX(); x1++) {
					for (int y = box.getMinY(); y <= box.getMaxY(); y++) {
						if (activeTet.isWithin(x, y)) {
							Tetromino neighbourTet = getTetrominoAt(x, y - 1);
							if (neighbourTet != null && neighbourTet != activeTet) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * if tet is within boundary of box return true >REQUIRED FOR P3test
	 * 
	 * @param activeTetromino
	 * @return
	 */
	public boolean outsideBoard(ActiveTetromino activeTetromino) {
		// Check left, right, bottom edge
		if ((activeTetromino.getBoundingBox().getMinX() < 0) || (activeTetromino.getBoundingBox().getMaxX() >= width)
				|| (activeTetromino.getBoundingBox().getMinY() < 0)) {
			return true;

		}
		return false;
	}

	/**
	 * checks if each square in indicated line is filled with tet >SUPPORTS PROCESS LINE METHOD
	 * 
	 * @param y
	 * @return
	 */
	private boolean lineCompleted(int y) {
		for (int x = 0; x < width; x++) {
			// if one square in line is empty return false
			if (getPlacedTetrominoAt(x, y) == null) {
				return false;
			}
		}
		int Score = Game.getScore() + 100;
		Game.setScore(Score);
		return true;
	}

	/**
	 * shuffles indicated line by moving line above into indicated line >SUPPORTS
	 * PROCESS LINE METHOD
	 * 
	 * @param y
	 */
	private void shuffleLine(int y) {
		// for each box above indicated line move down a row
		for (int Y1 = y; Y1 < height - 1; Y1++) {
			for (int x = 0; x < width; ++x) {
				Tetromino tetAboveCurrent = getPlacedTetrominoAt(x, Y1 + 1);
				setPlacedTetrominoAt(x, Y1, tetAboveCurrent);
			}

		}
		// remove line
		for (int x = 0; x < width; x++) {
			setPlacedTetrominoAt(x, height - 1, null);
		}

	}
	
	/**
	 * check if each row in box is completed - if so remove and shuffle
	 * >REQUIRED for P4 test
	 */
	public void ProcessLines() {
		//for each line on the board if it is completed, shuffle 
		for(int y = height - 1;  y >= 0; y--) {
			if(lineCompleted(y)) {
				shuffleLine(y);
			}
		}
	}
}
