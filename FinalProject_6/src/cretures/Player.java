package cretures;

import java.awt.Graphics2D;

import Run.FrameHandler;
import textures.Animation;
import textures.Assets;

public class Player extends Creature {

	private Animation animUp, animRight, animDown, animLeft;
	public static boolean isTalk = false;
	public static String name ;

	//Create an animation
	public Player(int x, int y, int width, int height, FrameHandler hanlder) {
		super(x, y, width, height, hanlder);
		animUp = new Animation(500, Assets.character_up);
		animDown = new Animation(500, Assets.character_down);
		animRight = new Animation(500, Assets.chararcter_right);
		animLeft = new Animation(500, Assets.character_Left);
	}

	//check player is not talk
	@Override
	public void tick() {
		setRectangle(x, y);
		if (!isTalk) {
			if (handler.getKeyManager().up) {
				y -= 2;
				animUp.tick();
			}
			if (handler.getKeyManager().down) {
				y += 2;
				animDown.tick();
			}
			if (handler.getKeyManager().left) {
				x -= 2;
				animLeft.tick();
			}
			if (handler.getKeyManager().right) {
				x += 2;
				animRight.tick();
			}
			checkBound();

		}

	}

	//draw correct animation
	@Override
	public void Render(Graphics2D g) {
		if (handler.getKeyManager().up ) {
			g.drawImage(animUp.getCurrentFrame(), x, y, null);
		} else if (handler.getKeyManager().down ) {
			g.drawImage(animDown.getCurrentFrame(), x, y, null);
		} else if (handler.getKeyManager().left ) {
			g.drawImage(animLeft.getCurrentFrame(), x, y, null);
		} else if (handler.getKeyManager().right ) {
			g.drawImage(animRight.getCurrentFrame(), x, y, null);
		} else {
			g.drawImage(Assets.character_down[0], x, y, null);
		}

	}

	private void checkBound() {
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}

		if (x >= handler.getWidth() - width) {
			x = handler.getWidth() - width;
		}
		if (y >= handler.getHeight() - height) {
			y = handler.getHeight() - height;
		}
	}

}
