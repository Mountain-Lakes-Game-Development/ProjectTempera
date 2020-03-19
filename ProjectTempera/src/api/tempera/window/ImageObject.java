package api.tempera.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import api.tempera.math.Vector;

public class ImageObject implements RenderedObject {
	
	private Vector position;
	private BufferedImage image;
	
	public ImageObject(BufferedImage image) {
		this.image = image;
		position = new Vector(0, 0);
	}

	/**
	 * Gets this object's position. Modifying the returned
	 * vector will modify this object's information.
	 * @return a vector representing this object's position.
	 */
	public Vector getPosition() {
		return position;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(
				image,
				(int) position.getX(),
				(int) position.getY(),
				null);
	}
}
