package oving8;

import java.awt.Color;

public class Asteroid extends SpaceObject {
	
	public Asteroid(double density, double radius, int corners) {
		
		this.setMass(((4*Math.PI*Math.pow(radius, 3))/3)*density);
		for (int i = 0; i < corners; i ++){
			this.addPolarEdge(radius*10.0, 360.0/(double)corners*i);
		}
		this.setFilled(true);
		this.setColor(Color.GREEN);
		this.recenter();
	}
	
	
	
}
