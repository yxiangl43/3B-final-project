package cretures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Random;

import Run.FrameHandler;
import textures.Assets;

public class NPC5 extends NPC {
	private static int questions = 1;
	private int[][] matrixA;
	private int[][] matrixB;
	private int face = 2;
	private int[][] result;
	private int answer[][][];

	public NPC5(int x, int y, int width, int height, FrameHandler handler, Player player) {
		super(x, y, width, height, handler, player);
		matrixA = new int[3][3];
		matrixB = new int[3][3];
		result = new int[3][3];
		answer = new int[4][3][3];
		generateQuestion();
		swap();
	}

	@Override
	public void tick() {
		setRectangle(x,y);
	}

	@Override
	public void Render(Graphics2D g) {
		g.drawImage(Assets.npc1[face], x, y, width, height, null);
		if(questions == 0 ){
			g.drawString("You Win", handler.getWidth()/2, handler.getHeight()/2);
		}
		bound(player,g);

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
				getQuestion(g);
				correct = checkUserInput(g);

				if (correct == 1) {
					g.drawString("Correct!!!! ", 30, handler.getHeight() / 2 + 200);
					questions--;
				} else if (correct == (-1)) {
					g.drawString("Wrong!!!! ", 30, handler.getHeight() / 2 + 200);
					questions = 1;
				}
				if (questions == 0) {
					player.isTalk = false;
				}
			}

		}

	}

	private void generateQuestion() {
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrixA[i][j] = rand.nextInt(10);
				matrixB[i][j] = rand.nextInt(10);
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) { 
				for (int k = 0; k < 3; k++) { 
					result[i][j] += matrixA[i][k] * matrixB[k][j];
				}
			}
		}
		for(int i =0 ; i < 4; i++ ){
			for(int j = 0 ; j < 3; j ++){
				for(int k = 0 ; k < 3; k++){
					if(i == 0){
						answer[i][j][k] = result[j][k];
					}
					else{
						answer[i][j][k] = result[j][k]+rand.nextInt(100);
					}
				}
			}
		}

	}

	private void getQuestion(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, handler.getHeight() / 2, handler.getWidth(), handler.getHeight() / 2);
		g.setColor(Color.RED);
		g.drawString("Hey,"+Player.name+". I have some questions for you ! the matrix product ", 30, handler.getHeight() / 2 + 30);
		
		g.drawString("Matrix A", 30,handler.getHeight()/2+40);
		g.drawString("Matrix B",30+handler.getWidth()/2,handler.getHeight()/2+40);
		
		for(int i = 0 ; i < 60 ; i+=20){
			for(int j = 0 ; j< 30; j += 10){
				g.drawString(String.valueOf(matrixA[i/20][j/10]), 30 + j,handler.getHeight()/2+50+i);
			}
		}
		for(int i = 0 ; i < 60 ; i+=20){
			for(int j = 0 ; j< 30; j += 10){
				g.drawString(String.valueOf(matrixB[i/20][j/10]), 30+handler.getWidth()/2+ j,handler.getHeight()/2+50+i);
			}
		}
		g.drawString("A. ", 30,handler.getHeight()/2+110);
		g.drawString("B. ", 150,handler.getHeight()/2+110);
		g.drawString("C. ", 270,handler.getHeight()/2+110);
		g.drawString("D. ", 390,handler.getHeight()/2+110);
		
//		 drwa Answer
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < 60 ; j += 20){
				for(int k = 0 ; k < 90 ; k+=30){
					g.drawString(String.valueOf(answer[i][j/20][k/30]+" "), 30+k+i*120,handler.getHeight()/2+120+j);
					
				}
			}
		}

	}

	
	private void swap(){
		Random rand = new Random();
		for(int i =0 ; i< 10; i++){
			int firstM = rand.nextInt(4);
			int secondM = rand.nextInt(4);
			for(int j = 0 ; j < 3 ; j++){
				for(int k = 0 ; k< 3; k++){
					int temp = answer[firstM][j][k];
					answer[firstM][j][k] = answer[secondM][j][k];
					 answer[secondM][j][k]= temp;
				}
			}
		}
	}


	public static int getNpc5Question() {
		return questions;
	}

	@Override
	public int checkQuestion() {
		for(int i = 0; i<3 ; i ++){
			for(int j =0 ; j< 3; j++){
				if(result[i][j] != answer[choice][i][j]){
					return -1;
				}
			}
		}
		return 1;
	}

}
