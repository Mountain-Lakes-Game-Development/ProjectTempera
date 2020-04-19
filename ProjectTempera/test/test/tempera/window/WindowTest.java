package test.tempera.window;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import api.tempera.math.Vector;
import api.tempera.window.TemperaPanel;
import api.tempera.window.TemperaWindow;
import api.tempera.window.render.Animation;
import api.tempera.window.render.AnimationBuilder;

public class WindowTest {
	public static void main(String... args) throws InterruptedException, IOException {
		TemperaWindow window = new TemperaWindow(1000, 500);
		TemperaPanel panel = window.getPanel();
		
		Image sans = ImageIO.read(new File("src/resources/sans.jpg")).getScaledInstance(100, 100, 2);
		
		AnimationBuilder builder = new AnimationBuilder();
		Vector offset = new Vector(30, 0);
		
		for(int x = 0; x < 30; x++) {
			System.out.println(offset);
			
			builder.addFrame(sans, offset.getX(), offset.getY());
			offset.angle(offset.angle() + Math.PI / 15);
		}
		
		Animation animation = builder.getAnimation();
		
		Vector pos = animation.getPosition();
		pos.setX(0).setY(0);
		
		panel.addObject(animation);
		
		Vector mouse = window.getMouse();
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					pos.setX(mouse.getX()).setY(mouse.getY());
					
					try {
						sleep(10);
					} catch(Exception e) {
						
					}
				}
			}
		};
		
		thread.run();
	}
}
