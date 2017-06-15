package cretures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Random;

import Run.FrameHandler;
import Run.ReadNPC4Question;
import textures.Assets;

public class NPC4 extends NPC {
	private String questions[][];
	private String answers[];
	private static int questionsLeft = 5;
	private int face = 2;
	
	public NPC4(int x, int y, int width, int height, FrameHandler handler, Player player) {
		super(x, y, width, height, handler, player);
		questions = new String[5][4];
		answers = new String[5];
		ReadNPC4Question.loadFile("res/maps/Questions", questions, answers);
		setUpQuestion();
	}

	@Override
	public void tick() {
		setRectangle(x, y);
	}

	@Override
	public void Render(Graphics2D g) {
		g.drawImage(Assets.npc3[face], x, y, width, height, null);
		bound(player, g);
	}

	private void getQuestion(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, handler.getHeight() / 2, handler.getWidth(), handler.getHeight() / 2);
		g.setColor(Color.RED);
		g.drawString("Hey,"+Player.name+". I have some questions for you ! "+ " Which one is correct", 30,
				handler.getHeight() / 2 + 30);
		g.drawString("A. " + questions[questionsLeft - 1][0], 30, handler.getHeight() / 2 + 80);
		g.drawString("B. " + questions[questionsLeft - 1][1], 30, handler.getHeight() / 2 + 100);
		g.drawString("C. " + questions[questionsLeft - 1][2], 30, handler.getHeight() / 2 + 120);
		g.drawString("D. " + questions[questionsLeft - 1][3], 30, handler.getHeight() / 2 + 140);

		g.drawString("Please choose the BEST answer !!! ", 30, handler.getHeight() / 2 + 180);
	}

	public  void setUpQuestion() {
		Random rand = new Random();
		for(int i = 0 ; i < 5 ; i++){
			for (int j = 0; j < 100; j++){
				swap(questions[i], rand.nextInt(3), rand.nextInt(3));
			}
				
		}
		
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
				// question = generateQuestion();
				getQuestion(g);
				g.drawString("You have " + String.valueOf(questionsLeft) + " question left", 30,
						handler.getHeight() / 2 + 250);
				correct = checkUserInput(g);
				if (correct == 1) {
					g.drawString("Correct!!!! ", 30, handler.getHeight() / 2 + 200);
					questionsLeft--;
				} else if (correct == (-1)) {
					g.drawString("Wrong!!!! ", 30, handler.getHeight() / 2 + 200);
					questionsLeft = 5;
				}
				if (questionsLeft == 0) {
					player.isTalk = false;
				}
				
			}
		}
	}




	public static int getNPC4Question() {
		return questionsLeft;
	}

	@Override
	public int checkQuestion() {
		for (int i = 0; i < 5; i++) {
			if (questions[questionsLeft - 1][choice].equals(answers[i])) {
				return 1;
			}
		}
		return -1;
	}
}
