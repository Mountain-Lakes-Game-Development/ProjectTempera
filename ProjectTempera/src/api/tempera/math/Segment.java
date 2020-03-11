package api.tempera.math;

public class Segment {
	
	protected Vector pointA;
	protected Vector pointB;
	
	public Segment(Vector pointA, Vector pointB) {
		this.pointA = pointA;
		this.pointB = pointB;
	}
	
	/**
	 * Returns the length of this line segment
	 * @return the length of this line segment
	 */
	public double getLength() {
		return pointA.distanceFrom(pointB);
	}
	
	/**
	 * Returns an endpoint of this segment
	 * @return a vector representing an endpoint
	 */
	public Vector getPointA() {
		return pointA;
	}
	
	/**
	 * Returns an endpoint of this segment
	 * @return a vector representing an endpoint
	 */
	public Vector getPointB() {
		return pointB;
	}
}
