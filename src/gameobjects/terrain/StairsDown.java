package gameobjects.terrain;

import gamefiles.GameMap;
import gameobjects.MovableObject;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class StairsDown extends TerrainObject{
	public boolean containsPlayer = false;
	
	public StairsDown(int r, int c) {
		super(r, c);
		try {
			URL url = getClass().getResource("stairsdown.png");
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		passable = true;
	}
	
	public void tick() {
		checkForPlayer();
	}
	
	public void checkForPlayer() {
		if(floor == GameMap.player.floor && row == GameMap.player().row() && col == GameMap.player().col() && !GameMap.player().moving() && 
				containsPlayer == false) {
			GameMap.movablesLists.get(GameMap.currentFloor).remove(GameMap.player);
			GameMap.currentFloor--;
			GameMap.movablesLists.get(GameMap.currentFloor).add(GameMap.player);
			
			GameMap.player.row = GameMap.stairsUp().row;
			GameMap.player.col = GameMap.stairsUp().col;
			GameMap.player.floor--;
			GameMap.stairsUp().containsPlayer = true;
			GameMap.player.moving = true;
		}
		if(floor != GameMap.player.floor || row != GameMap.player().row() ||  col != GameMap.player().col())
			containsPlayer = false;
	}

}
