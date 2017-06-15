package cretures;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import Run.FrameHandler;
import textures.Animation;

public abstract class Creature {
	protected int x, y;
	protected int width, height;
	protected Rectangle rect;
	protected FrameHandler handler;
	

	public Creature(int x, int y, int width, int height, FrameHandler handler) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		rect = new Rectangle(x, y, width, height);

	}

	public abstract void tick();

	public abstract void Render(Graphics2D g);

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle getRectangle() {
		return rect;
	}

	public void setRectangle(int x, int y) {
		rect.setLocation(x, y);
	}

}
