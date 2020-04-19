package api.tempera.math;

public class Rectangle {
	protected double x1;
	protected double x2;
	
	protected double y1;
	protected double y2;
	
	/**
	 * Creates a rectangle from four doubles representing its edges. There is no check for whether the sides are valid.
	 * @param x1 the left edge of this rectangle
	 * @param x2 the right edge of this rectangle
	 * @param y1 the bottom edge of this rectangle
	 * @param y2 the top edge of this rectangle
	 */
	public Rectangle(double x1, double x2, double y1, double y2) {
		if(x1 > x2 || y1 > y2)
			throw new RuntimeException("There was an error with creating a rectangle: sides are overlapping");
		
		this.x1 = x1;
		this.x2 = x2;
		
		this.y1 = y1;
		this.y2 = y2;
	}
	
	/**
	 * Creates a rectangle from two points. They can not be adjacent corners.
	 * @param vec1 a corner of this rectangle
	 * @param vec2 a corner of this rectangle
	 */
	public Rectangle(Vector vec1, Vector vec2) {
		if(vec1.x < vec2.x) {
			x1 = vec1.x;
			x2 = vec2.x;
		} else {
			x1 = vec2.x;
			x2 = vec1.x;
		}
		
		if(vec1.y < vec2.y) {
			y1 = vec1.y;
			y2 = vec2.y;
		} else {
			y1 = vec2.y;
			y2 = vec1.y;
		}
	}
	
	/**
	 * Gets the width of this rectangle
	 * @return the width of this rectangle
	 */
	public double getWidth() {
		return Math.abs(x1 - x2);
	}
	
	/**
	 * Gets the height of this rectangle
	 * @return the height of this rectangle
	 */
	public double getHeight() {
		return Math.abs(y1 - y2);
	}
	
	/**
	 * Gets the rectangle's 4 vertices, starting from the
	 * bottom left going around clockwise.
	 * @return an array containing the rectangle's 4 vertices
	 */
	public Vector[] getVertices() {
		return new Vector[] {
				new Vector(x1, y1),
				new Vector(x1, y2),
				new Vector(x2, y2),
				new Vector(x2, y1)
		};
	}
	
	/**
	 * Gets the rectangle's 4 edges, starting from the
	 * left and going around clockwise,
	 * @return
	 */
	public Segment[] getEdges() {
		Vector[] vertices = getVertices();
		
		return new Segment[] {
				new Segment(vertices[0], vertices[1]),
				new Segment(vertices[1], vertices[2]),
				new Segment(vertices[2], vertices[3]),
				new Segment(vertices[3], vertices[0])
		};
	}
	
	/**
	 * Checks if this rectangle intersects with another
	 * @param rect the rectangle to compare this one to
	 * @return if this rectangle and rect intersect
	 */
	public boolean intersectsWith(Rectangle rect) {
		if(x1 > rect.x2 || x2 < rect.x1) return false; //they are on the left or right of each other
		if(y1 > rect.y2 || y2 < rect.y2) return false; //they are above or below each other
		
		return true;
	}
}
