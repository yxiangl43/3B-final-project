package worlds;
import java.awt.Graphics2D;

import Run.FrameHandler;
import Run.ReadString;
import tiles.Tile;

public abstract class World {
	
	protected int height,width;
	protected int startX, startY;
	protected FrameHandler fm;
	protected int[][] tiles;
	protected String path;
	public World(FrameHandler fm,String path){
		this.fm =fm;
		this.path = path;
	}
	public abstract void tick();
	public abstract void render(Graphics2D g);
	public Tile getTile(int x ,int y ){
		if(x < 0 || y < 0 || x>= width || y >= height){
			return Tile.grassTile;
		}
		Tile t= Tile.tiles[tiles[x][y]];
		if(t == null){
			return Tile.dirtTile;
		}
		return t;
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	protected void drawMap(Graphics2D g){
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				fm.getPanel().setSize(fm.getWidth(), fm.getHeight());
				getTile(i, j).render(g, i * fm.getWidth() / width + 1, j * fm.getHeight() / height + 1,
						(int) fm.getWidth() / width + 1, (int) fm.getHeight() / height + 1);
			}
		}
	}
	protected void loadWorld(String path) {
		String file = ReadString.loadFile(path);
		String[] tokens = file.split("\\s+");
		width = ReadString.parseInt(tokens[0]);
		height = ReadString.parseInt(tokens[1]);
		startX = ReadString.parseInt(tokens[2]);
		startY = ReadString.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				tiles[i][j] = ReadString.parseInt(tokens[(i + j * width) + 4]);
			}
		}
	}
}
