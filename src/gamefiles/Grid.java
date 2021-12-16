package gamefiles;
import java.awt.Graphics;
import java.awt.Toolkit;

import gameobjects.*;
import gameobjects.terrain.*;
import gameobjects.trainers.player.Player;


public class Grid {
	public TerrainObject[][] grid;
	public int floor;

	public Grid(int floor) {
		grid = new TerrainObject[GameMap.rows][GameMap.cols];
		this.floor = floor;
		double x = Math.random();
		if(x < .5) {
			generateTreeWalls();
			generateGrass();
			generatePuddles();
		} else if(x < .75) {
			generateTreeWalls();
			generateTrees();
			generateGrassField();
		} else if(x < 1) {
			generateRockWalls();
			generateRocks();
			generateOcean();
		}
		generateStairs();
	}
	
	public void draw(Graphics g) {
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				if(grid[r][c] != null) {
					grid[r][c].draw(g);
				}
			}
		}
	}
	
	public void drawOver(Graphics g) {
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				if(grid[r][c] instanceof Grass && grid[r][c].drawOver) {
					grid[r][c].drawOver(g);
				}
			}
		}
	}
	
	public void generateTreeWalls() {
		for(int r = 0; r < 1; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				grid[r][c] = new Tree(r, c);
			}
		}
		for(int r = grid.length-1; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				grid[r][c] = new Tree(r, c);
			}
		}
		for(int r = 1; r < grid.length-1; r++) {
			for(int c = 0; c < 1; c++) {
				grid[r][c] = new Tree(r, c);
			}
		}
		for(int r = 1; r < grid.length-1; r++) {
			for(int c = grid[r].length-1; c < grid[r].length; c++) {
				grid[r][c] = new Tree(r, c);
			}
		}
	}
	
	public void generateRockWalls() {
		for(int r = 0; r < 1; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				grid[r][c] = new Rock(r, c);
			}
		}
		for(int r = grid.length-1; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				grid[r][c] = new Rock(r, c);
			}
		}
		for(int r = 1; r < grid.length-1; r++) {
			for(int c = 0; c < 1; c++) {
				grid[r][c] = new Rock(r, c);
			}
		}
		for(int r = 1; r < grid.length-1; r++) {
			for(int c = grid[r].length-1; c < grid[r].length; c++) {
				grid[r][c] = new Rock(r, c);
			}
		}
	}
	
	public void generateTrees() {
		for(int x = 0; x < 100; x++) {
			int r = (int) (Math.random() * GameMap.rows);
			int c = (int) (Math.random() * GameMap.cols);
			if(grid[r][c] == null) {
				grid[r][c] = new Tree(r, c);
			}
		}
	}
	
	public void generateRocks() {
		for(int x = 0; x < 100; x++) {
			int r = (int) (Math.random() * GameMap.rows);
			int c = (int) (Math.random() * GameMap.cols);
			if(grid[r][c] == null && (r != GameMap.player.row && c != GameMap.player.col)) {
				grid[r][c] = new Rock(r, c);
			}
		}
	}
	
	public void generateGrass() {
		for(int x = 0; x < 200; x++) {
			int r = (int) (Math.random() * GameMap.rows);
			int c = (int) (Math.random() * GameMap.cols);
			if(grid[r][c] == null && (r != GameMap.player.row && c != GameMap.player.col)) {
				grid[r][c] = new Grass(r, c);
			}
		}
	}
	
	public void generatePuddles() {
		for(int x = 0; x < 80; x++) {
			int r = (int) (Math.random() * GameMap.rows);
			int c = (int) (Math.random() * GameMap.cols);
			if(grid[r][c] == null) {
				grid[r][c] = new Puddle(r, c);
			}
		}
	}
	
	public void generateGrassField() {
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				if(grid[r][c] == null) {
					grid[r][c] = new Grass(r, c);
				}
			}
		}
	}
	
	public void generateOcean() {
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				if(grid[r][c] == null) {
					grid[r][c] = new Water(r, c);
				}
			}
		}
	}
	
	public void generateStairs() {
		int r = (int) (Math.random() * GameMap.rows);
		int c = (int) (Math.random() * GameMap.cols);
		while((grid[r][c] instanceof Tree || grid[r][c] instanceof Rock) && r != GameMap.player.row && 
				c != GameMap.player.col) {
			r = (int) (Math.random() * GameMap.rows);
			c = (int) (Math.random() * GameMap.cols);
		}
		grid[r][c] = new StairsUp(r, c);
		
		r = (int) (Math.random() * GameMap.rows);
		c = (int) (Math.random() * GameMap.cols);
		if(floor != 1) {
			while((grid[r][c] instanceof Tree || grid[r][c] instanceof Rock) &&r != GameMap.player.row && 
					c != GameMap.player.col) {
				r = (int) (Math.random() * GameMap.rows);
				c = (int) (Math.random() * GameMap.cols);
			}
			grid[r][c] = new StairsDown(r, c);
		}
	}
	
	public Object get(int r, int c) {
		return grid[r][c];
	}
	
	public int rows() {
		return grid.length;
	}
	
	public int cols() {
		return grid[0].length;
	}
	
}
