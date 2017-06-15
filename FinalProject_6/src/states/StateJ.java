package states;

import java.awt.Graphics2D;

import Run.FrameHandler;
import cretures.NPC1;
import cretures.Player;
import textures.Animation;
import worlds.WorldJ;

public class StateJ extends State{
	// map
	private WorldJ worldJ;

	public StateJ(FrameHandler handler,String path) {
		super(handler, path);
		worldJ = new WorldJ(handler, path);
	}

	@Override
	public void tick() {
		worldJ.tick();
	

	}

	@Override
	public void render(Graphics2D g) {
		worldJ.render(g);
	}


}
