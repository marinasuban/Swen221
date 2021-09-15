// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import java.util.Arrays;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;

/**
 * Responsible for rotating the image data in a given cell in a clockwise
 * direction.
 *
 * @author betty
 *
 */
public class Rotation implements Operation {
	private final Location location;
	private final int steps;

	/**
	 * Construction a rotation for the cell at a given location, rotating a given
	 * number of steps.
	 *
	 * @param loc
	 * @param steps
	 */
	public Rotation(Location loc, int steps) {
		this.location = loc;
		this.steps = steps;
	}
	

	/**
	 * Converts 1D int array to 2D int array
	 *
	 * @param width of cell image
	 * @param cell that will be rotated
	 */
	public int[][] convertArray(Cell myCell, int width) {
		int[] array1 = myCell.getImage();
		int[][] array2 = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				array2[i][j] = array1[(i * width) + j];
			}
		}
		return array2;
	}

	/**
	 * Apply rotation to the selected cell.
	 *
	 * @param cell  The cell on which the rotation is applied.
	 *
	 * @param steps Number of steps to rotate in clockwise direction.
	 */
	@Override
	public void apply(Board board) {
		// FIXME: need to do something here!
		Cell cellSelected = board.getCellAt(location);
		if (cellSelected != null) {
			int width = cellSelected.getWidth();
			int[][] cellImage = convertArray(cellSelected, width);
			int steps = this.steps % 4; // reduce time while loops runs step=4 means no change
			
			while (steps > 0) { //run rotation as indicated by steps
				//store cell
				int[][] temporaryCell = new int[width][width];
				//rotate 90 degrees clockwise
				for (int row = 0; row < width; row++) {
					for (int col = 0; col < width; col++) {
						temporaryCell[row][col] = cellImage[width - col - 1][row];
					}
				}

				cellImage = temporaryCell;
				steps--;
			}
			//set RBG value
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < width; j++) {
					cellSelected.setRGB(i, j, cellImage[j][i]);
				}
			}
		}
	}
}
