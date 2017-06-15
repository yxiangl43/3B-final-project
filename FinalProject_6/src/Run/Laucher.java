package Run;

import Display.MyTimer;
import Display.TimeListener;

public class Laucher {
	private static MyTimer time;
	private static TimeListener timeListener;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		timeListener = new TimeListener();
		time = new MyTimer(17,timeListener);
		time.start();
	}

}
