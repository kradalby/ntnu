package oving9;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class HighscoreView extends GraphicsProgram implements ListListener {

	private HighscoreList hs = new HighscoreList(10);
	private GLabel tittel;
	private boolean running = true;
	private String navn;
	private int score;

	public void init() {
		setSize(200,300);
		setBackground(Color.BLACK);
		tittel = new GLabel("Highscores",5,15);
		tittel.setFont(new Font("Arial", 8, 16));
		tittel.setColor(Color.GREEN);
		add(tittel);
		hs.addListListener(this);
	}



	public void run() {
		while (this.running) {
			this.takeInput();
			if (navn.equals("exit")) { exit(); destroy(); this.running = false; }
			else {
				hs.addResult(new SokobanResult(navn, score));
			}
		}
		exit();
		destroy();
	}


	private void drawList() {
		removeAll();
		add(tittel);
		List active = hs.getList();
		int step = 2;
		for (Object element: active) {
			GLabel linje = new GLabel(element.toString(),5,step*20);
			linje.setColor(Color.GREEN);
			add(linje);
			step++;
		}
	}

	public void listChanged(ObservableList li, int low, int high) {
		drawList();
	}

	private void takeInput() {
        try {
        	score = readInt("Enter score: ");
        	navn = readLine("Enter name: ");
		} catch (Exception NumberFormatException) {
			System.out.println("Illegal score format!");
			this.takeInput();
		}
    }
}
