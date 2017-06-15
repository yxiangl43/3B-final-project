package Display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.BorderFactory;
import javax.swing.JComponent;


import Run.FrameHandler;
import states.Menu;
import states.State;
import states.StateA;
import states.StateA2;
import states.StateJ;
import states.StateV;
import textures.Assets;


public class MyComponent extends JComponent {
	private FrameHandler fm;
	private StateJ stateJ;
	private StateA stateA; 
	private StateV stateV;
	private StateA2 stateA2;
	private Menu menu;

	private KeyManager keyManager;
	public MyComponent(int width, int height) {
		
		setSize(width,height);
		setFocusable(true);
		setPreferredSize(new Dimension(width,height));
		setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		keyManager = new KeyManager();
		Assets.init();
		this.addKeyListener(keyManager);
		fm = new FrameHandler(this);
		stateJ = new StateJ(fm,"res/maps/mapJ");
		stateA = new StateA(fm,"res/maps/mapA");
		stateV = new StateV(fm,"res/maps/mapV");
		menu = new Menu(fm,"res/maps/mapS");

		
		stateA2 = new StateA2(fm,"res/maps/mapA");
		if(State.getState()==null){
			State.setState(stateV);
		}
	    try{
	    	   AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("res/music/background.wav"));
	           Clip clip = AudioSystem.getClip();
	           clip.open(inputStream);
	           clip.loop(Clip.LOOP_CONTINUOUSLY);
	      }
	     catch(Exception ex)
	     {  
	    	 System.out.println("Not well");
	     }
	
	}

	private void tick() {
		State.getState().tick();
		keyManager.tick();
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// tick
		tick();
		// render
		State.getState().render(g2);
	}
	public KeyManager getKeyManager(){
		return keyManager;
	}

}
