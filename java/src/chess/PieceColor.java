package chess;

public enum PieceColor {
	WHITE,
	BLACK;
	
	public PieceColor getOtherColor() {
		if (WHITE) {
			return BLACK;
		} else {
			return WHITE;
		}
	}
}
