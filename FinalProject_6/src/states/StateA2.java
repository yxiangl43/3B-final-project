package states;

import java.awt.Graphics2D;

import Run.FrameHandler;
import worlds.WorldA2;

public class StateA2 extends State{
	private WorldA2 w2;
	public StateA2(FrameHandler handler, String path) {
		super(handler, path);
		w2 = new WorldA2(handler,path);
	}

	@Override
	public void tick() {
		w2.tick();
	}

	@Override
	public void render(Graphics2D g) {
		w2.render(g);
	}

}
