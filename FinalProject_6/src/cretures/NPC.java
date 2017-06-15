package cretures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Run.FrameHandler;

public abstract class NPC extends Creature{
	protected Player player;
	protected int face = 2;
	protected int choice = 0;
	protected int correct = 0;
	public NPC(int x, int y, int width, int height, FrameHandler handler,Player player) {
		super(x, y, width, height, handler);
		this.player = player;
	}
	public abstract void tick();
	public abstract void Render(Graphics2D g);
	
	//swap functions
	public void swap(int[] a, int first, int second) {
		int temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}
	public void swap(double[] a, int first, int second) {
		double temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}
	public void swap(float[] a, int first, int second) {
		float temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}
	public void swap(String[]a, int first, int second) {
		String temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}
	//Allow npcs can implement this function
	protected int checkUserInput(Graphics2D g) {

		if (handler.getKeyManager().justPressed[KeyEvent.VK_UP]) {
			choice = 0;
		}
		if (handler.getKeyManager().justPressed[KeyEvent.VK_DOWN]) {
			choice = 2;
		}
		if (handler.getKeyManager().justPressed[KeyEvent.VK_RIGHT]) {
			choice = 1;
		}
		if (handler.getKeyManager().justPressed[KeyEvent.VK_LEFT]) {
			choice = 3;
		}

		switch (choice) {
		case 0:
			g.drawString(">> A ", 30, handler.getHeight() / 2 + 215);
			break;
		case 1:
			g.drawString(">> B ", 30, handler.getHeight() / 2 + 215);
			break;
		case 2:
			g.drawString(">> C ", 30, handler.getHeight() / 2 + 215);
			break;
		case 3:
			g.drawString(">> D ", 30, handler.getHeight() / 2 + 215);
			break;
		}

//		if (handler.getKeyManager().justPressed[KeyEvent.VK_ENTER]) {
//			if (answer[choice] == result) {
//				correct = 1;
//			} else {
//				correct = -1;
//			}
////			question = generateQuestion();
//		}
		if (handler.getKeyManager().justPressed[KeyEvent.VK_ENTER]) {
			correct = checkQuestion();
		}
		return correct;

	}
	public abstract int checkQuestion();
}
