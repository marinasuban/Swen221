package swen221.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import swen221.chessview.Board;
import swen221.chessview.ChessGame;
import swen221.chessview.Position;
import swen221.chessview.Round;
import swen221.chessview.moves.Check;
import swen221.chessview.moves.EnPassant;
import swen221.chessview.moves.Move;
import swen221.chessview.moves.MultiPieceMove;
import swen221.chessview.moves.NonCheck;
import swen221.chessview.moves.PawnPromotion;
import swen221.chessview.moves.SinglePieceMove;
import swen221.chessview.moves.SinglePieceTake;
import swen221.chessview.pieces.Bishop;
import swen221.chessview.pieces.King;
import swen221.chessview.pieces.Knight;
import swen221.chessview.pieces.Pawn;
import swen221.chessview.pieces.Piece;
import swen221.chessview.pieces.Queen;
import swen221.chessview.pieces.Rook;

public class ChessViewTests {

	// ================================================
	// Valid Tests
	// ================================================
	// The following provides a simple helper method for all tests.
		public static void check(String input, String expectedOutput) {
			try {
				ChessGame game = new ChessGame(input);
				List<Board> boards = game.boards();
				if (boards.isEmpty()) {
					fail("test failed with insufficient boards on input: " + input);
				}
				String actualOutput = boards.get(boards.size() - 1).toString();
				assertEquals(expectedOutput, actualOutput);
			} catch (Exception e) {
				fail("test failed because of exception on input: " + input);
			}
		}
		
