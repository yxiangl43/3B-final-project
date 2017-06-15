package Run;

import Display.KeyManager;
import Display.MyComponent;

public class FrameHandler {
	private static MyComponent mc;
	public FrameHandler(MyComponent mc){
		this.mc = mc;
	}
	public int getWidth(){
		return mc.getWidth();
	}
	public int getHeight(){
		return mc.getHeight();
	}
	public static MyComponent getPanel(){
		return mc;
	}
	public  KeyManager getKeyManager(){
		return mc.getKeyManager();
	}
}
