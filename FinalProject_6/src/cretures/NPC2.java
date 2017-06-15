package cretures;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Random;

import Run.FrameHandler;
import textures.Assets;

public class NPC2 extends NPC {
	private static final double[] DEGREES = {0, 30, 45, 60, 90, 120, 135, 150, 180 };
	private float result = 0;
	private static int quetionsLeft = 10;
	private String question;
	private float[] answers;

	public NPC2(int x, int y, int width, int height, FrameHandler handler, Player player) {
		super(x, y, width, height, handler, player);
		answers = new float[4];
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

	//check bound
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
	
	//draw questions
	private void getQuestion(Graphics2D g, String question2) {
		g.setColor(Color.BLACK);
		g.fillRect(0, handler.getHeight() / 2, handler.getWidth(), handler.getHeight() / 2);
		g.setColor(Color.RED);
		g.drawString("Hey,"+Player.name+". I have some questions for you ! ", 30, handler.getHeight() / 2 + 30);
		g.drawString(question, 30, handler.getHeight() / 2 + 60);
		g.drawString("A. " + String.valueOf(answers[0]), 30, handler.getHeight() / 2 + 80);
		g.drawString("B. " + String.valueOf(answers[1]), 30, handler.getHeight() / 2 + 100);
		g.drawString("C. " + String.valueOf(answers[2]), 30, handler.getHeight() / 2 + 120);
		g.drawString("D. " + String.valueOf(answers[3]), 30, handler.getHeight() / 2 + 140);
		
		
		g.drawString("Hint: ", handler.getWidth()/2+50,handler.getHeight() / 2 + 100);
		g.drawString("sqrt(3) = 1.73 ", handler.getWidth()/2+50,handler.getHeight() / 2 + 120);
		g.drawString("sqrt(2) = 1.4 ", handler.getWidth()/2+50,handler.getHeight() / 2 + 140);
	}
	
	
	//create questions
	private String generateQuestion() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		int operator = rand.nextInt(3);
		int degree;
		switch (operator) {
		case 0:
			degree = rand.nextInt(8);
			sb.append("Cos " + DEGREES[degree]);
			if(DEGREES[degree] == 90){
				result = 0;
			}else{
				result = (float)Math.cos(DEGREES[degree]*Math.PI/180);
			}
			
			break;
		case 1:
			degree = rand.nextInt(8);
			sb.append("Sin " + DEGREES[degree]);
			result = (float)Math.sin(DEGREES[degree]*Math.PI/180);
			break;
		case 2:
			degree = rand.nextInt(7) + 1;
			while(DEGREES[degree] == 90){
				degree = rand.nextInt(7) + 1;
			}
			sb.append("Tan " + DEGREES[degree]);
			result = (float)Math.tan(DEGREES[degree]*Math.PI/180);
			
			break;
		}
		answers[0] = result;
		answers[1] = result * 2;
		answers[2] = result + 2;
		answers[3] = result - 2;
		for (int i = 0; i < 100; i++)
			swap(answers, rand.nextInt(4), rand.nextInt(4));
		return sb.toString();
	}
	public static int getNpc2Question() {
		return quetionsLeft;
	}

	@Override
	public int checkQuestion() {
		if (answers[choice] == result) {
			question = generateQuestion();
			return 1;
		}
		question = generateQuestion();
		return -1;
	}
}
