package gamefiles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import gamefiles.battle.Battle;
import gamefiles.battle.PokemonBattle;
import gameobjects.*;
import gameobjects.pokemon.*;
import gameobjects.terrain.StairsDown;
import gameobjects.terrain.StairsUp;
import gameobjects.trainers.*;
import gameobjects.trainers.player.Player;


public class GameMap {
	
	public static int width = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
	public static int height = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	public static int currentFloor = 0;
	public static int rows = 18;
	public static int cols = 30;
	public static int squareWidth = (int) (width/cols);
	public static int squareHeight = (int) (height/rows);
	public static List<Grid> gridList = new ArrayList<Grid>(); 
	public static List<List<MovableObject>> movablesLists = new ArrayList();
	public static Battle battle;
	public static Player player;
	public boolean intro = true;
	
	public GameMap() {
		player = new Player(1, 1);
		gridList.add(new Grid(1));
		movablesLists.add(new ArrayList<MovableObject>());
		movablesLists.get(currentFloor).add(player);
	}
	
	public static Grid getGrid(int level) {
		return gridList.get(level);
	}
	
	public static Grid getCurrentGrid() {
		return gridList.get(currentFloor);
	}
	
	public static List<MovableObject> getCurrentMovablesList() {
		return movablesLists.get(currentFloor);
	}
	
	public static Player player() {
		return player;
	}
	
	public static StairsUp stairsUp() {
		for(int r = 0; r  < GameMap.getCurrentGrid().grid.length; r++) {
			for(int c = 0; c < GameMap.getCurrentGrid().grid[0].length; c++) {
				if(GameMap.getCurrentGrid().grid[r][c] instanceof StairsUp)
					return (StairsUp) GameMap.getCurrentGrid().grid[r][c];
			}
		}
		return null;
	}
	
	public static StairsDown stairsDown() {
		for(int r = 0; r  < GameMap.getCurrentGrid().grid.length; r++) {
			for(int c = 0; c < GameMap.getCurrentGrid().grid[0].length; c++) {
				if(GameMap.getCurrentGrid().grid[r][c] instanceof StairsDown)
					return (StairsDown) GameMap.getCurrentGrid().grid[r][c];
			}
		}
		return null;
	}

	public void tick() {
		if(battle == null) {
			for(MovableObject m : getCurrentMovablesList()){
				m.tick();
			}
		}
		for(int r = 0; r < getCurrentGrid().rows(); r++) {
			for(int c = 0; c < getCurrentGrid().cols(); c++) {
				if(getCurrentGrid().grid[r][c] != null)
					getCurrentGrid().grid[r][c].tick();
			}
		}
	}
	
	public void draw(Graphics g) {
		if(battle == null) {
			gridList.get(currentFloor).draw(g);
			for(int x = 0; x < getCurrentMovablesList().size(); x++) {
				if(currentFloor < movablesLists.size())
					getCurrentMovablesList().get(x).draw(g);
			}
			gridList.get(currentFloor).drawOver(g);
		}
		if(battle != null) {
			battle.draw(g);
		}
	}
	
}
