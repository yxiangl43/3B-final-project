package worlds;

import java.awt.Graphics2D;

import Run.FrameHandler;

public class WorldX extends World{

	public WorldX(FrameHandler fm, String path) {
		super(fm, path);
		loadWorld(path);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		drawMap(g);
	}

}
