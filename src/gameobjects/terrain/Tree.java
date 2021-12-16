package gameobjects.terrain;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class Tree extends TerrainObject{
	
	public Tree(int r, int c) {
		super(r, c);
		try {
			URL url = getClass().getResource("tree.png");
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		passable = false;
	}
	
}
