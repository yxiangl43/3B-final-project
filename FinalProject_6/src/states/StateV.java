package states;

import java.awt.Graphics2D;

import Run.FrameHandler;
import worlds.World;
import worlds.WorldV;

public class StateV extends State{
	private WorldV worldV;
	
	public StateV(FrameHandler handler, String path) {
		super(handler, path);
		worldV = new WorldV(handler,path);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		worldV.tick();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		worldV.render(g);
	}

}
