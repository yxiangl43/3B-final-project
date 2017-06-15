package worlds;

import java.awt.Graphics2D;

import Run.FrameHandler;
import Run.ReadString;
import cretures.NPC1;
import cretures.NPC2;
import cretures.Player;
import teleport.JTeleport;

public class WorldJ extends World {

	// player
	private Player player;


	
	// npc
	private NPC1 npc1;
	private NPC2 npc2; 
	
	//Teleport
	private JTeleport p1;
	private JTeleport p2;
	
	public WorldJ(FrameHandler fm, String path) {
		super(fm, path);
		loadWorld(path);
		player = new Player( 2 * fm.getWidth() / width + 1, 6 * fm.getHeight() / height + 1, 32, 36, fm);
		npc1 = new NPC1(0, 0, 32, 36, fm, player);
		npc2 = new NPC2(0, 0, 32, 36, fm, player);
		p1 = new JTeleport(0 ,0,64,72,fm,player);
		p2 = new JTeleport(0 ,0,64,72,fm,player);
	}

	@Override
	public void tick() {

		player.tick();
		npc1.setX((int) 1 * fm.getWidth() / width + 1);
		npc1.setY((int) 1 * fm.getHeight() / height + 1);
		npc2.setX((int) 8 * fm.getWidth() / width + 1);
		npc2.setY((int) 1 * fm.getHeight() / height + 1);
		p1.setX((int) 4 * fm.getWidth() / width + 1);
		p1.setY((int) 0 * fm.getHeight() / height + 1);
		p2.setX((int) 5 * fm.getWidth() / width + 1);
		p2.setY((int) 0 * fm.getHeight() / height + 1);
		
		p1.tick();
		p2.tick();
		
		npc1.tick();
		npc2.tick();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		drawMap(g);
		p1.Render(g);
		p2.Render(g);
		npc1.Render(g);
		npc2.Render(g);
		player.Render(g);
	}
}
