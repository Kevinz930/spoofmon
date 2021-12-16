package gameobjects.terrain;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Rock extends TerrainObject {
	Image waterImg;
	boolean inWater;
	public Rock (int r, int c){
		super(r, c);
		try {
			URL url = getClass().getResource("rock.png");
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try {
			URL url = getClass().getResource("water.png");
			waterImg = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		passable = false;
		inWater = true;
	}
	
	public void draw(Graphics g) {
		if(inWater) {
			g.drawImage(waterImg, x, y, width, height, null);
		}
		g.drawImage(img, x, y, width, height, null);
	}
	
}
