package chess;

public class Rook extends AbstactPiece {
	
	public Rook(PieceColor color) {
		super(color);
	}

	@Override
	public boolean canMove(String to, String from, Board board) {
		return Board.isStraight(from, to);
		
	}

}
