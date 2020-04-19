package api.tempera.physic;

import java.util.ArrayList;
import java.util.List;

import api.tempera.math.Vector;

public class Area {
	
	private List<Body> bodies;
	private Vector gravity;
	
	/**
	 * Initializes a new area with physics similar
	 * to those of Earth.
	 */
	public Area() {
		bodies = new ArrayList<Body>();
		gravity = new Vector(0, -9.8);
	}
	
	private void tickGravity() {
		for(Body body : bodies) {
			body.getVelocity().add(gravity);
		}
	}
	
	public List<Body> getBodies() {
		return bodies;
	}
}
