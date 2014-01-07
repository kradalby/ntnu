package chess;

public class Board {
	Piece[][] board;
	
	public Board() {
		board = new Piece[8][8];	
	}
	
	public Piece getPiece(String derp) {
		return board[getRow(derp)][getColumn(derp)];
	}
	
	public void setPiece(String derp, Piece piece) {
		board[getRow(derp)][getColumn(derp)] = piece;
	}
	
	private static int getRow(String derp) {
		return derp.charAt(1) - '1';
	}
	
	private static int getColumn(String derp) {
		return derp.charAt(0) - 'a';
	}
	
	public static boolean isStraight(String from, String to) {
		if (getRow(from) == getRow(to)) {
			return true;
		} else if (getColumn(from) == getColumn(to)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isDiagonal(String from, String to) {
		if ((getRow(from) - getRow(to)) == (getColumn(from) - getColumn(to))) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isOccupiedBetween(String from, String to) {
		if (isStraight(from, to)) {
			if (getColumn(to) == getColumn(from)) {
				for (int i = 0; )
			}
		}
	}
	
}
