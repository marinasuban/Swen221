// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.tiles;

public class Ladder implements Tile {

	@Override
	public String toString() {
		return "#";
	}

	@Override
	public boolean providesSupport() {
		return true;
	}

	@Override
	public boolean isObstruction() {
		return false;
	}
}
