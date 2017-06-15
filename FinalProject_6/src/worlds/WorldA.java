package worlds;

import java.awt.Graphics2D;

import Run.FrameHandler;
import cretures.NPC3;
import cretures.Player;
import teleport.ATelePort;

public class WorldA extends World {
	
	private Player player;
	private NPC3 npc3;
	private ATelePort ATele;
	public WorldA(FrameHandler fm, String path) {
		super(fm, path);
		loadWorld(path);
		player = new Player( 1 * fm.getWidth() / width + 1, 7 * fm.getHeight() / height + 1, 32, 36, fm);
		npc3 = new NPC3( 0,0,32,36, fm,player);
		ATele = new ATelePort(0,0,64,72, fm, player);
	}
	

	@Override
	public void tick() {
		
		npc3.setX((int) 6 * fm.getWidth() / width + 1);
		npc3.setY((int) 3 * fm.getHeight() / height + 1);
		ATele.setX((int) 4 * fm.getWidth() / width + 1);
		ATele.setY((int) 0 * fm.getWidth() / width + 1);
		ATele.tick();
		npc3.tick();
		player.tick();
	}

	@Override
	public void render(Graphics2D g) {
		drawMap(g);
		ATele.Render(g);
		player.Render(g);
		npc3.Render(g);
	}

}
