package test.tempera.window;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import api.tempera.math.Vector;
import api.tempera.window.ImageObject;
import api.tempera.window.TemperaPanel;
import api.tempera.window.TemperaWindow;

public class WindowTest {
	public static void main(String... args) throws InterruptedException, IOException {
		TemperaWindow window = new TemperaWindow(1000, 500);
		TemperaPanel panel = window.getPanel();
		
		ImageObject image = new ImageObject(ImageIO.read(new File("src/resources/flamingo.jpg")));
		Vector pos = image.getPosition();
		
		panel.addObject(image);
		
	}
}
