package api.tempera.window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import api.tempera.math.Vector;

public class TemperaWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int frameRate = 30;
	
	private double halfWidth;
	private double halfHeight;
	
	private TemperaPanel contentPane;
	private Vector mouse;
	
	public TemperaWindow(int width, int height) {
		contentPane = new TemperaPanel();
		
		setSize(width, height);
		setContentPane(contentPane);
		setVisible(true);
		
		mouse = new Vector(0, 0);
		halfWidth = width / 2;
		halfHeight = height / 2;
		
		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) { }

			@Override
			public void mouseMoved(MouseEvent e) {
				mouse.setX(e.getX() - halfWidth).setY(halfHeight - e.getY());
			}
		});
		
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
		return mouse;
	}
}
