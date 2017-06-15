package Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Run.FrameHandler;

public class TimeListener implements  ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		FrameHandler.getPanel().repaint();
	}

}
