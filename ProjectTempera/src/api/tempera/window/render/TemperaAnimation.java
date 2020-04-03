package api.tempera.window.render;

import java.awt.Graphics2D;

import api.tempera.math.Vector;

public class TemperaAnimation implements RenderedObject {
	private final Frame[] frames;
	private int frameIndex; //the frame that is currently being animated
	private Vector position;
	
	/**
	 * Initializes an animation from a list of frames
	 * @param frames the frames that comprise of this animation
	 */
	public TemperaAnimation(Frame... frames) {
		this.frames = frames;
		frameIndex = 0;
		position = new Vector(0, 0);
	}
	
	public Vector getPosition() {
		return position;
	}

	@Override
	public void draw(Graphics2D g2d, Vector center) {
		frames[frameIndex].draw(
				g2d,
				center.clone()
					.addX(position.getX())
					.addY(-position.getY()));
		frameIndex++;
		if(frameIndex >= frames.length)
			frameIndex = 0;
	}
}
