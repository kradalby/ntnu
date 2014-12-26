package sokoban1.old;

import java.util.ArrayList;

public class Board {
	
	ArrayList<ArrayList<Boolean>> targets;
	ArrayList<ArrayList<Character>> grid;
	int playerX, playerY, sizeX, sizeY;
	
	public Board(String[] St) {
		targets = new ArrayList<ArrayList<Boolean>>();
		grid = new ArrayList<ArrayList<Character>>();
		sizeY = St.length;
		sizeX = St[0].length();
		
		for (int i = 0; i < sizeY; i++) {
			ArrayList<Boolean> tmpt = new ArrayList<Boolean>();
			ArrayList<Character> tmpg = new ArrayList<Character>();
			
			for (int j = 0; j < sizeX; j++) {
				char c = St[i].charAt(j);
				
				switch (c) {
				case '#': {tmpg.add('#'); tmpt.add(false); break;}
				case ' ': {tmpg.add(' '); tmpt.add(false); break;}
				case '.': {tmpg.add('.'); tmpt.add(true); break;}
				case '@': {tmpg.add('@'); tmpt.add(false); playerX = j; playerY = i; break;}
				case '+': {tmpg.add('+'); tmpt.add(true); playerX = j; playerY = i; break;}
				case '$': {tmpg.add('$'); tmpt.add(false); break;}
				case '*': {tmpg.add('*'); tmpt.add(false); break;}
				}
			}
			grid.add(tmpg);
			targets.add(tmpt);
		}
	}
	
	public void setCell(char c, int x, int y) {
		grid.get(y).set(x, c);
	} 
	
	public Character getCell(int x, int y) {
		return grid.get(y).get(x);
	}
	
	public boolean isTarget(int x, int y) {
		if (targets.get(y).get(x)) {
			return true;
		} else {
		return false;
		}
	}
	
	public String toString() {
		String temp = "";
		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				temp = temp + getCell(j, i).toString();
			}
			temp = temp + "\n";
		}
		return temp;
	}
}
