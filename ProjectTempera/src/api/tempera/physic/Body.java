package api.tempera.physic;

import api.tempera.math.Rectangle;
import api.tempera.math.Vector;

public class Body {
	
	private Rectangle hitbox;
	
	private Vector position;
	private Vector velocity;
	
	private double weight;
	
	public Body(Rectangle hitbox, double weight) {
		this.hitbox = hitbox;
		this.weight = weight;
		
		position = new Vector();
		velocity = new Vector();
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public Vector getPosition() {
		return position;
	}
	
	public Vector getVelocity() {
		return velocity;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
}
