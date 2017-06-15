package textures;

import java.awt.Image;
import java.awt.image.BufferedImage;


public class Assets {
	
	private static final int width = 32, height = 36;
	private static final int groundWidth = 32, groundHeight = 32;
	public static Image stone,grass,dirt, door;
	public static Image bigStone;
	
	
	public static Image[] character_up, character_down,character_Left,chararcter_right;
	public static Image[] npc1, npc2,npc3;
	
	
	public static void  init(){
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
		SpriteSheet	teacher1Sheet = new SpriteSheet(ImageLoader.loadImage("/textures/teacher1.png"));
		SpriteSheet teachcer2Sheet = new SpriteSheet(ImageLoader.loadImage("/textures/teacher2.png"));
		SpriteSheet teachcer3Sheet = new SpriteSheet(ImageLoader.loadImage("/textures/teacher3.png"));
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		character_up = new Image[3]; 
		character_up[0]= playerSheet.crop(0,0,width,height);
		character_up[1]= playerSheet.crop(width,0,width,height);
		character_up[2]= playerSheet.crop(width*2,0,width,height);
		
		chararcter_right = new Image[3]; 
		chararcter_right[0]= playerSheet.crop(0,height,width,height);
		chararcter_right[1]= playerSheet.crop(width,height,width,height);
		chararcter_right[2]= playerSheet.crop(width*2,height,width,height);
		
		
		character_down = new Image[3]; 
		character_down[0]= playerSheet.crop(0,height*2,width,height);
		character_down[1]= playerSheet.crop(width,height*2,width,height);
		character_down[2]= playerSheet.crop(width*2,height*2,width,height);
		
		character_Left = new Image[3]; 
		character_Left[0]= playerSheet.crop(0,height*3,width,height);
		character_Left[1]= playerSheet.crop(width,height*3,width,height);
		character_Left[2]= playerSheet.crop(width*2,height*3,width,height);
		

		
		npc1= new Image[4];
		npc1[0]= teacher1Sheet.crop(width,0,width, height);
		npc1[1]= teacher1Sheet.crop(width,height,width, height);
		npc1[2]= teacher1Sheet.crop(width,height*2,width, height);
		npc1[3]= teacher1Sheet.crop(width,height*3,width, height);
		
		npc2 = new Image[4];
		npc2[0]= teachcer2Sheet.crop(width,0,width, height);
		npc2[1]= teachcer2Sheet.crop(width,height,width, height);
		npc2[2]= teachcer2Sheet.crop(width,height*2,width, height);
		npc2[3]= teachcer2Sheet.crop(width,height*3,width, height);
		
		npc3 = new Image[4];
		npc3[0]= teachcer3Sheet.crop(width,0,width, height);
		npc3[1]= teachcer3Sheet.crop(width,height,width, height);
		npc3[2]= teachcer3Sheet.crop(width,height*2,width, height);
		npc3[3]= teachcer3Sheet.crop(width,height*3,width, height);
		
		dirt = sheet.crop(groundWidth, 0, groundWidth, groundHeight);
		grass = sheet.crop(groundWidth * 2, 0, groundWidth, groundHeight);
		stone = sheet.crop(groundWidth * 3, 0, groundWidth, groundHeight);
		bigStone = sheet.crop(0, groundHeight*2, groundWidth, groundHeight);
//		tree = sheet.crop(0, 0, width, height * 2);
//		rock = sheet.crop(0, height * 2, width, height);
	}
}
