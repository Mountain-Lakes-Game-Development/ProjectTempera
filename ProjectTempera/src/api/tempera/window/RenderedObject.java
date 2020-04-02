package api.tempera.window;

import java.awt.Graphics2D;

import api.tempera.math.Vector;

public interface RenderedObject {
	public void draw(Graphics2D g2d, Vector center);
}
