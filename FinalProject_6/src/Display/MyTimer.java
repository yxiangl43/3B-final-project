package Display;

import java.awt.event.ActionListener;

import javax.swing.Timer;

import textures.Assets;

public class MyTimer extends Timer{
	private MyFrame myFrame;
	public MyTimer(int arg0, ActionListener arg1) {
		super(arg0, arg1);
		myFrame = new MyFrame("Math game",600,600);
		myFrame.setVisible(true);
	}

}
