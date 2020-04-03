package test.tempera.window;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import api.tempera.math.Vector;
import api.tempera.window.TemperaPanel;
import api.tempera.window.TemperaWindow;
import api.tempera.window.render.TemperaAnimation;
import api.tempera.window.render.TemperaAnimationBuilder;

public class WindowTest {
	public static void main(String... args) throws InterruptedException, IOException {
		TemperaWindow window = new TemperaWindow(1000, 500);
		TemperaPanel panel = window.getPanel();
		
		BufferedImage plus = ImageIO.read(new File("src/resources/plus.jpg"));
		BufferedImage sans = ImageIO.read(new File("src/resources/sans.jpg"));
		
		TemperaAnimationBuilder builder = new TemperaAnimationBuilder();
		builder.addFrame(plus);
		builder.addFrame(sans);
		
		TemperaAnimation animation = builder.getAnimation();
		
		Vector pos = animation.getPosition();
		pos.setX(0).setY(0);
		
		panel.addObject(animation);
		
		Vector mouse = window.getMouse();
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					pos.setX(mouse.getX()).setY(mouse.getY());
					System.out.println(pos);
					
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
