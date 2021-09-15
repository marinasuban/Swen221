package swen221.tetris.moves;

import swen221.tetris.logic.Board;

/**
 * Move the active tetromino one square downwards.
 *
 * @author David J. Pearce
 *
 */

public class MoveDown extends AbstractTranslation {
	public MoveDown() {
		super(0, -1);
	}

}
