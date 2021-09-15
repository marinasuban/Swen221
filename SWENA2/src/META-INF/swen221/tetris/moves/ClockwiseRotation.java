// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Implements a rotation move which is either clockwise or anti-clockwise.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class ClockwiseRotation extends AbstractMove implements Move {

	@Override
	public Board apply(Board board) {
		// Create copy of the board to prevent modifying its previous state.
		board = new Board(board);
		// Create a copy of this board which will be updated.
		ActiveTetromino tetromino = board.getActiveTetromino().rotate(1);
		// Apply the move to the new board, rather than to this board.
		board.setActiveTetromino(tetromino);
		// Return updated version of this board.
		return board;
	}

	/**
	 * unique valid method requires for rotate to prevent rotation of tet to push
	 * tet outside box condition, if board is not null and tet remains inboard after
	 * rotation - return true
	 */
	@Override
	public boolean isValid(Board board) {
		// if not null
		if (!super.isValid(board)) {
			return false;
		}
		// create board copy, set active tet as current tet rotated once
		Board boardCopy = new Board(board);
		ActiveTetromino tet = boardCopy.getActiveTetromino().rotate(1);
		boardCopy.setActiveTetromino(tet);
		// if active tet is outside box
		if (boardCopy.outsideBoard(tet)) {
			return false;

		}
		return true;
	}

}
