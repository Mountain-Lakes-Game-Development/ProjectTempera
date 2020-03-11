package api.tempera.math;

public class Segment {
	
	protected Vector pointA;
	protected Vector pointB;
	
	/**
	 * Creates a line segment from two points
	 * @param pointA a vector representing a point
	 * @param pointB a vector representing a point
	 */
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
