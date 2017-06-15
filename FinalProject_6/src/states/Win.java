package states;

import java.awt.Color;
import java.awt.Graphics2D;

import Run.FrameHandler;

public class Win extends State{

	public Win(FrameHandler handler, String path) {
		super(handler, path);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0,handler.getWidth(), handler.getHeight());
		g.setColor(Color.red);
		g.drawString("You win!!!!", handler.getWidth()/2-80, handler.getHeight()/2);
		
		
	}

}
