package gameobjects.trainers.player;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import gamefiles.*;
import gameobjects.MovableObject;
import gameobjects.pokemon.Pepemon;
import gameobjects.pokemon.Pokemon;
import gameobjects.trainers.Trainer;


public class Player extends Trainer{
	int gapX, gapY, imageTicks = 0;
	public boolean facingForward, facingBackward, facingLeft, facingRight, standingForward, standingBackward, standingLeft, 
	standingRight, walkingForward, walkingBackward, walkingLeft, walkingRight, forward1 = true, backward1 = true,
	left1 = true, right1 = true;
	Image standingForwardImg, standingBackwardImg, standingLeftImg, standingRightImg, walkingForward1Img, 
	walkingForward2Img, walkingBackward1Img, walkingBackward2Img, walkingLeft1Img, walkingLeft2Img, walkingRight1Img,
	walkingRight2Img, lastImg;
	public int startFloor;
	
	public Player(int r, int c) {
		super(r, c);
		setUpImages();
		img = standingForwardImg;
		width = (int) (width*.8);
		height = (int) (height*1.1);
		gapX = (int)(GameMap.squareWidth*.2)/2;
		gapY = (int)(GameMap.squareHeight*-.2);
		party.add(new Pepemon());
		party.get(0).level = 1;
	}
	
	public void tick() {
		move();
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
	}
	
	public void battle(MovableObject m) {	
	}
	
	public void updateCoordinates() {
		x = col*GameMap.squareWidth + gapX;
		y = row*GameMap.squareHeight + gapY;
	}
	
	public void move() {
		if(steps > 0){
			x += dx;
			y += dy;
			steps--;
			if(walkingForward){
				walkForward();
			}
			else if(walkingBackward) {
				walkBackward();
			}
			else if(walkingLeft) {
				walkLeft();
			}
			else if(walkingRight) {
				walkRight();
			}
			imageTicks++;
		} else {
			moving = false;
			imageTicks = 0;
			if(facingForward) {
				walkingForward = false;
				img = standingForwardImg;
			}
			else if(facingBackward) {
				walkingBackward = false;
				img = standingBackwardImg;
			}
			else if(facingLeft) {
				walkingLeft = false;
				img = standingLeftImg;
			}
			else if(facingRight) {
				walkingRight = false;
				img = standingRightImg;
			}
			updateCoordinates();
		}
	}
	
	public void walkForward() {
		if(img == walkingForward1Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = standingForwardImg;
		}
		else if(img == standingForwardImg && lastImg == walkingForward1Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = walkingForward2Img;
		}
		else if(img == walkingForward2Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = standingForwardImg;
		}
		else if(img == standingForwardImg && lastImg == walkingForward2Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = walkingForward1Img;
		}
	}
	
	public void walkBackward() {
		if(img == walkingBackward1Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = standingBackwardImg;
		}
		else if(img == standingBackwardImg && lastImg == walkingBackward1Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = walkingBackward2Img;
		}
		else if(img == walkingBackward2Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = standingBackwardImg;
		}
		else if(img == standingBackwardImg && lastImg == walkingBackward2Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = walkingBackward1Img;
		}
	}
	
	public void walkLeft() {
		if(img == walkingLeft1Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = standingLeftImg;
		}
		else if(img == standingLeftImg && lastImg == walkingLeft1Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = walkingLeft2Img;
		}
		else if(img == walkingLeft2Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = standingLeftImg;
		}
		else if(img == standingLeftImg && lastImg == walkingLeft2Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = walkingLeft1Img;
		}
	}
	
	public void walkRight() {
		if(img == walkingRight1Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = standingRightImg;
		}
		else if(img == standingRightImg && lastImg == walkingRight1Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = walkingRight2Img;
		}
		else if(img == walkingRight2Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = standingRightImg;
		}
		else if(img == standingRightImg && lastImg == walkingRight2Img && imageTicks == 15) {
			imageTicks = 0;
			lastImg = img;
			img = walkingRight1Img;
		}
	}
	
	public void turnForward(){
		if(!moving && row < GameMap.rows - 1 && !allIntersection(row + 1, col)) {
			moving = true;
			facingBackward = false;
			facingLeft = false;
			facingRight = false;
			facingForward = true;
			walkingForward = true;
			if(forward1) {
				img = walkingForward1Img;
				lastImg = standingForwardImg;
				forward1 = false;
			} else {
				img = walkingForward2Img;
				lastImg = standingForwardImg;
				forward1 = true;
			}
			
			steps = (int) (GameMap.squareHeight/speed);
			row++;
			dx = 0;
			dy = speed;
		}
	}
	
	public void turnBackward(){
		if(!moving && row > 0 && !allIntersection(row - 1, col)) {
			moving = true;
			facingForward = false;
			facingLeft = false;
			facingRight = false;
			facingBackward = true;
			walkingBackward = true;
			if(backward1) {
				img = walkingBackward1Img;
				lastImg = standingBackwardImg;
				backward1 = false;
			} else {
				img = walkingBackward2Img;
				lastImg = standingBackwardImg;
				backward1 = true;
			}
			steps = (int) (GameMap.squareHeight/speed);
			row--;
			dx = 0;
			dy = speed*-1;
		}
	}
	
	public void turnLeft(){
		if(!moving && col > 0 && !allIntersection(row, col - 1)) {
			moving = true;
			facingForward = false;
			facingBackward = false;
			facingRight = false;
			facingLeft = true;
			walkingLeft = true;
			if(left1) {
				img = walkingLeft1Img;
				lastImg = standingLeftImg;
				left1 = false;
			} else {
				img = walkingLeft2Img;
				lastImg = standingLeftImg;
				left1 = true;
			}
			steps = (int) (GameMap.squareWidth/speed);
			col--;
			dx = speed*-1;
			dy = 0;
		}
	}
	
	public void turnRight(){
		if(!moving && col < GameMap.cols - 1 && !allIntersection(row, col + 1)) {
			moving = true;
			facingForward = false;
			facingBackward = false;
			facingLeft = false;
			facingRight = true;
			walkingRight = true;
			if(right1) {
				img = walkingRight1Img;
				lastImg = standingRightImg;
				right1 = false;
			} else {
				img = walkingRight2Img;
				lastImg = standingRightImg;
				right1 = true;
			}
			steps = (int) (GameMap.squareWidth/speed);
			col++;
			dx = speed;
			dy = 0;
		}
	}
	
	public void setUpImages() {
		try {
			URL url = getClass().getResource("standingforward.png");
			standingForwardImg = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try{
			URL url = getClass().getResource("standingbackward.png");
			standingBackwardImg = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		} 
		try{
			URL url = getClass().getResource("standingleft.png");
			standingLeftImg = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try{
			URL url = getClass().getResource("standingright.png");
			standingRightImg = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try{
			URL url = getClass().getResource("walkingforward1.png");
			walkingForward1Img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try{
			URL url = getClass().getResource("walkingforward2.png");
			walkingForward2Img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try{
			URL url = getClass().getResource("walkingbackward1.png");
			walkingBackward1Img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try{
			URL url = getClass().getResource("walkingbackward2.png");
			walkingBackward2Img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try{
			URL url = getClass().getResource("walkingleft1.png");
			walkingLeft1Img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try{
			URL url = getClass().getResource("walkingleft2.png");
			walkingLeft2Img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try{
			URL url = getClass().getResource("walkingright1.png");
			walkingRight1Img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try{
			URL url = getClass().getResource("walkingright2.png");
			walkingRight2Img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean moving() {
		return moving;		
	}
}
