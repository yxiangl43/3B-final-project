package teleport;

import java.awt.Graphics2D;

import Run.FrameHandler;
import cretures.NPC;
import cretures.NPC1;
import cretures.NPC2;
import cretures.NPC4;
import cretures.Player;
import states.State;
import states.StateA;
import states.StateA2;
import textures.Assets;

public class VTelePort extends NPC{

	public VTelePort(int x, int y, int width, int height, FrameHandler handler, Player player) {
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
			if(NPC4.getNPC4Question() == 0){
		
				State.setState(new StateA2(handler,"res/maps/mapA"));
			}
		}
	}


	@Override
	public int checkQuestion() {
		// TODO Auto-generated method stub
		return 0;
	}

}
