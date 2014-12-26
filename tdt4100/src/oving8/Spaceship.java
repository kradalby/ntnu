package oving8;

import java.awt.Color;

public class Spaceship extends SpaceObject {
	
	int direction;
	
	public Spaceship(){
		this.setMass(80.0);
		this.addVertex(0, 0);
		this.addVertex(20, 20);
		this.addVertex(-10, 10);
		this.setFilled(true);
		this.setFillColor(Color.RED);
		
	}
	
	public void setDirection(int g) {
		this.direction = g;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public void incrementDirection(int g) {
		this.direction += g;
		if (this.direction >= 360) { this.direction -= 360; }
		if (this.direction < 0) { this.direction += 360; }
		this.rotate((double)g);

		
	}
	
	public void thrust(){
		double acc = 0.6;
		double dirX = Math.cos(Math.toRadians((double)this.getDirection()));
		double dirY = Math.sin(Math.toRadians((double)this.getDirection()));
		this.accelerate(dirX*acc, dirY*acc*-1);
	}
	
}