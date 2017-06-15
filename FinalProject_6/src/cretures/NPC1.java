package cretures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;

import Run.FrameHandler;
import textures.Animation;
import textures.Assets;

public class NPC1 extends NPC {

	private Player player;
	private static int questions = 5;
	private int[] answer;
//	private int choice = 0;
	private int a = 1;
	private int b = 1;
	private String question;
	private int result = 0;

	public NPC1(int x, int y, int width, int height, FrameHandler handler, Player player) {
		super(x, y, width, height, handler, player);
		this.player = player;
		answer = new int[4];
		question = generateQuestion();
	}
	
	//reset the rectangle
	@Override
	public void tick() {
		setRectangle(x, y);
	}
	
	
	//render the image
	@Override
	public void Render(Graphics2D g) {
		g.drawImage(Assets.npc1[face], x, y, width, height, null);
		bound(player, g);
	}
	// Check Bound;

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
				g.drawString("You have " + String.valueOf(questions) + " question left", 30,
						handler.getHeight() / 2 + 250);
				correct = checkUserInput(g);

				if (correct == 1) {

					g.drawString("Correct!!!! ", 30, handler.getHeight() / 2 + 200);
					questions--;

				} else if (correct == (-1)) {

					g.drawString("Wrong!!!! ", 30, handler.getHeight() / 2 + 200);
					questions = 5;
				}
				if (questions == 0) {
					player.isTalk = false;
				}
			}

		}

	}
	//draw question
	private void getQuestion(Graphics g, String question) {
		g.setColor(Color.BLACK);
		g.fillRect(0, handler.getHeight() / 2, handler.getWidth(), handler.getHeight() / 2);
		g.setColor(Color.RED);
		g.drawString("Hey," + Player.name + ". I have some questions for you ! ", 30, handler.getHeight() / 2 + 30);
		g.drawString(question, 30, handler.getHeight() / 2 + 60);
		g.drawString("A. " + String.valueOf(answer[0]), 30, handler.getHeight() / 2 + 80);
		g.drawString("B. " + String.valueOf(answer[1]), 30, handler.getHeight() / 2 + 100);
		g.drawString("C. " + String.valueOf(answer[2]), 30, handler.getHeight() / 2 + 120);
		g.drawString("D. " + String.valueOf(answer[3]), 30, handler.getHeight() / 2 + 140);

	}
	
	//create  questions
	private String generateQuestion() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		a = rand.nextInt(100 + 1);
		sb.append(a);
		b = rand.nextInt(100) + 1;
		switch (rand.nextInt(4)) {
		case 1:
			sb.append(" + " + b);
			result = a + b;
			break;
		case 2:
			sb.append(" - " + b);
			result = a - b;
			break;
		case 3:
			sb.append(" * " + b);
			result = a * b;
			break;
		case 0:
			sb.append(" / " + b);
			result = a / b;
			break;
		}
		answer[0] = result;
		answer[1] = result * 2;
		answer[2] = result / 2;
		answer[3] = result + 2;
		for (int i = 0; i < 100; i++) {
			swap(answer, rand.nextInt(4), rand.nextInt(4));
		}
		return sb.toString();
	}
	public static int getNpc1Question() {
		return questions;
	}
	
	//override from the npc class
	@Override
	public int checkQuestion() {
		if (answer[choice] == result) {
			question = generateQuestion();
			return  1;
		} 
		 question = generateQuestion();
		 return -1;
	}
}
