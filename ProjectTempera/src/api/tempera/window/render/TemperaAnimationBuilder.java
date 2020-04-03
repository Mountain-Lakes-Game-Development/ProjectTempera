package api.tempera.window.render;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class TemperaAnimationBuilder {
	
	private List<Frame> frames;
	
	public TemperaAnimationBuilder() {
		frames = new ArrayList<Frame>();
	}
	
	public void addFrame(Image image) {
		frames.add(new Frame(image));
	}
	
	public TemperaAnimation getAnimation() {
		return new TemperaAnimation(
				frames.toArray(new Frame[frames.size()]));
	}
}
