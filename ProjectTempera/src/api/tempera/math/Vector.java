package api.tempera.math;

public class Vector implements Cloneable {
	protected double x;
	protected double y;
	
	/**
	 * Creates a vector from two coordinates
	 * @param x the x coordinate of this vector
	 * @param y the y coordinate of this vector
	 */
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creates a unit vector from an angle
	 * @param angle the angle of this vector
	 */
	public Vector(double angle) {
		x = Math.cos(angle);
		y = Math.sin(angle);
	}
	
	/**
	 * Creates a vector with coordinates (0, 0)
	 */
	public Vector() {
		this(0, 0);
	}
	
	/**
	 * Creates a vector from two existing vectors.
	 * The created vector is pointing from A to B.
	 * @param A
	 * @param B
	 */
	public Vector(Vector A, Vector B) {
		this(B.x - A.x, B.y - A.y);
	}
	
	public String toString() {
		return String.format("(%f, %f)", x, y);
	}
	
	public Vector clone() {
		return new Vector(x, y);
	}
	
	/**
	 * Returns the x coordinate of this vector
	 * @return the x coordinate of this vector
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Sets the x coordinate of this vector
	 * @param x the x coordinate of this vector
	 * @return this vector
	 */
	public Vector setX(double x) {
		this.x = x;
		return this;
	}
	
	/**
	 * Adds a value to the x coordinate of this vector
	 * @param x the value to add
	 * @return this vector
	 */
	public Vector addX(double x) {
		this.x += x;
		return this;
	}
	
	/**
	 * Gets the y coordinate of this vector
	 * @return the y coordinate of this vector
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Sets the y coordinate of this vector
	 * @param y the y coordinate of this vector
	 * @return this vector
	 */
	public Vector setY(double y) {
		this.y = y;
		return this;
	}
	
	/**
	 * Adds a value to the y coordinate of this vector
	 * @param y the value to add
	 * @return this vector
	 */
	public Vector addY(double y) {
		this.y += y;
		return this;
	}
	
	/**
	 * Gets the magnitude of this vector
	 * @return the magnitude of this vector
	 */
	public double magnitude() {
		return Math.sqrt(x * x + y * y);
	}
	
	/**
	 * Sets the magnitude of this vector
	 * @param magnitude the magnitude of this vector
	 * @return this vector
	 */
	public Vector magnitude(double magnitude) {
		double angle = angle();
		
		x = Math.cos(angle) * magnitude;
		y = Math.sin(angle) * magnitude;
		
		return this;
	}
	
	/**
	 * Gets the angle of this vector
	 * @return the angle of this vector
	 */
	public double angle() {
		return Math.atan2(y, x);
	}
	
	/**
	 * Sets the angle of this vector
	 * @param angle the angle of this vector
	 * @return this vector
	 */
	public Vector angle(double angle) {
		double magnitude = magnitude();
		
		x = Math.cos(angle) * magnitude;
		y = Math.sin(angle) * magnitude;
		
		return this;
	}
	
	/**
	 * Multiplies this vector by a scalar
	 * @param scalar the value to multiply this vector by
	 * @return this vector
	 */
	public Vector multiply(double scalar) {
		x *= scalar;
		y *= scalar;
		
		return this;
	}
	
	/**
	 * Divides this vector by a scalar
	 * @param scalar the value to divide this vector by
	 * @return this vector
	 */
	public Vector divide(double scalar) {
		x /= scalar;
		y /= scalar;
		
		return this;
	}
	
	/**
	 * Gets the dot product of this vector and another
	 * @param vec the vector to get the dot product of
	 * @return the dot product of this vector and vec
	 */
	public double dot(Vector vec) {
		return vec.x * x + vec.y * y;
	}
	
	/**
	 * Gets the distance between this vector and another
	 * @param vector the vector to compare to this one
	 * @return the distance between this vector and another
	 */
	public double distanceFrom(Vector vector) {
		double x = vector.x - this.x;
		double y = vector.y - this.y;
		
		return x * x + y * y;
	}
	
}
