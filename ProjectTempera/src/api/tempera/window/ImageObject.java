package api.tempera.window;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import api.tempera.math.Vector;

public class ImageObject implements RenderedObject {
	
	private Vector position;
	private Image image;
	
	private double halfHeight;
	private double halfWidth;
	
	public ImageObject(BufferedImage image) {
		this.image = image;
		position = new Vector(0, 0);
		
		halfHeight = image.getHeight() / 2;
		halfWidth = image.getWidth() / 2;
	}
	
	public ImageObject(BufferedImage image, int width, int height) {
		this.image = image.getScaledInstance(width, height, 0);
		position = new Vector(0, 0);
		
		halfHeight = height / 2;
		halfWidth = width / 2;
	}

	/**
	 * Gets this object's position (center). Modifying the
	 * returned vector will modify this object's information.
	 * @return a vector representing this object's position.
	 */
	public Vector getPosition() {
		return position;
	}
	
	@Override
	public void draw(Graphics2D g2d, Vector center) {
		
		int x = (int) (center.getX() + (position.getX() - halfWidth));
		int y = (int) (center.getY() - (position.getY() + halfHeight));
		
		g2d.drawImage(
				image,
				x,
				y,
				null);
	}
}
