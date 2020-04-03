package api.tempera.window.render;

import java.awt.Graphics2D;
import java.awt.Image;

import api.tempera.math.Vector;

public class Frame {
	
	private final Image image;
	private final Vector offset;
	private final double halfWidth;
	private final double halfHeight;
	
	/**
	 * Initializes a frame of an animation
	 * @param image the image of the frame
	 */
	public Frame(Image image) {
		this(image, 0, 0);
	}
	
	/**
	 * Initializes a frame of an animation
	 * @param image the image of the frame
	 * @param xOffset how much to offset the x coordinate by
	 * @param yOffset how much to offset the y coordinate by
	 */
	public Frame(Image image, double xOffset, double yOffset) {
		this.image = image;
		
		offset = new Vector(xOffset, yOffset);
		
		halfWidth = image.getWidth(null) / 2;
		halfHeight = image.getHeight(null) / 2;
	}
	
	/**
	 * Draws the image onto the graphic object
	 * with its center at the vector
	 * @param g2d the graphics to draw the image on
	 * @param center the center of the image relative to the screen
	 */
	public void draw(Graphics2D g2d, Vector center) {
		g2d.drawImage(
				image,
				(int) (center.getX() + offset.getX() - halfWidth),
				(int) (center.getY() - offset.getY() - halfHeight),
				null);
	}
}