	@Test public void testValid_01() {
		String input =
			"a2-a3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_02() {
		String input =
			"a2-a3 b7-b6\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|p|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_03() {
		String input =
			"a2-a4 b7-b5\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|p|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_04() {
		String input =
			"d2-d4 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|P|p|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_05() {
		String input =
			"d2-d3 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"d3xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_06() {
		String input =
			"Nb1-c3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|N|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_07() {
		String input =
			"Nb1-a3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|N|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_08() {
		String input =
			"d2-d4 Nb8-c6\n" +
			"e2-e4 Nc6xd4\n" +
			"";
		String output =
			"8|r|_|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|n|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_09() {
		String input =
			"Nb1-c3 e7-e5\n" +
			"e2-e3 e5-e4\n" +
			"Nc3xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|N|_|_|_|\n" +
			"3|_|_|_|_|P|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_10() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|B|_|\n" +
			"4|_|_|_|_|_|_|b|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_11() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"Bg5-h4\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|b|B|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_12() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"Bg5xe7\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|B|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|b|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_13() {
		String input =
			"e2-e4 e7-e5\n" +
			"Qd1-g4 Qd8-h4\n" +
			"Qg4-f4 Qh4-h6\n" +
			"Qf4-f6 Qh6xh2\n" +
			"";
		String output =
			"8|r|n|b|_|k|b|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|Q|_|_|\n" +
			"5|_|_|_|_|p|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|q|\n" +
			"1|R|N|B|_|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_14() {
		String input =
			"a2-a4 h7-h5\n" +
			"Ra1-a3 Rh8-h6\n" +
			"Ra3-d3 Rh6-g6\n" +
			"Rd3xd7\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|_|\n" +
			"7|p|p|p|R|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|r|_|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|_|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test15() {
		String input =
						"e2-e3 e7-e6\n" +
						"Ke1-e2 Ke8-e7\n" +
						"";
		String output =
						"8|r|n|b|q|_|b|n|r|\n" +
						"7|p|p|p|p|k|p|p|p|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|P|_|_|_|\n" +
						"2|P|P|P|P|K|P|P|P|\n" +
						"1|R|N|B|Q|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}
	
	@Test public void test16() {
		String input =
						"e2-e4 e7-e5\n" +
						"Qd1-g4 Qd8-h4\n" +
						"Qg4xQh4 Nb8-c6\n" +
						"Qh4xh7 Nc6-d4\n" +
						"Qh7xRh8 Nd4-b3\n" +
						"Qh8xNg8 Nb3-a5\n" +
						"Qg8xBf8+ Na5-c4";
		String output =
						"8|r|_|b|_|k|Q|_|_|\n" +
						"7|p|p|p|p|_|p|p|_|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|n|_|_|_|p|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|_|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	
	 @Test public void test17_WhiteEnPassant() {
	        String input = "a2-a4 h7-h6\n" +
	                       "a4-a5 b7-b5\n" +
	                       "a5xb6ep\n" +
	                       "";
	        String output = "8|r|n|b|q|k|b|n|r|\n" +
	                        "7|p|_|p|p|p|p|p|_|\n" +
	                        "6|_|P|_|_|_|_|_|p|\n" +
	                        "5|_|_|_|_|_|_|_|_|\n" +
	                        "4|_|_|_|_|_|_|_|_|\n" +
	                        "3|_|_|_|_|_|_|_|_|\n" +
	                        "2|_|P|P|P|P|P|P|P|\n" +
	                        "1|R|N|B|Q|K|B|N|R|\n" +
	                        "  a b c d e f g h";

	        check(input, output);
	    }
	 
	 @Test public void test18() {
			String input =
							"h2-h4 a7-a5\n" +
							"a2-a4 h7-h5\n" +
							"Rh1-h3 Ra8-a6\n" +
							"Ra1-a3 Rh8-h6\n" +
							"";
			String output =
							"8|_|n|b|q|k|b|n|_|\n" +
							"7|_|p|p|p|p|p|p|_|\n" +
							"6|r|_|_|_|_|_|_|r|\n" +
							"5|p|_|_|_|_|_|_|p|\n" +
							"4|P|_|_|_|_|_|_|P|\n" +
							"3|R|_|_|_|_|_|_|R|\n" +
							"2|_|P|P|P|P|P|P|_|\n" +
							"1|_|N|B|Q|K|B|N|_|\n" +
							"  a b c d e f g h";

			check(input,output);
		}
	 
	 @Test public void test19() {
			Piece[] p = {
					new Pawn(true),
					new Knight(true),
					new Bishop(true),
					new Rook(true),
					new Queen(true),
					new King(true)
			};

			String[] expectedChar = {
					"",
					"N",
					"B",
					"R",
					"Q",
					"K"
			};
			
			for(int i = 0; i < p.length; ++i) {
				Position oldPos = new Position(0, 0);
				Position newPos = new Position(1, 1);
				SinglePieceMove move = new SinglePieceMove(p[i], oldPos, newPos);
				assertEquals(p[i], move.piece());
				assertEquals(oldPos, move.oldPosition());
				assertEquals(newPos, move.newPosition());
				assertEquals(expectedChar[i] + oldPos + "-" + newPos, move.toString());
			}
		}
	 
	 @Test public void test20() {
			Position oldPos = new Position(0, 0);
			Position newPos = new Position(1, 1);
			SinglePieceTake move = new SinglePieceTake(new Queen(true), new Rook(false), oldPos, newPos);


			assertEquals("Q" + oldPos + "xR"+ newPos, move.toString());
	}

	@Test public void test21() {
		Position oldPos = new Position(0, 0);
		Position newPos = new Position(1, 1);
		SinglePieceTake move = new SinglePieceTake(new Queen(true), new Rook(false), oldPos, newPos);


		assertEquals("Q" + oldPos + "xR"+ newPos, move.toString());
	}

	@Test public void test22() {
		Pawn p = new Pawn(true);
		p.setDoubleStep(true);
		assertTrue(p.wasDoubleStep());
		p.setDoubleStep(false);
		assertFalse(p.wasDoubleStep());
	}
	
	@Test public void test23() {
		Pawn p = new Pawn(true);
		Pawn p2 = new Pawn(false);
		Pawn p3 = null;
		Rook p4 = new Rook(true);

		assertFalse(p.equals(p2));
		assertFalse(p.equals(p3));
		assertFalse(p.equals(p4));
	}

	@Test public void test24() {
		Board b = new Board();
		assertFalse(b.kingMoved(true));
		assertFalse(b.kingMoved(false));

		b.setKingMoved(true);
		assertTrue(b.kingMoved(true));
		assertFalse(b.kingMoved(false));

		b.setKingMoved(false);
		assertTrue(b.kingMoved(true));
		assertTrue(b.kingMoved(false));
	}
	
	


	// ================================================
	// Invalid Tests
	// ================================================

	@Test public void testInvalid_01() {
		String input =
			"a2-a4 a7-a4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	@Test public void test25() {
		Board b = new Board();
		assertFalse(b.rookMoved(false, false));
		assertFalse(b.rookMoved(false, true));
		assertFalse(b.rookMoved(true, false));
		assertFalse(b.rookMoved(true, true));

		b.setRookMoved(false, false);
		assertTrue(b.rookMoved(false, false));
		assertFalse(b.rookMoved(false, true));
		assertFalse(b.rookMoved(true, false));
		assertFalse(b.rookMoved(true, true));

		b.setRookMoved(false, true);
		assertTrue(b.rookMoved(false, false));
		assertTrue(b.rookMoved(false, true));
		assertFalse(b.rookMoved(true, false));
		assertFalse(b.rookMoved(true, true));

		b.setRookMoved(true, false);
		assertTrue(b.rookMoved(false, false));
		assertTrue(b.rookMoved(false, true));
		assertTrue(b.rookMoved(true, false));
		assertFalse(b.rookMoved(true, true));

		b.setRookMoved(true, true);
		assertTrue(b.rookMoved(false, false));
		assertTrue(b.rookMoved(false, true));
		assertTrue(b.rookMoved(true, false));
		assertTrue(b.rookMoved(true, true));
	}

	@Test public void test26() {
		Board b = new Board();
		Piece p = new Pawn(true);
		Position pos = new Position(5, 5);

		assertNull(b.pieceAt(pos));
		b.setPieceAt(pos, p);
		assertEquals(p, b.pieceAt(pos));
	}

	@Test public void test27() {
		Board b = new Board();
		Piece p = new Pawn(true);
		Piece p2 = new Pawn(false);
		Position pos1 = new Position(5, 8);
		Position pos2 = new Position(5, 1);
		b.setPieceAt(pos1, p);
		b.setPieceAt(pos2, p2);
		assertTrue(b.clearRowExcept(new Position(5, 2), new Position(5, 7)));
		assertFalse(b.clearRowExcept(new Position(5, 1), new Position(5, 7)));
		assertFalse(b.clearRowExcept(new Position(5, 2), new Position(5, 8)));
		assertFalse(b.clearRowExcept(new Position(5, 1), new Position(5, 8), p));
		assertFalse(b.clearRowExcept(new Position(5, 1), new Position(5, 8), p2));
		assertTrue(b.clearRowExcept(new Position(5, 1), new Position(5, 8), p, p2));
	}

	@Test public void test28() {
		Board b = new Board();
		Piece p = new Pawn(true);
		Piece p2 = new Pawn(false);
		Position pos1 = new Position(8, 5);
		Position pos2 = new Position(1, 5);
		b.setPieceAt(pos1, p);
		b.setPieceAt(pos2, p2);
		b.setPieceAt(new Position(7, 5), null);
		b.setPieceAt(new Position(2, 5), null);

		assertTrue(b.clearColumnExcept(new Position(2, 5), new Position(7, 5)));
		assertFalse(b.clearColumnExcept(new Position(1, 5), new Position(7, 5)));
		assertFalse(b.clearColumnExcept(new Position(2, 5), new Position(8, 5)));
		assertFalse(b.clearColumnExcept(new Position(1, 5), new Position(8, 5), p));
		assertFalse(b.clearColumnExcept(new Position(1, 5), new Position(8, 5), p2));
		assertTrue(b.clearColumnExcept(new Position(1, 5), new Position(8, 5), p, p2));
	}

	@Test public void test29() {
		Position pos1 = new Position(8, 5);
		Position pos2 = new Position(1, 5);
		Position pos3 = new Position(8, 5);
		assertFalse(pos1.equals(pos2));
		assertNotEquals(pos1.hashCode(), pos2.hashCode());

		assertTrue(pos1.equals(pos3));
		assertEquals(pos1.hashCode(), pos3.hashCode());

		assertFalse(pos1.equals(null));
	}

	@Test public void test30() {
		String input =
						"d2-d4 e7-e6\n" +
						"h2-h3 Bf8-b4+\n" +
						"h3-h4"; // Should be invalid because white king is in check
		String output =
						"8|r|n|b|q|k|_|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|b|_|P|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|P|\n" +
						"2|P|P|P|_|P|P|P|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}
	
	@Test public void test31() {
		String input =
						"d2-d4 e7-e6\n" +
						"h2-h3 Bf8-b4+\n" +
						"c2-c3"; // Should be valid to block check
		String output =
						"8|r|n|b|q|k|_|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|b|_|P|_|_|_|_|\n" +
						"3|_|_|P|_|_|_|_|P|\n" +
						"2|P|P|_|_|P|P|P|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test32() {
		String input =
						"d2-d4 e7-e6\n" +
						"h2-h3 Bf8-b5+\n" +
						"c2-c3";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|P|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|P|\n" +
						"2|P|P|P|_|P|P|P|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test33() {
		Position p1 = new Position(5, 3);
		Position p2 = new Position(2, 8);
		Piece p = new Queen(false);
		MultiPieceMove mm = new SinglePieceMove(p, p1, p2);
		Check m = new Check(mm);
		assertEquals(mm, m.move());
		assertEquals(mm.toString() + "+", m.toString());
	}

	@Test public void test34() {
		Position p1 = new Position(5, 3);
		Position p2 = new Position(2, 8);
		Piece p = new Queen(false);
		MultiPieceMove mm = new SinglePieceMove(p, p1, p2);
		NonCheck m = new NonCheck(mm);
		assertEquals(mm, m.move());
		assertEquals(mm.toString(), m.toString());
	}
	
	@Test public void test35_Enpassant() {
		String input =
						"e2-e4 h7-h6\n" +
						"e4-e5 f7-f5\n" +
						"e5xf6ep";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|_|p|_|\n" +
						"6|_|_|_|_|_|P|_|p|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}
	@Test public void test36() {
		String input =
						"e2-e4 h7-h6\n" +
						"e4-e5 f7-f5\n" +
						"e5xe6ep";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|_|p|_|\n" +
						"6|_|_|_|_|_|_|_|p|\n" +
						"5|_|_|_|_|P|p|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test37() {
		String input =
						"e2-e4 h7-h6\n" +
						"e4-e5 f7-f5\n" +
						"e5xe7ep";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|_|p|_|\n" +
						"6|_|_|_|_|_|_|_|p|\n" +
						"5|_|_|_|_|P|p|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test38() {
		String input =
						"e2-e4 h7-h6\n" +
						"a2-a3 f7-f5\n" +
						"e4xf6ep";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|_|p|_|\n" +
						"6|_|_|_|_|_|_|_|p|\n" +
						"5|_|_|_|_|_|p|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|P|_|_|_|_|_|_|_|\n" +
						"2|_|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test39() {
		Board b = new Board();
		Pawn p = new Pawn(true);
		b.setPieceAt(new Position(5, 6), null);
		b.setPieceAt(new Position(5, 5), p);
		EnPassant ep = new EnPassant(new SinglePieceMove(p, new Position(5, 5), new Position(6, 6)));
		assertFalse(ep.isValid(b));
	}

	@Test public void test40() {
		Board b = new Board();
		Pawn p = new Pawn(true);
		b.setPieceAt(new Position(6, 6), new Pawn(false));
		b.setPieceAt(new Position(5, 5), p);
		EnPassant ep = new EnPassant(new SinglePieceMove(p, new Position(5, 5), new Position(6, 6)));
		assertFalse(ep.isValid(b));
	}
	
	@Test public void test41() {
		Board b = new Board();
		Pawn p = new Pawn(true);
		Pawn p2 = new Pawn(false);
		p2.setDoubleStep(false);
		b.setPieceAt(new Position(5, 6), p2);
		b.setPieceAt(new Position(5, 5), p);
		EnPassant ep = new EnPassant(new SinglePieceMove(p, new Position(5, 5), new Position(6, 6)));
		assertFalse(ep.isValid(b));
	}

	@Test public void test42() {
		Board b = new Board();
		Pawn p = new Pawn(true);
		b.setPieceAt(new Position(5, 6), new Queen(false));
		b.setPieceAt(new Position(5, 5), p);
		EnPassant ep = new EnPassant(new SinglePieceMove(p, new Position(5, 5), new Position(6, 6)));
		assertFalse(ep.isValid(b));
	}

	@Test public void test43() {
		Board b = new Board();
		Pawn p = new Pawn(true);
		Pawn p2 = new Pawn(false);
		p2.setDoubleStep(false);
		b.setPieceAt(new Position(5, 6), p2);
		b.setPieceAt(new Position(5, 5), p);
		EnPassant ep = new EnPassant(new SinglePieceMove(p, new Position(5, 5), new Position(6, 6)));
		assertEquals(new Position(5, 5).toString() + "x" + new Position(6, 6).toString() + "ep", ep.toString());
	}

	@Test public void test44() {
		Move m1 = new SinglePieceMove(new Queen(false), new Position(1, 1), new Position(2, 2));
		Move m2 = new SinglePieceMove(new King(true), new Position(8, 8), new Position(7, 7));

		Round r = new Round(m1, m2);
		assertEquals("Qa1-b2 Kh8-g7", r.toString());

		Round r2 = new Round(m1, null);
		assertEquals("Qa1-b2", r2.toString());

	}

	@Test public void test45() {
		Board b = new Board();
		Pawn p = new Pawn(true);
		b.setPieceAt(new Position(8, 1), null);
		b.setPieceAt(new Position(7, 1), p);
		PawnPromotion pro = new PawnPromotion(new SinglePieceMove(p, new Position(7, 1), new Position(8, 1)), new Queen(true));
		assertTrue(pro.isValid(b));
		pro.apply(b);
		assertEquals(new Queen(true), b.pieceAt(new Position(8, 1)));
		assertEquals(new Position(7, 1).toString() + "-" + new Position(8, 1).toString() + "=Q", pro.toString());
	}
	
	@Test public void test46() {
		Board b = new Board();
		Pawn p = new Pawn(true);
		//Pawn p2 = new Pawn(false);
		//p2.setDoubleStep(false);
		b.setPieceAt(new Position(8, 1), null);
		b.setPieceAt(new Position(7, 1), p);
		PawnPromotion pro = new PawnPromotion(new SinglePieceMove(p, new Position(7, 1), new Position(8, 1)), new Queen(false));
		assertFalse(pro.isValid(b));
	}

	@Test public void test47() {
		String input =
						"e2-e4 e7-e5\n" +
						"Bf1-e2 Bf8-e7\n" +
						"Ng1-f3 Ng8-f6\n" +
						"O-O O-O";
		String output =
						"8|r|n|b|q|_|r|k|_|\n" +
						"7|p|p|p|p|b|p|p|p|\n" +
						"6|_|_|_|_|_|n|_|_|\n" +
						"5|_|_|_|_|p|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|N|_|_|\n" +
						"2|P|P|P|P|B|P|P|P|\n" +
						"1|R|N|B|Q|_|R|K|_|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test48() {
		String input =
						"e2-e4 e7-e5\n" +
						"Bf1-e2 Bf8-e7\n" +
						"Ng1-f3 Ng8-f6\n" +
						"O-O+ O-O+";
		String output =
						"8|r|n|b|q|k|_|_|r|\n" +
						"7|p|p|p|p|b|p|p|p|\n" +
						"6|_|_|_|_|_|n|_|_|\n" +
						"5|_|_|_|_|p|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|N|_|_|\n" +
						"2|P|P|P|P|B|P|P|P|\n" +
						"1|R|N|B|Q|K|_|_|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test49() {
		String input =
						"e2-e4 e7-e5\n" +
						"Qd1-e2 Qd8-e7\n" +
						"d2-d4 d7-d5\n" +
						"Bc1-d2 Bc8-d7\n" +
						"Nb1-a3 Nb8-a6\n" +
						"O-O-O O-O-O";
		String output =
						"8|_|_|k|r|_|b|n|r|\n" +
						"7|p|p|p|b|q|p|p|p|\n" +
						"6|n|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|p|p|_|_|_|\n" +
						"4|_|_|_|P|P|_|_|_|\n" +
						"3|N|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|B|Q|P|P|P|\n" +
						"1|_|_|K|R|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test50() {
		String input =
				"e2-e4 e7-e5\n" +
						"Qd1-e2 Qd8-e7\n" +
						"d2-d4 d7-d5\n" +
						"Bc1-d2 Bc8-d7\n" +
						"Nb1-a3 Nb8-a6\n" +
						"O-O-O+ O-O-O+";
		String output =
						"8|r|_|_|_|k|b|n|r|\n" +
						"7|p|p|p|b|q|p|p|p|\n" +
						"6|n|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|p|p|_|_|_|\n" +
						"4|_|_|_|P|P|_|_|_|\n" +
						"3|N|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|B|Q|P|P|P|\n" +
						"1|R|_|_|_|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test54() {
		String input =
						"e2-e4 d7-d5\n" +
						"e4xd5 Qd8-d6\n" +
						"f2-f4 Qd6-h6\n" +
						"d5-d6 e7-e5\n" +
						"Bf1-e2 e5xf4\n" +
						"d6-d7 Ke8-e7\n" +
						"d7-d8=N\n" +
						"";
		String output =
						"8|r|n|b|N|_|b|n|r|\n" +
						"7|p|p|p|_|k|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|q|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|p|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|B|_|P|P|\n" +
						"1|R|N|B|Q|K|_|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test55() {
		String input =
				"e2-e4 d7-d5\n" +
						"e4xd5 Qd8-d6\n" +
						"f2-f4 Qd6-h6\n" +
						"d5-d6 e7-e5\n" +
						"Bf1-e2 e5xf4\n" +
						"d6-d7 Ke8-e7\n" +
						"d7-d8=B\n" +
						"";
		String output =
						"8|r|n|b|B|_|b|n|r|\n" +
						"7|p|p|p|_|k|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|q|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|p|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|B|_|P|P|\n" +
						"1|R|N|B|Q|K|_|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}
	
	@Test public void test56() {
		String input =
				"e2-e4 d7-d5\n" +
						"e4xd5 Qd8-d6\n" +
						"f2-f4 Qd6-h6\n" +
						"d5-d6 e7-e5\n" +
						"Bf1-e2 e5xf4\n" +
						"d6-d7 Ke8-e7\n" +
						"d7-d8=R\n" +
						"";
		String output =
						"8|r|n|b|R|_|b|n|r|\n" +
						"7|p|p|p|_|k|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|q|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|p|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|B|_|P|P|\n" +
						"1|R|N|B|Q|K|_|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test57() {
		String input =
				"e2-e4 d7-d5\n" +
						"e4xd5 Qd8-d6\n" +
						"f2-f4 Qd6-h6\n" +
						"d5-d6 e7-e5\n" +
						"Bf1-e2 e5xf4\n" +
						"d6-d7 Ke8-e7\n" +
						"d7-d8=K\n" +
						"";
		String output =
						"8|r|n|b|K|_|b|n|r|\n" +
						"7|p|p|p|_|k|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|q|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|p|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|B|_|P|P|\n" +
						"1|R|N|B|Q|K|_|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void test58() {
		String input =
				"e2-e4 d7-d5\n" +
						"e4xd5 Qd8-d6\n" +
						"f2-f4 Qd6-h6\n" +
						"d5-d6 e7-e5\n" +
						"Bf1-e2 e5xf4\n" +
						"d6-d7 Ke8-e7\n" +
						"d7-d8=Q\n" +
						"";
		String output =
						"8|r|n|b|Q|_|b|n|r|\n" +
						"7|p|p|p|_|k|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|q|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|p|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|B|_|P|P|\n" +
						"1|R|N|B|Q|K|_|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test
    public void test59_Castling_for_King_Queen() {
        String input = "d2-d4 e7-e5\n" +
                       "e2-e3 d7-d5\n" +
                       "c2-c4 d5xc4\n" +
                       "Bf1xc4 Nb8-a6\n" +
                       "Ng1-h3 e5-e4\n" +
                       "Nh3-f4 f7-f5\n" +
                       "Bc4xNg8 Rh8xBg8\n" +
                       "O-O Bc8-e6\n" +
                       "a2-a3 Qd8-d7\n" +
                       "b2-b3 O-O-O\n" +
                       "Kg1-h1 Kc8-a8\n" +
                       "";
        String output = "8|_|_|k|r|_|b|r|_|\n" +
                        "7|p|p|p|q|_|_|p|p|\n" +
                        "6|n|_|_|_|b|_|_|_|\n" +
                        "5|_|_|_|_|_|p|_|_|\n" +
                        "4|_|_|_|P|p|N|_|_|\n" +
                        "3|P|P|_|_|P|_|_|_|\n" +
                        "2|_|_|_|_|_|P|P|P|\n" +
                        "1|R|N|B|Q|_|R|_|K|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test60_Castling_check() {
        String input = "Nb1-c3 e7-e5\n" +
                       "d2-d4 Qd8-h4\n" +
                       "Bc1-h6 d7-d6\n" +
                       "d4xe5 Ke8-d8\n" +
                       "Qd1-d4 Qh4xQd4\n" +
                       "e5xd6 Qd4xd6\n" +
                       "h2-h3 Qd6-g6\n" +
                       "O-O-O+\n" +
                       "";
        String output = "8|r|n|b|k|_|b|n|r|\n" +
                        "7|p|p|p|_|_|p|p|p|\n" +
                        "6|_|_|_|_|_|_|q|B|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|_|_|_|_|_|_|\n" +
                        "3|_|_|N|_|_|_|_|P|\n" +
                        "2|P|P|P|_|P|P|P|_|\n" +
                        "1|_|_|K|R|_|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test61_WhiteEnPassant() {
        String input = "a2-a4 h7-h6\n" +
                       "a4-a5 b7-b5\n" +
                       "a5xb6ep\n" +
                       "";
        String output = "8|r|n|b|q|k|b|n|r|\n" +
                        "7|p|_|p|p|p|p|p|_|\n" +
                        "6|_|P|_|_|_|_|_|p|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|_|_|_|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|_|P|P|P|P|P|P|P|\n" +
                        "1|R|N|B|Q|K|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    
    @Test
    public void test62_Black_WhiteEnpassant() {
        String input = "h2-h3 b7-b5\n" +
                       "h3-h4 b5-b4\n" +
                       "c2-c4 b4xc3ep\n" +
                       "h4-h5 g7-g5\n" +
                       "h5xg6ep\n" +
                       "";
        String output = "8|r|n|b|q|k|b|n|r|\n" +
                        "7|p|_|p|p|p|p|_|p|\n" +
                        "6|_|_|_|_|_|_|P|_|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|_|_|_|_|_|_|\n" +
                        "3|_|_|p|_|_|_|_|_|\n" +
                        "2|P|P|_|P|P|P|P|_|\n" +
                        "1|R|N|B|Q|K|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);

    }

    @Test
    public void test63_pawnPromotionToRook() {
        String input = "a2-a4 b7-b5\n" +
                       "a4xb5 a7-a6\n" +
                       "b5xa6 c7-c6\n" +
                       "a6-a7 c6-c5\n" +
                       "a7xNb8=R c5-c4\n" +

                       "";
        String output = "8|r|R|b|q|k|b|n|r|\n" +
                        "7|_|_|_|p|p|p|p|p|\n" +
                        "6|_|_|_|_|_|_|_|_|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|p|_|_|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|_|P|P|P|P|P|P|P|\n" +
                        "1|R|N|B|Q|K|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test64_pawnPromotionToQueen() {
        String input = "a2-a4 b7-b5\n" +
                       "a4xb5 a7-a6\n" +
                       "b5xa6 c7-c6\n" +
                       "a6-a7 c6-c5\n" +
                       "a7xNb8=Q c5-c4\n" +
                       "Qb8xRa8 c4-c3\n" +
                       "Qa8xBc8 c3xb2\n" +
                       "Qc8xQd8+\n" +
                       "";
        String output = "8|_|_|_|Q|k|b|n|r|\n" +
                        "7|_|_|_|p|p|p|p|p|\n" +
                        "6|_|_|_|_|_|_|_|_|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|_|_|_|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|_|p|P|P|P|P|P|P|\n" +
                        "1|R|N|B|Q|K|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test65_pawnPromotionToBishop() {
        String input = "a2-a4 b7-b5\n" +
                       "a4xb5 a7-a6\n" +
                       "b5xa6 c7-c6\n" +
                       "a6-a7 c6-c5\n" +
                       "a7xNb8=B c5-c4\n" +
                       "";
        String output = "8|r|B|b|q|k|b|n|r|\n" +
                        "7|_|_|_|p|p|p|p|p|\n" +
                        "6|_|_|_|_|_|_|_|_|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|p|_|_|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|_|P|P|P|P|P|P|P|\n" +
                        "1|R|N|B|Q|K|B|N|R|\n" +
                        "  a b c d e f g h";
        check(input, output);
    }

    @Test
    public void test66_pawnPromotionToKnight() {
        String input = "a2-a4 b7-b5\n" +
                       "a4xb5 a7-a6\n" +
                       "b5xa6 c7-c6\n" +
                       "a6-a7 c6-c5\n" +
                       "a7xNb8=N c5-c4\n" +
                       "";
        String output = "8|r|N|b|q|k|b|n|r|\n" +
                        "7|_|_|_|p|p|p|p|p|\n" +
                        "6|_|_|_|_|_|_|_|_|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|p|_|_|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|_|P|P|P|P|P|P|P|\n" +
                        "1|R|N|B|Q|K|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test67_King_validMove_NonCheckedPos_Knight() {
        String input = "e2-e4 a7-a6\n" +
                       "Ke1-e2 Nb8-c6\n" +
                       "Ke2-f3 e7-e6\n" +
                       "Kf3-e3 g7-g6\n" +
                       "Ke3-e2 h7-h6\n" +
                       "Ke2-d3 Nc6-b4+\n" +
                       "Kd3-c4 Ke8-e7\n" +
                       "Kc4-d5 Rh8-h7\n" +
                       "";
        String output = "8|r|_|b|q|_|b|n|r|\n" +
                        "7|_|p|p|p|k|p|_|_|\n" +
                        "6|p|_|_|_|p|_|p|p|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|n|K|_|P|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|P|P|P|P|_|P|P|P|\n" +
                        "1|R|N|B|Q|_|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);

    }

    @Test
    public void test68_King_validMove_NonCheckedPos_Bishop() {
        String input = "e2-e4 a7-a6\n" +
                       "Ke1-e2 Nb8-c6\n" +
                       "Ke2-f3 e7-e6\n" +
                       "Kf3-e3 g7-g6\n" +
                       "Ke3-e2 h7-h6\n" +
                       "Ke2-d3 Nc6-b4+\n" +
                       "Kd3-d4 Ra8-a7\n" +
                       "Kd4-d5 Rh8-h7\n" +
                       "Kd4-c5 Bf8-d6\n" +
                       "";
        String output = "8|_|_|b|q|k|b|n|r|\n" +
                        "7|r|p|p|p|_|p|_|_|\n" +
                        "6|p|_|_|_|p|_|p|p|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|n|_|K|P|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|P|P|P|P|_|P|P|P|\n" +
                        "1|R|N|B|Q|_|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);

    }

    @Test
    public void test69_Bishop_takeMove() {
        String input = "b2-b4 e7-e5\n" +
                       "Bc1-b2 Bf8xb4\n" +
                       "Bb2xe5 Bb4xd2+\n" +
                       "Ke1xd2 Ke8-f8\n" +
                       "Be5xc7\n" +
                       "";
        String output = "8|r|n|b|q|k|_|n|r|\n" +
                        "7|p|p|p|p|_|p|p|p|\n" +
                        "6|_|_|_|_|_|_|_|_|\n" +
                        "5|_|_|_|_|B|_|_|_|\n" +
                        "4|_|_|_|_|_|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|P|_|P|b|P|P|P|P|\n" +
                        "1|R|N|_|Q|K|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);

    }

    @Test
    public void test70_Rook_takeMove_CheckKing() {
        String input = "a2-a4 h7-h5\n" +
                       "Ra1-a3 Rh8-h6\n" +
                       "Ra3-f3 Rh6-a6\n" +
                       "Rf3xf7 Ra6xa4\n" +
                       "Rf7xe7+ Ke8xe7\n" +
                       "Nb1-c3 Ra4-g4\n" +
                       "";

        String output = "8|r|n|b|q|k|b|n|_|\n" +
                        "7|p|p|p|p|R|_|p|_|\n" +
                        "6|_|_|_|_|_|_|_|_|\n" +
                        "5|_|_|_|_|_|_|_|p|\n" +
                        "4|r|_|_|_|_|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|_|P|P|P|P|P|P|P|\n" +
                        "1|_|N|B|Q|K|B|N|R|\n" +
                        "  a b c d e f g h";
        check(input, output);
    }

    
    @Test
    public void test71_Queen_takeMove() {
        String input = "e2-e4 e7-e5\n" +
                       "Qd1-h5 Qd8-f6\n" +
                       "Qh5xe5+ Ke8-d8\n" +
                       // "Qh5xe5+ Qf6xe5\n" +
                       // "a2-a3\n" +
                       "";
        String output = "8|r|n|b|k|_|b|n|r|\n" +
                        "7|p|p|p|p|_|p|p|p|\n" +
                        "6|_|_|_|_|_|q|_|_|\n" +
                        "5|_|_|_|_|Q|_|_|_|\n" +
                        "4|_|_|_|_|P|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|P|P|P|P|_|P|P|P|\n" +
                        "1|R|N|B|_|K|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test72_Pawn_invalid_01() {
        String input = "a2-b3 e7-f6\n" +
                       "";
        String output = "8|r|n|b|q|k|b|n|r|\n" +
                        "7|p|p|p|p|p|p|p|p|\n" +
                        "6|_|_|_|_|_|_|_|_|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|_|_|_|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|P|P|P|P|P|P|P|P|\n" +
                        "1|R|N|B|Q|K|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test73_Pawn_invalid_02() {
        String input = "a2-a3 e7-f6\n" +
                       "";
        String output = "8|r|n|b|q|k|b|n|r|\n" +
                        "7|p|p|p|p|p|p|p|p|\n" +
                        "6|_|_|_|_|_|_|_|_|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|_|_|_|_|_|_|\n" +
                        "3|P|_|_|_|_|_|_|_|\n" +
                        "2|_|P|P|P|P|P|P|P|\n" +
                        "1|R|N|B|Q|K|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test74_KingMove_01() {
        String input = "d2-d4 d7-d5\n" +
                       "e2-e4 d5xe4\n" +
                       "Ke1-d2 e4-e3\n" +
                       "Kd2xe3 f7-f6\n" +
                       "Ke3-d3 g7-g6\n" +
                       "Kd3-d2 h7-h6\n" +
                       "Kd2-e3 e7-e6\n" +
                       "Ke3-f3 Ke8-e7\n" +
                       "";
        String output = "8|r|n|b|q|_|b|n|r|\n" +
                        "7|p|p|p|_|k|_|_|_|\n" +
                        "6|_|_|_|_|p|p|p|p|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|_|P|_|_|_|_|\n" +
                        "3|_|_|_|_|_|K|_|_|\n" +
                        "2|P|P|P|_|_|P|P|P|\n" +
                        "1|R|N|B|Q|_|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test75_KingMove_02() {
        String input = "d2-d4 d7-d5\n" +
                       "e2-e4 d5xe4\n" +
                       "Ke1-d2 e4-e3\n" +
                       "Kd2xe3 f7-f6\n" +
                       "Ke3-d3 g7-g6\n" +
                       "Kd3-d2 h7-h6\n" +
                       "Kd2-e3 e7-e6\n" +
                       "Ke3-f3 Ke8-e7\n" +
                       "";
        String output = "8|r|n|b|q|_|b|n|r|\n" +
                        "7|p|p|p|_|k|_|_|_|\n" +
                        "6|_|_|_|_|p|p|p|p|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|_|P|_|_|_|_|\n" +
                        "3|_|_|_|_|_|K|_|_|\n" +
                        "2|P|P|P|_|_|P|P|P|\n" +
                        "1|R|N|B|Q|_|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test76_king_takePawn_Queen() {
        String input = "d2-d4 e7-e5\n" +
                       "Ke1-d2 Ke8-e7\n" +
                       "Kd2-e3 Ke7-d6\n" +
                       "d4-d5 e5-e4\n" +
                       "Ke3xe4 Qd8-h4+\n" +
                       "Ke4-e3 Qh4xf2+\n" +
                       "";
        String output = "8|r|n|b|_|_|b|n|r|\n" +
                        "7|p|p|p|p|_|p|p|p|\n" +
                        "6|_|_|_|k|_|_|_|_|\n" +
                        "5|_|_|_|P|_|_|_|_|\n" +
                        "4|_|_|_|_|_|_|_|_|\n" +
                        "3|_|_|_|_|K|_|_|_|\n" +
                        "2|P|P|P|_|P|q|P|P|\n" +
                        "1|R|N|B|Q|_|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }

    @Test
    public void test77_checkKing_02() {
        String input = "d2-d4 d7-d5\n" +
                       "e2-e4 d5xe4\n" +
                       "Ke1-d2 e4-e3\n" +
                       "Kd2xe3 Qd8-d5\n" +
                       "Ke3-e2 Qd5-b5+\n" +
                       "";
        String output = "8|r|n|b|_|k|b|n|r|\n" +
                        "7|p|p|p|_|p|p|p|p|\n" +
                        "6|_|_|_|_|_|_|_|_|\n" +
                        "5|_|q|_|_|_|_|_|_|\n" +
                        "4|_|_|_|P|_|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|P|P|P|_|K|P|P|P|\n" +
                        "1|R|N|B|Q|_|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }


    @Test
    public void test78_King_takeMove_NonCheckedPos_01() {
        String input = "e2-e4 a7-a6\n" +
                       "Ke1-e2 Nb8-c6\n" +
                       "Ke2-f3 e7-e6\n" +
                       "Kf3-e3 g7-g6\n" +
                       "Ke3-e2 h7-h6\n" +
                       "Ke2-d3 Nc6-b4+\n" +
                       "Kd3-d4 Ra8-a7\n" +
                       "Kd4-c3 Rh8-h7\n" +
                       "Kc3-c4 Nb4-d3\n" +
                       "Kc4xd3 a2-a3\n" +
                       "";
        String output = "8|_|_|b|q|k|b|n|_|\n" +
                        "7|r|p|p|p|_|p|_|r|\n" +
                        "6|p|_|_|_|p|_|p|p|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|K|_|P|_|_|_|\n" +
                        "3|_|_|_|n|_|_|_|_|\n" +
                        "2|P|P|P|P|_|P|P|P|\n" +
                        "1|R|N|B|Q|_|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);

    }


    @Test
    public void test79_Knight_Queen_takeMove() {
        String input = "e2-e4 e7-e5\n" +
                       "d2-d4 e5xd4\n" +
                       "Nb1-c3 Qd8-f6\n" +
                       "Nc3-d5 Qf6-f3\n" +
                       "Nd5-b6 Qf3xe4+\n" +
                       "Qd1-e2" +
                       // "Qd1-f3 Qa3-b4+\n" +
                       // "Qf3-f5 Qb4-b3\n" +
                       "";
        String output = "8|r|n|b|_|k|b|n|r|\n" +
                        "7|p|p|p|p|_|p|p|p|\n" +
                        "6|_|N|_|_|_|_|_|_|\n" +
                        "5|_|_|_|_|_|_|_|_|\n" +
                        "4|_|_|_|p|q|_|_|_|\n" +
                        "3|_|_|_|_|_|_|_|_|\n" +
                        "2|P|P|P|_|Q|P|P|P|\n" +
                        "1|R|_|B|_|K|B|N|R|\n" +
                        "  a b c d e f g h";

        check(input, output);
    }
    
	@Test public void test80_check_King() {
		String input =
			"d2-d4 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"Ke1-d2 e4-e3\n"+
			"Kd2xe3 f7-f6\n"+
			"Ke3-d3 g7-g6\n"+
			"Kd3-d2 h7-h6\n"+
			"Kd2-e3 e7-e6\n"+
			"Ke3-f3 Ke8-e7\n"+
			"";
		String output =
			"8|r|n|b|q|_|b|n|r|\n" +
			"7|p|p|p|_|k|_|_|_|\n" +
			"6|_|_|_|_|p|p|p|p|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|P|_|_|_|_|\n" +
			"3|_|_|_|_|_|K|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|_|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	@Test public void test81_blackEnpassant() {
		String input =
			"a2-a3 b7-b5\n" +
			"a3-a4 b5-b4\n" +
			"c2-c4 b4xc3ep";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|p|_|_|_|_|_|\n" +
			"2|_|P|_|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		Board board = new Board();
		Position pos = new Position(1,4);
		Piece p = board.pieceAt(pos);
		p.isWhite();
		pos.toString();
		board.toString();
		
		check(input,output);
		
	}
	
	@Test public void test82_Castling() {
		String input =
				"d2-d4 e7-e5\n"+
				"e2-e3 d7-d5\n"+
				"c2-c4 d5xc4\n"+
				"Bf1xc4 Nb8-c6\n"+
				"Ng1-f3 e5-e4\n"+
				"Nf3-d2 f7-f5\n"+
				"Bc4xNg8 Rh8xBg8\n"+
				"O-O Bc8-e6\n"+
				"a2-a3 Qd8-d7\n"+
				"b2-b3 O-O-O\n"+
				"";
		String output =
			"8|_|_|k|r|_|b|r|_|\n" +
			"7|p|p|p|q|_|_|p|p|\n" +
			"6|_|_|n|_|b|_|_|_|\n" +
			"5|_|_|_|_|_|p|_|_|\n" +
			"4|_|_|_|P|p|_|_|_|\n" +
			"3|P|P|_|_|P|_|_|_|\n" +
			"2|_|_|_|N|_|P|P|P|\n" +
			"1|R|N|B|Q|_|R|K|_|\n" +
			"  a b c d e f g h";
		Board board = new Board();
		board.toString();
		
		check(input,output);
	}
	
	@Test public void test83_Rook() {
		String input =
			"Nb1-c3 Nb8-c6\n"+
		    "Ng1-f3 Ng8-f6\n"+
			"Ra1-b1 Ra8-b8\n"+
		    "Rh1-g1 Rh8-g8\n"+
			"";
		String output =
			"8|_|r|b|q|k|b|r|_|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|n|_|_|n|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|N|_|_|N|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|_|R|B|Q|K|B|R|_|\n" +
			"  a b c d e f g h";
		Board board = new Board();
		board.rookMoved(false, true);
		board.rookMoved(false, false);
		board.rookMoved(true, true);
		board.rookMoved(true, false);
		check(input,output);
	}
	
	@Test public void test84_pawnPromotionToRook() {
		String input =
			"a2-a4 b7-b5\n" +
			"a4xb5 a7-a6\n"+
			"b5xa6 c7-c6\n"+
			"a6-a7 c6-c5\n"+
			"a7xNb8=R c5-c4\n"+
			
			"";
		String output =
			"8|r|R|b|q|k|b|n|r|\n" +
			"7|_|_|_|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|p|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		
		
		check(input,output);
		}
	
	@Test public void test85_EnPassant() {
		String input =
				"a2-a4 h7-h5\n" +
				"a4-a5 b7-b5\n" +
				"a5xb6ep\n"+
				"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|_|\n" +
			"6|_|P|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	@Test public void test86_check() {
		String input =
			"d2-d4 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"Ke1-d2 e4-e3\n"+
			"Kd2xe3 Qd8-d5\n"+
			"Ke3-e2 Qd5-b5+\n"+
			"";
		String output =
			"8|r|n|b|_|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|q|_|_|_|_|_|_|\n" +
			"4|_|_|_|P|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|K|P|P|P|\n" +
			"1|R|N|B|Q|_|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	
	@Test public void test87_pawnPromotionToQueen() {
		String input =
			"a2-a4 b7-b5\n" +
			"a4xb5 a7-a6\n"+
			"b5xa6 c7-c6\n"+
			"a6-a7 c6-c5\n"+
			"a7xNb8=Q c5-c4\n"+
			"Qb8xRa8 c4-c3\n"+
			"Qa8xBc8 c3xb2\n"+
			"Qc8xQd8+\n"+
			"";
		String output =
			"8|_|_|_|Q|k|b|n|r|\n" +
			"7|_|_|_|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|p|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		
		
		check(input,output);
		}
	
	@Test public void test88_pawnPromotionToBishop() {
		String input =
			"a2-a4 b7-b5\n" +
			"a4xb5 a7-a6\n"+
			"b5xa6 c7-c6\n"+
			"a6-a7 c6-c5\n"+
			"a7xNb8=B c5-c4\n"+
			
			"";
		String output =
			"8|r|B|b|q|k|b|n|r|\n" +
			"7|_|_|_|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|p|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		
		try {
			ChessGame game = new ChessGame(input);
			game.rounds();
			game.boards();
		} catch (IOException e) {
		}
		check(input,output);
		}
	
	@Test public void test89_pawnPromotionToKnight() {
		String input =
			"a2-a4 b7-b5\n" +
			"a4xb5 a7-a6\n"+
			"b5xa6 c7-c6\n"+
			"a6-a7 c6-c5\n"+
			"a7xNb8=N c5-c4\n"+
			"";
		String output =
			"8|r|N|b|q|k|b|n|r|\n" +
			"7|_|_|_|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|p|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";
		
		
		check(input,output);
		}
	
		@Test public void test90() {
			String input =
				"Nb1-c3 e7-e5\n" +
				"d2-d4 Qd8-h4\n"+
				"Bc1-h6 d7-d6\n"+
				"d4xe5 Ke8-d8\n"+
				"Qd1-d4 Qh4xQd4\n"+
				"e5xd6 Qd4xd6\n"+
				"h2-h3 Qd6-g6\n"+
				"O-O-O+\n"+
				"";
			String output =
				"8|r|n|b|k|_|b|n|r|\n" +
				"7|p|p|p|_|_|p|p|p|\n" +
				"6|_|_|_|_|_|_|q|B|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|N|_|_|_|_|P|\n" +
				"2|P|P|P|_|P|P|P|_|\n" +
				"1|_|_|K|R|_|B|N|R|\n" +
				"  a b c d e f g h";

			check(input,output);
		}

}
