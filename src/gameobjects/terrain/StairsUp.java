package gameobjects.terrain;

import gamefiles.GameMap;
import gamefiles.Grid;
import gamefiles.battle.PokemonBattle;
import gameobjects.MovableObject;
import gameobjects.pokemon.Hotdogmon;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.imageio.ImageIO;

public class StairsUp extends TerrainObject{
	public boolean containsPlayer = false;
	Image waterImg;
	public StairsUp(int r, int c) {
		super(r, c);
		try {
			URL url = getClass().getResource("stairsup.png");
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
		passable = true;
	}
	
	public void tick() {
		checkForPlayer();
	}
	
	public void draw(Graphics g) {
		if((GameMap.getCurrentGrid().grid[row-1][col] instanceof Water || GameMap.getCurrentGrid().grid[row-1][col] instanceof Rock) && 
				(GameMap.getCurrentGrid().grid[row+1][col] instanceof Water) || (GameMap.getCurrentGrid().grid[row+1][col] instanceof Rock) &&
				(GameMap.getCurrentGrid().grid[row][col-1] instanceof Water || GameMap.getCurrentGrid().grid[row][col-1] instanceof Rock)  &&
				(GameMap.getCurrentGrid().grid[row][col+1] instanceof Water || GameMap.getCurrentGrid().grid[row][col+1] instanceof Rock)) {
			g.drawImage(waterImg, x, y, width, height, null);
		}
		g.drawImage(img, x, y, width, height, null);
	}
	
	public void checkForPlayer() {
		if(floor == GameMap.player.floor && row == GameMap.player().row() && col == GameMap.player().col() && !GameMap.player().moving() && 
				containsPlayer == false) {
			GameMap.movablesLists.get(GameMap.currentFloor).remove(GameMap.player);
			GameMap.currentFloor++;
			if(GameMap.gridList.size() <= GameMap.currentFloor) {
				GameMap.gridList.add(new Grid(GameMap.currentFloor + 1));
				GameMap.movablesLists.add(new ArrayList<MovableObject>());
			}
			GameMap.movablesLists.get(GameMap.currentFloor).add(GameMap.player);
			GameMap.player.row = GameMap.stairsDown().row;
			GameMap.player.col = GameMap.stairsDown().col;
			GameMap.player.floor++;
			GameMap.stairsDown().containsPlayer = true;
			GameMap.player.moving = true;
		}
		if(floor != GameMap.player.floor || row != GameMap.player().row() ||  col != GameMap.player().col())
			containsPlayer = false;
	}
}
