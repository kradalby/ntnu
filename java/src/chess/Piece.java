package chess;

public interface Piece {
	public PieceColor getPieceColor();
	public boolean canTake(String to, String from, Board board);
	public boolean canMove(String to, String from, Board board);
}
