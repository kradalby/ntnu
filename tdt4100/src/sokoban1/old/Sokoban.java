package sokoban1.old;

public class Sokoban {
	
	Board board;

	public Sokoban(String[] St) {
		board = new Board(St);
	}
	
	
	
	
	public boolean canMove(int dx, int dy) {
		if (board.getCell(board.playerX+dx, board.playerY+dy) == '#') {return false;}
		else if (board.getCell(board.playerX+dx, board.playerY+dy) == ' ') {return true;}
		else if (board.getCell(board.playerX+dx, board.playerY+dy) == '.') {return true;}
		else if ((board.getCell(board.playerX+dx, board.playerY+dy) == '*') && canMoveBox(dx,dy)) {return true;}
		else if ((board.getCell(board.playerX+dx, board.playerY+dy) == '$') && canMoveBox(dx,dy)) {return true;}
		else {return false;}
	}
	
	public boolean canMoveBox(int dx, int dy) {
		if ((board.getCell(board.playerX+2*dx,board.playerY+2*dy) == ' ' )|| (board.getCell(board.playerX+2*dx,board.playerY+2*dy) == '.')) {
			return true;
		}
		return false;
	}
	
	public void doMove(int dx, int dy) {
		char cur = board.getCell(board.playerX, board.playerY);
		char enFrem = board.getCell(board.playerX+(dx), board.playerY+(dy));
		char toFrem = board.getCell(board.playerX+(2*dx), board.playerY+(2*dy));
		if (canMove(dx, dy)) {
			if (cur == '+') {
				board.setCell('.', board.playerX, board.playerY);
			} else {
				board.setCell(' ', board.playerX, board.playerY);
			}
			if (enFrem == '.') {
				board.setCell('+', board.playerX+dx, board.playerY+dy);
			} else if (enFrem == ' ') {
				board.setCell('@', board.playerX+dx, board.playerY+dy);
			}
			
			if (enFrem == '$' && canMoveBox(dx,dy)) {
				if (toFrem == '.') {
					board.setCell('@', board.playerX+dx, board.playerY+dy);
					board.setCell('*', board.playerX + (2*dx), board.playerY + (2*dy));
				} else if (toFrem == ' ') {
					board.setCell('@', board.playerX+dx, board.playerY+dy);
					board.setCell('$', board.playerX + (2*dx), board.playerY + (2*dy));
				}
			}
			if (enFrem == '*' && canMoveBox(dx,dy)) {
				if (toFrem == ' ') {
					board.setCell('+', board.playerX+dx, board.playerY+dy);
					board.setCell('$', board.playerX + (2*dx), board.playerY + (2*dy));
				} else if (toFrem == '.') {
					board.setCell('+', board.playerX+dx, board.playerY+dy);
					board.setCell('*', board.playerX + (2*dx), board.playerY + (2*dy));
				}
			}
			
			board.playerX = board.playerX + dx;
			board.playerY = board.playerY + dy;
		} else {
			board.playerX = board.playerX;
			board.playerY = board.playerY;
		}
		
	}
	
	public boolean hasWon() {
		if (board.toString().contains("$")) {return false;}
		else {return true;}
	}
}