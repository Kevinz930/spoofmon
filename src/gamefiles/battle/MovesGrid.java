	package gamefiles.battle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import gamefiles.GameMap;
import gameobjects.pokemon.moves.Moves;

public class MovesGrid extends BattleGrid{
	public Moves[][] movesArray;
	
	public MovesGrid() {
		movesArray = new Moves[][] {{GameMap.player.currentPokemon().moves.get(0), 
			GameMap.player.currentPokemon().moves.get(1)}, 
			{GameMap.player.currentPokemon().moves.get(2), 
			GameMap.player.currentPokemon().moves.get(3)}};
	}
	
	public void selection() {
		movesArray[selectedRow][selectedCol].activate();
		active = false;
		GameMap.battle.playerUsedMove = true;
	}
	
	public void draw(Graphics g) {
		if(active) {
			drawMoveName(g);
			drawMoveInfo(g);
			drawRectangle(g);
		}
	}
	
	public void drawMoveName(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString(movesArray[0][0].name, (int)(GameMap.width*.55) ,(int)(GameMap.height*.84));
		g.drawString(movesArray[0][1].name, (int)(GameMap.width*.77) ,(int)(GameMap.height*.84));
		g.drawString(movesArray[1][0].name, (int)(GameMap.width*.55) ,(int)(GameMap.height*.94));
		g.drawString(movesArray[1][1].name, (int)(GameMap.width*.77) ,(int)(GameMap.height*.94));
	}
	
	public void drawMoveInfo(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString("Power: " + movesArray[selectedRow][selectedCol].power, GameMap.width/15, (int) (GameMap.height*.85));
		g.drawString("PP: " + movesArray[selectedRow][selectedCol].pp, GameMap.width/15, (int) (GameMap.height*.93));
		g.drawString(movesArray[selectedRow][selectedCol].type, (int) (GameMap.width*.35), (int) (GameMap.height*.885));
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
