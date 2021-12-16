package gamefiles.battle;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Vector;

import gamefiles.GameMap;

public class BattleGrid {
	public boolean active = false;
	protected int selectedRow = 0;
	protected int selectedCol = 0;
	
	public BattleGrid() {
	}
	
	public void draw(Graphics g) {
	}
	
	public void setActive() {
		active = true;
		selectedRow = 0;
		selectedCol = 0;
	}
	
	public void selectHorizontal() {
		if(selectedCol == 0) {
			selectedCol = 1;
		}
		else {
			selectedCol = 0;
		}
	}
	
	public void selectVertical() {
		if(selectedRow == 0) {
			selectedRow = 1;
		}
		else {
			selectedRow = 0;
		}
	}
	
	public boolean active() {
		return active;
	}

	public void selection() {
	}
	
}
