// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Implements a translation move.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public abstract class AbstractTranslation extends AbstractMove implements Move {
	/**
	 * Amount to translate x-coordinate.
	 */
	private final int dx;
	/**
	 * Amount to translate y-coordinate.
	 */
	private final int dy;

	/**
	 * Construct new TranslationMove for a given amount of horizontal and vertical
	 * translation.
	 *
	 * @param dx Amount to translate in horizontal direction.
	 * @param dy Amount to translate in vertical direction.
	 */
	public AbstractTranslation(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	@Override
	public Board apply(Board board) {
		// Create copy of the board to prevent modifying its previous state.
		board = new Board(board);
		// Apply translation for this move
		ActiveTetromino tetromino = board.getActiveTetromino().translate(dx, dy);
		// Apply the move to the new board.
		board.setActiveTetromino(tetromino);
		// Return updated version of board
		return board;
	}

	/**
	 * checks if move is valid if not null and tet is inside board return true if
	 * tet is not overlapping another tet
	 * broken
	 * >METHOD REQUIRED for P3
	 */
	@Override
	public boolean isValid(Board board) {
		//if not null
		if (!super.isValid(board)) {
			return false;
		}
		//create copy and obtain tet
		Board boardCopy = apply(board);
		ActiveTetromino tet = boardCopy.getActiveTetromino();
		//if the tet is outside of the board return false
		if (board.outsideBoard(tet)) {
			return false;
		}
		//if it overlaps a placed tet on the board
		for (int x = tet.getBoundingBox().getMinX(); x <= tet.getBoundingBox().getMaxX(); x++) {
			for (int y = tet.getBoundingBox().getMinY(); y <= tet.getBoundingBox().getMaxY(); y++) {
				if (tet.isWithin(x, y)) {
					if (board.getPlacedTetrominoAt(x, y) != null) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
