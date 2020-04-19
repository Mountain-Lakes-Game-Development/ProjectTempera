package test.tempera.window;

import java.awt.Graphics2D;
import java.util.List;

import api.tempera.math.Rectangle;
import api.tempera.math.Vector;
import api.tempera.physic.Area;
import api.tempera.physic.Body;
import api.tempera.window.TemperaPanel;
import api.tempera.window.TemperaWindow;
import api.tempera.window.render.Render;

public class PhysicsTest {
	public static void main(String... args) {
		TemperaWindow window = new TemperaWindow(1080, 720);
		TemperaPanel panel = window.getPanel();
		
		Area area = new Area();
		
		List<Body> bodies = area.getBodies();
		
		bodies.add(new Body(new Rectangle(-50, 50, -50, 50), 0));
		
		Render debugRender = new Render() {
			@Override
			public void draw(Graphics2D g2d, Vector center) {
				Rectangle bRect;
				Vector bCenter;
				for(Body body : area.getBodies()) {
					bRect = body.getHitbox();
					bCenter = body.getPosition();
					
					g2d.drawRect(
							(int) (bCenter.getX() + center.getX()),
							(int) (bCenter.getY() + center.getY()),
							(int) bRect.getWidth(), (int) bRect.getHeight());
				}
			}
		};
	}
}
