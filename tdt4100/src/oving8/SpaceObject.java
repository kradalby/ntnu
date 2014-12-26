package oving8;

import acm.graphics.GPolygon;

public class SpaceObject extends GPolygon{
        
    private double speedX;
    private double speedY;
    protected double mass;
	private double gConst = 6 * Math.pow(10, -10);

    
    public SpaceObject() {
        this.speedX = 0.0;
        this.speedY = 0.0;
    }   
        
    public double getSpeedX() {
        return this.speedX;
    }   
        
    public double getSpeedY() {
        return this.speedY;
    }   
        
    public void setSpeed(double dx, double dy) {
        this.speedX = dx; 
        this.speedY = dy; 
    }   
        
    public void accelerate(double ax, double ay) {
        this.speedX += ax; 
        this.speedY += ay; 
    }   
        
    public double getMass() {
        return this.mass;
    }   
    
    public void setMass(double mass) {
    	this.mass = mass;
    }
        
    public void applyGravitationalForce(SpaceObject pullingObject) {
    	double m1 = this.getMass();
    	double m2 = pullingObject.getMass();
    	double rx = (this.getLocation().getX() - pullingObject.getLocation().getX());
    	double ry = (this.getLocation().getY() - pullingObject.getLocation().getY());
    	double radius = Math.sqrt(Math.abs(Math.pow(rx, 2) + Math.pow(ry, 2)));
    	double force = gConst * ((m1 * m2) / Math.pow(radius,  2));
    	
    	if (m1 != 0 && m2 != 0) {
        	double vectorX = pullingObject.getX() - this.getX();
        	double vectorY = pullingObject.getY() - this.getY();
        	vectorX *= force;
        	vectorY *= force;		
        	
        	this.accelerate(vectorX/this.getMass(), vectorY/this.getMass());
    	}
    	


    }
        
    public boolean intersects(SpaceObject meh) {
        return this.getBounds().intersects(meh.getBounds());
    }   
        
    public void tick() {
            move(speedX,speedY);
    }   
}
