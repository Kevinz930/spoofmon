package gameobjects.terrain;

import java.awt.Graphics;
import java.awt.Image;

import gameobjects.GameObject;

public class TerrainObject extends GameObject{
	public boolean drawOver = false;
	Image drawOverImg;
	public boolean containsPlayer = false;

	public TerrainObject(int r, int c) {
		super(r, c);
	}
	
	public void draw(Graphics g) { 
		g.drawImage(img, x, y, width, height, null);
	}
	
	public void drawOver(Graphics g) {
		g.drawImage(drawOverImg, x, y, width, height, null);
	}
	
	public void tick() {
	}

}
