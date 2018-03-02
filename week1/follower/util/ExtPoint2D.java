package follower.util;

import com.sun.javafx.geom.Vec2d;


public class ExtPoint2D extends Vec2d {
	public ExtPoint2D(double x, double y) {
		super(x,y);
	}
	
	public ExtPoint2D(ExtPoint2D value) {
		super (value.x, value.y);
	}
	
	
	public double angle(ExtPoint2D other) {
		double deltaX = other.getX()-this.getX();
		double deltaY = other.getY()-this.getY();
		
		double angle = Math.atan(deltaX/deltaY);
		return angle;
	}
	
	public double getX() { return this.x; }
	public void setX(double val) { this.x = val; }	
	public double getY() { return this.y; }
	public void setY(double val) { this.y = val; }

	
	public void add(ExtPoint2D other) {
		this.x += other.getX();
		this.y += other.getY();
	}
	
	public void substract(ExtPoint2D other) {
		this.x -= other.getX();
		this.y -= other.getY();
	}
	
	public void avarage (int number) {
		this.x = this.x/number;
		this.y = this.y/number;
	}
	
	public double size() {
		return Math.sqrt(getX()*getX() + getY()*getY());
	}
	
	@Override
	public String toString() {
		return "x: " +this.getX()+ "; y: " +this.getY();
	}
}
