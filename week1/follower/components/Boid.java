package follower.components;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import com.sun.javafx.geom.Vec2d;

import follower.util.ExtPoint2D;
import follower.util.Settings;


public class Boid {
	private ExtPoint2D position;
	private Polygon triangle;
	private double theta;
	private ExtPoint2D heading;
	private int boidnumber;
	
	// TODO
	// Replace the public default constructor with calls to the builder class below
	
	public Boid() {
		triangle = new Polygon();
		triangle.setFill(Color.RED);
		triangle.getPoints().addAll(new Double[]{
			0.0, 0.0,
			20.0, 0.0,
			10.0,  40.0
		});
		position = new ExtPoint2D (0.0, 0.0);
	}
	
	private Boid (BoidBuilder builder) {
		setPosition(builder.position);
		setHeading(builder.heading);
	}
	
	public void update(Vec2d target) {
		double deltaX = target.x-position.x;
		double deltaY = target.y-position.y;
		
		double speed = Math.sqrt(deltaX*deltaX + deltaY*deltaY)/Settings.SPEED_FACTOR;
		double angle = Math.atan2(deltaX, deltaY);
		
		double newX = position.x + speed*Math.sin(angle);
		double newY = position.y + speed*Math.cos(angle);
		ExtPoint2D newpos = new ExtPoint2D(newX, newY);
		
		this.setPosition(newpos);
		this.setRotation(angle);
	}
	
	public boolean checkVisibility(Boid other) {
		return getDistance(other) < Settings.MAX_DISTANCE;
	}
	
	public boolean checkVicinity(Boid other) {
		return getDistance(other) > Settings.MIN_DISTANCE;
	}
	
	public ExtPoint2D setNewTarget(ExtPoint2D target) {
		double deltaX = target.x - this.getPosition().getX();
		double deltaY = target.y - this.getPosition().getY();
		
		double speed = Math.sqrt(deltaX*deltaX + deltaY*deltaY)/3;
		double angle = Math.atan2(deltaX, deltaY);
		
		double newX = this.getPosition().getX() + speed*Math.sin(angle);
		double newY = this.getPosition().getY() + speed*Math.cos(angle);
		
		return new ExtPoint2D (newX, newY);		
	}
	
	public double setNewAngle(ExtPoint2D target) {
		double deltaX = target.x - this.getPosition().getX();
		double deltaY = target.y - this.getPosition().getY();
		
		return Math.atan2(deltaX, deltaY);
	}
	
	public void flyToTarget(ExtPoint2D target) {
		double deltaX = target.x - this.getPosition().getX();
		double deltaY = target.y - this.getPosition().getY();
		
		double speed = Math.sqrt(deltaX*deltaX + deltaY*deltaY)/3;
		double angle = Math.atan2(deltaX, deltaY);
		
		double newX = this.getPosition().getX() + speed*Math.sin(angle);
		double newY = this.getPosition().getY() + speed*Math.cos(angle);
		ExtPoint2D newpos = new ExtPoint2D (newX, newY);
		
		setPosition(newpos);
		setRotation(angle);
	}
	
	public Node getContent() {
		return triangle;
	}
	
	public void setPosition (ExtPoint2D newPos) {
		triangle.setLayoutX(newPos.getX());
		triangle.setLayoutY(newPos.getY());
		
		position = newPos;
	}

	public ExtPoint2D getPosition() {
		return position;
	}
	
	public int getBoidNumber() { 
		return this.boidnumber; 
	}
	
	public void setBoidNumber(int n) {
		this.boidnumber = n; 
	}
	
	public void setHeading(ExtPoint2D newHeading) {
		heading = newHeading;
		
		double deltaX = newHeading.getX() - this.getPosition().getX();
		double deltaY = newHeading.getY() - this.getPosition().getY();
		
		double angle = Math.atan2(deltaX, deltaY);
		
		theta = (-180*angle) / Math.PI;
		triangle.setRotate(theta);
	}
	
	public void setRotation(double newTheta) {
		theta = (-180*newTheta) / Math.PI;
		triangle.setRotate(theta);
	}
	
	public ExtPoint2D getHeading() {
		return heading;
	}
	
	private double getDistance(Boid other) {
		return position.distance(other.getPosition());
	}
	
	// Builder class
	public class BoidBuilder {
		private ExtPoint2D position;
		private ExtPoint2D heading;
		
		public BoidBuilder position (ExtPoint2D pos) { this.position=pos; return this; }
		public BoidBuilder heading (ExtPoint2D head) { this.heading=head; return this; }
		public Boid build() { return new Boid(this); }
		
		
	}

}
