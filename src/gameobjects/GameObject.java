package gameobjects;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import gamefiles.*;


public class GameObject{
	public int row, col, width, height, floor;
	protected int x, y;
	protected String direction;
	public Image img;
	public boolean passable;
	
	public GameObject(int r, int c) {
		this.row = r;
		this.col = c;
		width = GameMap.squareWidth;
		height = GameMap.squareHeight;
		floor = GameMap.currentFloor;
		updateCoordinates();
		
	}
	
	public void tick() {
	}
	
	public void move(String direction) {
	}
	
	public void turn(String direction) {
		if(direction.equals("left"))
			this.direction = "left";
		if(direction.equals("right"))
			this.direction = "right";
	}
	
	public boolean allIntersection(int r, int c) {
		if(terrainIntersection(r, c) || movableIntersection(r, c))
			return true;
		return false;
	}
	
	public boolean terrainIntersection(int r, int c) {
		if(GameMap.getCurrentGrid().grid[r][c] != null && !GameMap.getCurrentGrid().grid[r][c].passable)
			return true;
		return false;
	}
	
	public boolean movableIntersection(int r, int c) {
		for(int x = 0; x < GameMap.getCurrentMovablesList().size(); x++) {
			if(GameMap.getCurrentMovablesList().get(x).row == r && GameMap.getCurrentMovablesList().get(x).col == c)
				return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
	}
	
	public double x() {
		return x;
	}

	public double y() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public double width() {
		return width;
	}
	
	public double height() {
		return height;
	}

	public String direction() {
		return direction;
	}
	
	public Image image() {
		return img;
	}
	
	public int row() {
		return row;
	}
	
	public int col() {
		return col;
	}
	
	public void updateCoordinates() {
		x = col*GameMap.squareWidth;
		y = row*GameMap.squareHeight;
	}
	
}
