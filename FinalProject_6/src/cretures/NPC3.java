package cretures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Random;

import Run.FrameHandler;
import textures.Assets;

public class NPC3 extends NPC {
	private static final double INCREMENT = 1E-4;
	private static int quetionsLeft = 10;
	private double[] answer;
	private String question;
	private double result = 0;

	public NPC3(int x, int y, int width, int height, FrameHandler handler, Player player) {
		super(x, y, width, height, handler, player);
		answer = new double[4];
		question = generateQuestion();
	}

	@Override
	public void tick() {
		setRectangle(x, y);
	}

	@Override
	public void Render(Graphics2D g) {
		g.drawImage(Assets.npc2[face], x, y, width, height, null);
		bound(player, g);
	}

	private String generateQuestion() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		int type = rand.nextInt(3);
		int start = rand.nextInt(10);
		int end = rand.nextInt(10);
		if (type == 1) {
			sb.append("Solve the integral : From " + start + " to " + end + " , f(x) = x^2dx");
			result = getIntegral(start, end, 1);
		} else if (type == 0){
			sb.append("Solve the integral : From " + start + " to " + end + " , f(x) = x^3dx");
			result = getIntegral(start, end, 0);
		}else {
			sb.append("Solve the integral : From " + start + " to " + end + " , f(x) = (x-1)^2dx");
			result = getIntegral(start, end, 2);
		}
		answer[0] = result;
		answer[1] = result * 2;
		answer[2] = result + 2;
		answer[3] = result - 2;
		for (int i = 0; i < 100; i++)
			swap(answer, rand.nextInt(4), rand.nextInt(4));
		return sb.toString();
	}

	
	private double getIntegral(int a, int b, int type) {
		double sum = 0;
		int sign;
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
			sign = -1;
		}else{
			sign = 1;
		}
		if (type == 1) {
			for (double i = (double) (a) + INCREMENT; i < b; i += INCREMENT) {
				double currentDistance = i - a;
				sum += (INCREMENT / 2) * (Math.pow((double) (a + currentDistance), 2)
						+ Math.pow((double) (a + currentDistance - INCREMENT), 2));
			}
		} else if(type ==0 ){
			for (double i = (double) (a) + INCREMENT; i < b; i += INCREMENT) {
				double currentDistance = i - a;
				sum += (INCREMENT / 2) * (Math.pow((double) (a + currentDistance), 3)
						+ Math.pow((double) (a + currentDistance - INCREMENT), 3));
			}
		}else{
			for (double i = (double) (a) + INCREMENT; i < b; i += INCREMENT) {
				double currentDistance = i - a;
				sum += (INCREMENT / 2) * (Math.pow((double) (a + currentDistance -1), 2)
						+ Math.pow((double) (a + currentDistance - INCREMENT -1), 2));
			}
		}
		return (Math.round(sum * 1000.0) / 1000.0) * sign;
	}


	private void getQuestion(Graphics g, String question) {
		g.setColor(Color.BLACK);
		g.fillRect(0, handler.getHeight() / 2, handler.getWidth(), handler.getHeight() / 2);
		g.setColor(Color.RED);
		g.drawString("Hey,"+Player.name+". I have some questions for you ! ", 30, handler.getHeight() / 2 + 30);
		g.drawString(question, 30, handler.getHeight() / 2 + 60);
		g.drawString("A. " + String.valueOf(answer[0]), 30, handler.getHeight() / 2 + 80);
		g.drawString("B. " + String.valueOf(answer[1]), 30, handler.getHeight() / 2 + 100);
		g.drawString("C. " + String.valueOf(answer[2]), 30, handler.getHeight() / 2 + 120);
		g.drawString("D. " + String.valueOf(answer[3]), 30, handler.getHeight() / 2 + 140);
		
		g.drawString("Please choose the BEST answer !!! ", 30, handler.getHeight() / 2 + 180);
	}
	public void bound(Player player, Graphics2D g) {
		
		if (handler.getKeyManager().justPressed[KeyEvent.VK_ESCAPE]) {
			player.isTalk = false;

		}
		if (this.getRectangle().intersects(player.getRectangle())) {
			if (player.x < this.x && player.y < this.y) {
				face = 3;
			} else if (player.x > this.x && player.y < this.y) {
				face = 0;
			} else if (player.x < this.x && player.y > this.y) {
				face = 2;
			} else {
				face = 1;
			}
			if (handler.getKeyManager().justPressed[KeyEvent.VK_SPACE]) {
				player.isTalk = true;

			}
			
			if (player.isTalk) {
				correct = 0;
//				question = generateQuestion();
				getQuestion(g, question);

				g.drawString("You have " + String.valueOf(quetionsLeft) + " question left", 30,
						handler.getHeight() / 2 + 250);
				correct = checkUserInput(g);
				if (correct == 1) {
					g.drawString("Correct!!!! ", 30, handler.getHeight() / 2 + 200);
					quetionsLeft--;
				} else if (correct == (-1)) {
					g.drawString("Wrong!!!! ", 30, handler.getHeight() / 2 + 200);
					quetionsLeft = 10;
				}
				if (quetionsLeft == 0) {
					player.isTalk = false;
				}
			}
		}
	}
	public static int getNpc3Question() {
		return quetionsLeft;
	}

	@Override
	public int checkQuestion() {
		if (answer[choice] == result) {
			question = generateQuestion();
			return 1;
		}
		question = generateQuestion();
		return -1;
	}
}
