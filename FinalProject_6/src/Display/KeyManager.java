package Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class KeyManager implements KeyListener {
	public LinkedList<Integer> key = new LinkedList<>();
	public boolean[] keys, justPressed, cantPress;
	public static boolean up, down, left, right;
	public static boolean aUp, aDown, aLeft, aRight;
	public static boolean spcae, esc, enter;

	public KeyManager() {
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}

	public void tick() {
		for (int i = 0; i < keys.length; i++) {
			if (cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			} else if (justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if (!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}
		enter = keys[KeyEvent.VK_ENTER];
		esc = keys[KeyEvent.VK_ESCAPE];
		spcae = keys[KeyEvent.VK_SPACE];
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];

		aUp = keys[KeyEvent.VK_UP];
		aDown = keys[KeyEvent.VK_DOWN];
		aLeft = keys[KeyEvent.VK_LEFT];
		aRight = keys[KeyEvent.VK_RIGHT];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		int code = e.getKeyCode();
		Integer val = Integer.valueOf(code);
		key.add(val);
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
