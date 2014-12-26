package sokoban1;

import java.util.ArrayList;


public class Board {

	private ArrayList<ArrayList<Character>> grid;
	private int sizeY, sizeX;
	private String map;
	
	public Board (String map) {
		this.map = map;
		grid = new ArrayList<ArrayList<Character>>();
		sizeY = this.countY();
		
		
		while (int i < sizeY) {
			
		}
	}
	
	private int countY() {
		int count = 0;
		
		for (int i = 0; i < this.map.length(); i++) {
			if (this.map.charAt(i) == '|') {
				count++;
			}
		}
		return count+1;
	}
}
