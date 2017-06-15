package teleport;

import java.awt.Graphics2D;

import Run.FrameHandler;
import cretures.NPC;
import cretures.NPC3;
import cretures.Player;
import states.State;
import states.StateV;
import textures.Assets;

public class ATelePort extends NPC {


	public ATelePort(int x, int y, int width, int height, FrameHandler handler, Player player) {
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
			if(NPC3.getNpc3Question() == 0 ){
				State.setState(new StateV(handler,"res/maps/mapV"));
			}
		}
	}

	@Override
	public int checkQuestion() {
		// TODO Auto-generated method stub
		return 0;
	}
}