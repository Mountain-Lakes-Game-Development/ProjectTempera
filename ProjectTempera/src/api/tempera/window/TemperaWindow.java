package api.tempera.window;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import api.tempera.math.Vector;

public class TemperaWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int frameRate = 30;
	
	private TemperaPanel contentPane;
	
	public TemperaWindow(int width, int height) {
		contentPane = new TemperaPanel();
		
		setSize(width, height);
		setContentPane(contentPane);
		
		setVisible(true);
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				contentPane.repaint();
			}
			
		}, 0, 1000 / frameRate);
	}
	
	public TemperaPanel getPanel() {
		return contentPane;
	}
	
	public Vector getCenter() {
		return new Vector(this.getWidth(), this.getHeight()).divide(2);
	}
	
	public Vector getMouse() {
		return contentPane.getMouse();
	}
}
