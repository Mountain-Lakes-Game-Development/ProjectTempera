package api.tempera.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import api.tempera.math.Vector;

public class TemperaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private List<RenderedObject> objects;
	private Vector mouse;
	
	public TemperaPanel() {
		objects = new ArrayList<>();
		
		mouse = new Vector(0, 0);
		
		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) { }

			@Override
			public void mouseMoved(MouseEvent e) {
				mouse.setX(e.getX() - getWidth() / 2).setY(getHeight() / 2 - e.getY());
			}
		});
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
	
	public Vector getMouse() {
		return mouse;
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		for(RenderedObject object : objects) {
			object.draw(g2d, getCenter());
		}
		
		Vector center = getCenter();
		g2d.setColor(Color.GREEN);
		g2d.draw(new Ellipse2D.Double(center.getX()-5, center.getY() - 5, 10, 10));
	}
}
