package swen221.tetris.moves;

import swen221.tetris.logic.Board;

/**
 * Move the active tetromino one square to the left.
 *
 * @author David J. Pearce
 *
 */
public class MoveLeft extends AbstractTranslation {

	public MoveLeft() {
		super(-1, 0);
	}

}
