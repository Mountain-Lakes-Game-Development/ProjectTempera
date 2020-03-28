package api.tempera.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import api.tempera.math.Vector;

public class TemperaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private List<RenderedObject> objects;
	
	public TemperaPanel() {
		objects = new ArrayList<>();
	}
	
	public void addObject(RenderedObject object) {
		objects.add(object);
	}
	
	public void addObjects(RenderedObject... objects) {
		for(RenderedObject object : objects) {
			addObject(object);
		}
	}
	
	public void removeObject(RenderedObject object) {
		objects.remove(object);
	}
	
	public void removeObjects(RenderedObject... objects) {
		for(RenderedObject object : objects) {
			removeObject(object);
		}
	}
	
	public Vector getCenter() {
		return new Vector(this.getWidth(), this.getHeight()).divide(2);
	}
	
	@Override
	public void paint(Graphics g) {
		Vector center = getCenter();
		AffineTransform transformation = new AffineTransform();
		transformation.scale(1, -1);
		transformation.translate(center.getX(), -center.getY());
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setTransform(transformation);
		for(RenderedObject object : objects) {
			object.draw(g2d);
		}
		
		g2d.draw(new Ellipse2D.Double(-5, -5, 10, 10));
	}
}
