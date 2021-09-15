package swen221.picturepuzzle.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.moves.Move;
import swen221.picturepuzzle.moves.Rotation;

public class Part4Tests {
	@Test public void test_01() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_02() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_03() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_04() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,0)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_05() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,0)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_06() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_07() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_08() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_09() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_10() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,0)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_11() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,0)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_12() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,0)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_13() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,0)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_14() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,0)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_15() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,0)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_16() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_17() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_18() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_19() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_20() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_21() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_22() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_23() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_24() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_25() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_26() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_27() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_28() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_29() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,1)));
		assertTrue(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000003 |         |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_30() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_31() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_32() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000001 |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_33() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000001 | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_34() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_35() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_36() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_37() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_38() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_39() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_40() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_41() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_42() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000001 |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_43() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000001 | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_44() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000001 |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_45() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000001 |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_46() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000001 | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_47() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000001 |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_48() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000001 | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_49() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000001 |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_50() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000001 | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_51() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000001 | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_52() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_53() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_54() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000002 |         |\n" +
			"+---------+---------+\n" +
			"| #000001 | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_55() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_56() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_57() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_58() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_59() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_60() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_61() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_62() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_63() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_64() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_65() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_66() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_67() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,0)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_68() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_69() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000003 | #000001 |\n" +
			"+---------+---------+\n" +
			"|         | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_70() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_71() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_72() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_73() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_74() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_75() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_76() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_77() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 |         |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_78() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_79() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_80() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_81() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_82() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_83() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(1,1)));
		board.apply(new Move(new Location(0,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"| #000001 | #000002 |\n" +
			"+---------+---------+\n" +
			"|         | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_84() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(1,0)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000001 |\n" +
			"+---------+---------+\n" +
			"| #000003 | #000002 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	@Test public void test_85() {
		int[] image = {
			0x000001, 0x000002,
			0x000003, 0x000004,
		};
		// Create board
		Board board = new Board(image,2,2);
		// Apply operation sequence
		board.apply(new Move(new Location(0,1)));
		board.apply(new Move(new Location(0,0)));
		board.apply(new Move(new Location(1,1)));
		assertFalse(board.isFinished());
		// Check output
		assertEquals(
			"+---------+---------+\n" +
			"|         | #000002 |\n" +
			"+---------+---------+\n" +
			"| #000001 | #000003 |\n" +
			"+---------+---------+\n"
		,board.toString());
	}
	
	//invalid location - doesnt do anything keep win condition as it is started with it
		@Test public void test_86() {
			int[] image = {
					0x000001, 0x000002,
					0x000003, 0x000004,
				};
				// Create board
				Board board = new Board(image,2,2);
				// Apply operation sequence
				board.apply(new Move(new Location(1,0)));
				board.apply(new Move(new Location(1,1)));
				board.apply(new Move(new Location(-1,-1)));
				// Check output
				assertEquals(
					"+---------+---------+\n" +
					"| #000001 | #000002 |\n" +
					"+---------+---------+\n" +
					"| #000003 |         |\n" +
					"+---------+---------+\n"
				,board.toString());
				assertTrue(board.isFinished());
		}
		
		//out of bounds location - shouldnt do anything - keep win condition as it is started with it
			@Test public void test_87() {
				int[] image = {
						0x000001, 0x000002,
						0x000003, 0x000004,
					};
					// Create board
					Board board = new Board(image,2,2);
					// Apply operation sequence
					board.apply(new Move(new Location(1,0)));
					board.apply(new Move(new Location(1,1)));
					board.apply(new Move(new Location(2,2)));
					// Check output
					assertEquals(
						"+---------+---------+\n" +
						"| #000001 | #000002 |\n" +
						"+---------+---------+\n" +
						"| #000003 |         |\n" +
						"+---------+---------+\n"
					,board.toString());
					assertTrue(board.isFinished());
		}
			
			//NULL location - shouldnt do anything - keep win condition
		@Test public void test_88() {
				int[] image = {
						0x000001, 0x000002,
						0x000003, 0x000004,
					};
					// Create board
					Board board = new Board(image,2,2);
					// Apply operation sequence
					board.apply(new Move(new Location(1,0)));
					board.apply(new Move(new Location(1,1)));
					board.apply(new Move(null));
					// Check output
					assertEquals(
						"+---------+---------+\n" +
						"| #000001 | #000002 |\n" +
						"+---------+---------+\n" +
						"| #000003 |         |\n" +
						"+---------+---------+\n"
					,board.toString());
					assertTrue(board.isFinished());
			}
		
		//4 rotations should essential revert it back to normal, keep win condition as it started out with it
		@Test public void test_89() {
			int[] image = {
				0x000011, 0x000012, 0x000013, 0x000014, 0x000015, 0x000016,
				0x000017, 0x000018, 0x000019, 0x000020, 0x000021, 0x000022,
				0x000023, 0x000024, 0x000025, 0x000026, 0x000027, 0x000028,
				0x000029, 0x000030, 0x000031, 0x000032, 0x000033, 0x000034,
				0x000035, 0x000036, 0x000037, 0x000038, 0x000039, 0x000040,
				0x000041, 0x000042, 0x000043, 0x000044, 0x000045, 0x000046,
			};
			// Create board
			Board board = new Board(image,6,3);
			// Apply operation sequence
			board.apply(new Rotation(new Location(2,0),4));
			// Check output
			
			assertEquals(
				"+------------------+------------------+------------------+\n" +
				"| #000011  #000012 | #000013  #000014 | #000015  #000016 |\n" +
				"| #000017  #000018 | #000019  #000020 | #000021  #000022 |\n" +
				"+------------------+------------------+------------------+\n" +
				"| #000023  #000024 | #000025  #000026 | #000027  #000028 |\n" +
				"| #000029  #000030 | #000031  #000032 | #000033  #000034 |\n" +
				"+------------------+------------------+------------------+\n" +
				"| #000035  #000036 | #000037  #000038 |                  |\n" +
				"| #000041  #000042 | #000043  #000044 |                  |\n" +
				"+------------------+------------------+------------------+\n"
			,board.toString());
			assertTrue(board.isFinished());
		}
}