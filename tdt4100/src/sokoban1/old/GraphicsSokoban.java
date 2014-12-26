package sokoban1.old;

import java.awt.event.KeyEvent;

import sokoban1.SampleLevels;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class GraphicsSokoban extends GraphicsProgram {

	Sokoban sokoban;
	SampleLevels levels;
	int lvl = 1;
	GImage wall;
	GImage empty;
	GImage target;
	GImage player;
	GImage pot;
	GImage box;
	GImage bot;
	boolean fortsett = true;
	
	public void init() {
		setSize(640,480);
		levels = new SampleLevels();
		addKeyListeners();
		
	}
	
	
	public void run() {
		while (true) {
			selectLevel(lvl);
			paintGrid();
			fortsett = true;
			while (fortsett)
			if (sokoban.hasWon()) {
				lvl++;
				fortsett = false;
			}
			
		}
	}

	public void keyPressed(KeyEvent event) {
        int key;
        if (Character.isLetter(event.getKeyChar()))
            key = event.getKeyChar();
        else 
            key = event.getKeyCode();
       
        switch (key) {
        case KeyEvent.VK_UP: sokoban.doMove(0, -1); removeAll(); paintGrid(); break;
        case KeyEvent.VK_DOWN: sokoban.doMove(0, 1); removeAll(); paintGrid(); break;
        case KeyEvent.VK_LEFT: sokoban.doMove(-1, 0); removeAll(); paintGrid(); break;
        case KeyEvent.VK_RIGHT: sokoban.doMove(1, 0); removeAll(); paintGrid(); break;
        }
    }
	
	private void paintGrid() {
		int x = 0;
		int y = 16;
		String map = sokoban.board.toString();
		for (int k = 0; k < map.length(); k++) {
			x += 16;
			char c = map.charAt(k);
			switch (c) {
			case '#': {add(wall = new GImage("sokoban/wall16x16.png"),x,y); break;}
			case ' ': {add(empty = new GImage("sokoban/blank16x16.png"),x,y); break;}
			case '.': {add(target = new GImage("sokoban/target16x16.png"),x,y); break;}
			case '@': {add(player = new GImage("sokoban/mover16x16.png"),x,y); break;}
			case '+': {add(pot = new GImage("sokoban/mover_on_target16x16.png"),x,y); break;}
			case '$': {add(box = new GImage("sokoban/movable16x16.png"),x,y); break;}
			case '*': {add(bot = new GImage("sokoban/movable_on_target16x16.png"),x,y); break;}
			case '\n': {x = 0; y += 16; break;}
			}
			
		}
	}
	
	private void selectLevel(int lvl){
		switch (lvl) {
		case 1: {sokoban = new Sokoban(levels.level1); break;}
		case 2: {sokoban = new Sokoban(levels.level2); break;}
		case 3: {sokoban = new Sokoban(levels.level3); break;}
		case 4: {sokoban = new Sokoban(levels.level4); break;}
		default: {sokoban = new Sokoban(levels.level1); break;}
		}
	}
}
