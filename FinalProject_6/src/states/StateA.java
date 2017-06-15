package states;

import java.awt.Graphics2D;

import Run.FrameHandler;
import worlds.WorldA;

public class StateA extends State{
	private WorldA worldA;
	
	public StateA(FrameHandler handler, String path) {
		super(handler, path);
		this.worldA = new WorldA(handler, path);
	}

	@Override
	public void tick() {
		worldA.tick();
	}

	@Override
	public void render(Graphics2D g) {
		worldA.render(g);
	}

}
