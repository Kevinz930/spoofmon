package gameobjects;

import java.awt.Graphics;
import java.awt.Image;

import gamefiles.*;

public class MovableObject extends GameObject{
	protected int dx = 0, dy = 0;
	public int steps, speed;
	public boolean moving = false;
	Image imgLeft, imgRight, imgUp, imgDown;
	
	public MovableObject(int r, int c) {
		super(r, c);
		speed = 2;
	}
	
	public void draw(Graphics g) {
	}
	
	public void turn() {
	}
	
	public void move() {
		if(steps > 0){
			x += dx;
			y += dy;
			steps--;
		} else {
			moving = false;
			updateCoordinates();
		}
	}
	
	public void turnForward(){
		if(!moving && row < GameMap.rows - 1 && !allIntersection(row + 1, col)) {
			moving = true;
			steps = (int) (height/2);
			row++;
			dx = 0;
			dy = speed;
		}
	}
	
	public void turnBackward(){
		if(!moving && row > 0 && !allIntersection(row - 1, col)) {
			moving = true;
			steps = (int) (height/2);
			row--;
			dx = 0;
			dy = speed*-1;
		}
	}

	public void turnLeft(){
		if(!moving && col > 0 && !allIntersection(row, col - 1)) {
			moving = true;
			steps = (int) (width/2);
			col--;
			dx = speed*-1;
			dy = 0;
		}
	}
	
	public void turnRight(){
		if(!moving && col < GameMap.cols - 1 && !allIntersection(row, col + 1)) {
			moving = true;
			steps = (int) (width/2);
			col++;
			dx = speed;
			dy = 0;
		}
	}

}
