package api.tempera.window;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

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
	
	@Override
	public void paint(Graphics g) {
		for(RenderedObject object : objects) {
			object.draw(g);
		}
	}
}
