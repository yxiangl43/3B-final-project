package worlds;

import java.awt.Graphics2D;

import Run.FrameHandler;
import cretures.NPC5;
import cretures.Player;
import teleport.A2TelePort;
import teleport.ATelePort;

public class WorldA2 extends World{
	private Player player;
	private NPC5 npc5;
	private A2TelePort A2Tele;
	public WorldA2(FrameHandler fm, String path) {
		super(fm, path);
		loadWorld(path);
		
		
		player = new Player(0,0,32,36,fm);
		npc5 = new NPC5( 0, 0 ,32,36,fm,player);
		A2Tele = new A2TelePort(0,0,64,72, fm, player);
	}

	@Override
	public void tick() {
		
		player.tick();
		npc5.tick();
		npc5.setX((int) 8 * fm.getWidth() / width + 1);
		npc5.setY((int) 7 * fm.getHeight() / height + 1);
		A2Tele.setX((int) 4 * fm.getWidth() / width + 1);
		A2Tele.setY((int) 0 * fm.getWidth() / width + 1);
		A2Tele.tick();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		drawMap(g);
		
		A2Tele.Render(g);
		player.Render(g);
		npc5.Render(g);
	}

}
