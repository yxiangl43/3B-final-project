package states;

import java.awt.Graphics2D;

import Run.FrameHandler;

public abstract class State {
	
	private static State currentState = null;
	protected FrameHandler handler;
	private String path;
	public State(FrameHandler handler,String path){
		this.handler = handler;
		this.path = path;
	}
	public static void setState(State state){
		currentState = state;
	}
	public static State getState(){
		return currentState;
	}
	
	public abstract void tick();
	public abstract void render(Graphics2D g);

}
