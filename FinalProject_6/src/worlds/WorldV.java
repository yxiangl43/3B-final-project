package worlds;

import java.awt.Graphics2D;

import Run.FrameHandler;
import cretures.NPC4;
import cretures.Player;
import teleport.JTeleport;
import teleport.VTelePort;

public class WorldV extends World {
	private Player player;
	private NPC4 npc4;
	private VTelePort p1;
	private VTelePort p2;
	public WorldV(FrameHandler fm, String path) {
		super(fm, path);
		// TODO Auto-generated constructor stub
		loadWorld(path);
		player = new Player(2 * fm.getWidth() / width + 1, 2 * fm.getHeight() / height + 1, 32, 36, fm);
		npc4 = new NPC4(0, 0, 32, 36, fm, player);
		p1 = new VTelePort(0 ,0,64,72,fm,player);
		p2 = new VTelePort(0 ,0,64,72,fm,player);
	}

	@Override
	public void tick() {
		player.tick();
		npc4.tick();
		npc4.setX(8 * fm.getWidth() / width + 1);
		npc4.setY(1* fm.getHeight() / height + 1);
		
		p1.setX((int) 4 * fm.getWidth() / width + 1);
		p1.setY((int) 8 * fm.getHeight() / height + 1);
		p2.setX((int) 5 * fm.getWidth() / width + 1);
		p2.setY((int) 8 * fm.getHeight() / height + 1);
		
		p1.tick();
		p2.tick();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		drawMap(g);
		p1.Render(g);
		p2.Render(g);
		player.Render(g);
		npc4.Render(g);
		
	}

}
