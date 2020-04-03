package api.tempera.window.render;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import api.tempera.math.Vector;

public class ImageObject implements RenderedObject {
	
	private Vector position;
	private Frame frame;
	
	public ImageObject(BufferedImage image) {
		frame = new Frame(image);
		position = new Vector(0, 0);
	}
	
	public ImageObject(BufferedImage image, int width, int height) {
		frame = new Frame(image.getScaledInstance(width, height, 0));
		position = new Vector(0, 0);
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
		frame.draw(
				g2d,
				center.clone()
					.addX(position.getX())
					.addY(-position.getY()));
	}
}
