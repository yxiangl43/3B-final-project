package teleport;

import java.awt.Graphics2D;

import Run.FrameHandler;
import cretures.Creature;
import cretures.NPC;
import cretures.NPC1;
import cretures.NPC2;
import cretures.Player;
import states.State;
import states.StateA;
import states.StateJ;
import textures.Assets;

public class JTeleport extends NPC {


	public JTeleport(int x, int y, int width, int height, FrameHandler handler, Player player) {
		super(x, y, width, height, handler, player);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		setRectangle(x,y);
	}

	@Override
	public void Render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.bigStone,x,y,width,height,null);
		bound(player,g);
	}

	public void bound(Player player, Graphics2D g) {
		if (this.getRectangle().intersects(player.getRectangle())) {
			if(NPC1.getNpc1Question() == 0 &&NPC2.getNpc2Question()==0 ){
				State.setState(new StateA(handler,"res/maps/mapA"));
			}
		}
	}

	@Override
	public int checkQuestion() {
		// TODO Auto-generated method stub
		return 0;
	}
}
