package chess;

public abstract class AbstactPiece implements Piece {
	
	PieceColor color;
	
	public AbstactPiece(PieceColor color) {
		this.color = color;
	}
	
	public PieceColor getPieceColor() {
		return color;
	}
	
	public boolean canTake(String to, String from, Board board){
		
	}
	

}
