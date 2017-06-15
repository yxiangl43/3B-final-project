package Display;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	private MyComponent mc;
	public MyFrame(String title, int width, int height){
		mc = new MyComponent(width,height);
		setTitle(title);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(mc);
		pack();
	}
}
