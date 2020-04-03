package test.tempera.window;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import api.tempera.math.Vector;
import api.tempera.window.TemperaPanel;
import api.tempera.window.TemperaWindow;
import api.tempera.window.render.ImageObject;

public class WindowTest {
	public static void main(String... args) throws InterruptedException, IOException {
		TemperaWindow window = new TemperaWindow(1000, 500);
		TemperaPanel panel = window.getPanel();
		
		BufferedImage plus = ImageIO.read(new File("src/resources/plus.jpg"));
		
		ImageObject image = new ImageObject(plus, 100, 100);
		Vector pos = image.getPosition();
		pos.setX(0).setY(0);
		
		panel.addObject(image);
		
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
