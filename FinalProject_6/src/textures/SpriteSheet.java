package textures;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;
	
	public SpriteSheet(Image sheet){
		this.sheet = (BufferedImage)sheet;
	}
	public Image crop(int x ,int y ,int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
}
