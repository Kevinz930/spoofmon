	package gamefiles.battle;

import gameobjects.pokemon.Pokemon;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

import gamefiles.GameMap;

public class ActionGrid extends BattleGrid{
	public String[][] actionArray;
	
	public ActionGrid() {
		actionArray = new String[][] {{"Fight", "Bag"}, {"Pokemon", "Run"}};
	}
	
	public void selection(){
		if(actionArray[selectedRow][selectedCol].equals("Fight")) {
			active = false;
			GameMap.battle.movesGrid.setActive();
		}
		if(actionArray[selectedRow][selectedCol].equals("Bag")) {
			active = false;
			GameMap.battle.noItems = true;
		}
		if(actionArray[selectedRow][selectedCol].equals("Pokemon")) {
			active = false;
			GameMap.battle.noOtherPokemon = true;
		}
		if(actionArray[selectedRow][selectedCol].equals("Run")) {
			active = false;
			GameMap.battle = null;
		}
		active = false;
	}
	
	public void draw(Graphics g) {
		if(active) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			g.drawString("What should " + GameMap.battle.player.currentPokemon().name + " do?", 
					GameMap.width/15, (int) (GameMap.height*.85));
			drawActions(g);
			drawRectangle(g);
 		}
	}
	
	public void drawActions(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString(actionArray[0][0], (int)(GameMap.width*.55) ,(int)(GameMap.height*.84));
		g.drawString(actionArray[0][1], (int)(GameMap.width*.77) ,(int)(GameMap.height*.84));
		g.drawString(actionArray[1][0], (int)(GameMap.width*.55) ,(int)(GameMap.height*.94));
		g.drawString(actionArray[1][1], (int)(GameMap.width*.77) ,(int)(GameMap.height*.94));
	}
	
	public void drawRectangle(Graphics g) {
		((Graphics2D) g).setStroke(new BasicStroke(3));
		g.setColor(new Color(0, 50, 140));
		if(selectedRow == 0 && selectedCol == 0)
			g.drawRect((int)(GameMap.width*.504), (int)(GameMap.height*.773), (int)(GameMap.width*.205), 
					(int)(GameMap.height*.1));
		if(selectedRow == 0 && selectedCol == 1) {
			g.drawRect((int)(GameMap.width*.71), (int)(GameMap.height*.773), (int)(GameMap.width*.209), 
					(int)(GameMap.height*.1));
		}
		if(selectedRow == 1 && selectedCol == 0) {
			g.drawRect((int)(GameMap.width*.504), (int)(GameMap.height*.875), (int)(GameMap.width*.205), 
					(int)(GameMap.height*.105));
		}
		if(selectedRow == 1 && selectedCol == 1) {
			g.drawRect((int)(GameMap.width*.71), (int)(GameMap.height*.875), (int)(GameMap.width*.209), 
					(int)(GameMap.height*.105));
		}
	}
	
}
