package api.tempera.window.render;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class AnimationBuilder {
	
	private List<Frame> frames;
	
	public AnimationBuilder() {
		frames = new ArrayList<Frame>();
	}
	
	public void addFrame(Image image) {
		frames.add(new Frame(image));
	}
	
	public void addFrame(Image image, int frameLength) {
		Frame frame = new Frame(image);
		for(int x = 0; x < frameLength; x++) {
			frames.add(frame);
		}
	}
	
	public void addFrame(Image image, double xOffset, double yOffset) {
		frames.add(new Frame(image, xOffset, yOffset));
	}
	
	public void addFrame(Image image, double xOffset, double yOffset, int frameLength) {
		Frame frame = new Frame(image, xOffset, yOffset);
		for(int x = 0; x < frameLength; x++) {
			frames.add(frame);
		}
	}
	
	public Animation getAnimation() {
		return new Animation(
				frames.toArray(new Frame[frames.size()]));
	}
}
