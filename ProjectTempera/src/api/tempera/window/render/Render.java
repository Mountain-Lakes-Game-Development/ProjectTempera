package api.tempera.window.render;

import java.awt.Graphics2D;

import api.tempera.math.Vector;

public interface Render {
	/**
	 * Draws this object onto a graphics object. The center
	 * is the graphics object's center (the center of the panel
	 * if it is from one). 
	 * @param g2d the graphics object to draw on
	 * @param center the center of the graphics object's window
	 */
	public void draw(Graphics2D g2d, Vector center);
}
