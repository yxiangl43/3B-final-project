package states;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Run.FrameHandler;
import cretures.Player;
import worlds.WorldA;
import worlds.WorldX;

public class Menu extends State{
	private String name ="";
	private WorldX worldx;
	
	public Menu(FrameHandler handler, String path) {
		super(handler, path);
		this.worldx = new WorldX(handler, path);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		worldx.tick();
	}

	@Override
	public void render(Graphics2D g) {
		worldx.render(g);
		g.setColor(Color.BLACK);
		g.fillRect(handler.getWidth()/2-200,handler.getHeight()/2-20,400,100);
		
		g.setColor(Color.red);
		g.drawString("Enter your name and press enter to start game", handler.getWidth()/2-180, handler.getHeight()/2);
		if(handler.getKeyManager().justPressed[KeyEvent.VK_ENTER]){
			Player.name = name;
			State.setState(new StateJ(handler,"res/maps/mapJ"));
			
		}
		if(handler.getKeyManager().key.size()!=0){
			if(handler.getKeyManager().justPressed[KeyEvent.VK_BACK_SPACE]){
				if(name.length()!=0){
					name = name.substring(0,name.length()-1);
				}
		
			}else if(handler.getKeyManager().justPressed[handler.getKeyManager().key.getLast()]){
				name +=	KeyEvent.getKeyText(handler.getKeyManager().key.getLast());
			}
			
		}
		
		g.drawString(name, handler.getWidth()/2-180, handler.getHeight()/2+50);
	}

}
