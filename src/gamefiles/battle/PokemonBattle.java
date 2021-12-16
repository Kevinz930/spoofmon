package gamefiles.battle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

import gamefiles.GameMap;
import gameobjects.MovableObject;
import gameobjects.pokemon.Pokemon;
import gameobjects.pokemon.moves.Moves;

public class PokemonBattle extends Battle{
	
	
	public PokemonBattle(Pokemon opponent) {
		this.opponent = opponent;
	}
	
	public void spaceKey() {
		if(newBattle) {
			newBattle = false;
			playerTurn();
		} 
		else if(actionGrid.active) {
			actionGrid.selection();
		} 
		else if(movesGrid.active) {
			movesGrid.selection();
		} 
		else if(playerUsedMove) {
			playerUsedMove = false;
			playerMoveEffects = true;
		} 
		else if(playerMoveEffects) {
			playerMoveEffects = false;
			checkOpponentFainted();
			if(!opponentPokemonFainted) {
				opponentUsedMove = true;
			}
			opponentTurn();
		}
		else if(opponentPokemonFainted) {
			GameMap.battle = null;
		}
		else if(opponentUsedMove) {
			opponentUsedMove = false;
			opponentMoveEffects = true;
			opponentMove.activate();
		}
		else if(opponentMoveEffects) {
			opponentMoveEffects = false;
			checkPlayerPokemonFainted();
			if(!playerPokemonFainted)
				playerTurn();
		}
		else if(playerPokemonFainted) {
		}
	}
	
	public void opponentTurn() {
		opponentMove = opponentPokemon().moves.get((new Random()).nextInt(opponentPokemon().moves.size()));;
	}
	
	public Pokemon opponentPokemon() {
		return opponent;
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.GREEN);
		if((double)opponentPokemon().health/(double)opponentPokemon().originalHealth <= .5)
			g.setColor(Color.ORANGE);
		if((double)opponentPokemon().health/(double)opponentPokemon().originalHealth <= .25)
			g.setColor(Color.RED);
		g.fillRect((int)(GameMap.width*.191), (int)(GameMap.height*.215), 
				(int)((GameMap.width*.197)*((double)opponentPokemon().health/(double)opponentPokemon().originalHealth)), 
				(int)(GameMap.height*.021));
		g.setColor(Color.BLACK);
		g.drawString(opponent.name, (int)(GameMap.width*.02), (int)(GameMap.height*.18));
		player.currentPokemon().drawPlayer(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		opponent.drawOpponent(g);
		if(newBattle) {
			g.drawString("A wild " + opponent.name + " appeared!", 
					GameMap.width/15, (int) (GameMap.height*.85));
		}
		
		actionGrid.draw(g);
		movesGrid.draw(g);
		if(actionGrid.active || movesGrid.active) {
			g.setColor(Color.BLACK);
			((Graphics2D) g).setStroke(new BasicStroke(7));
			g.drawRect((int) (GameMap.width*.5), (int) (GameMap.height*.755), (int) (GameMap.width*.5), 
					(int) (GameMap.height*.245));
		}
		if(playerUsedMove) {
			g.drawString(GameMap.battle.player.currentPokemon().name + " used " + 
			GameMap.battle.movesGrid.movesArray[GameMap.battle.movesGrid.selectedRow][GameMap.battle.movesGrid.selectedCol]
					.name + "!", GameMap.width/15, (int) (GameMap.height*.85));
		}
		if(playerMoveEffects) {
			g.drawString(GameMap.battle.movesGrid.movesArray[GameMap.battle.movesGrid.selectedRow]
					[GameMap.battle.movesGrid.selectedCol].moveEffects(), GameMap.width/15, (int) (GameMap.height*.85));
		}
		if(opponentUsedMove) {
			g.drawString(GameMap.battle.opponentPokemon().name + " used " + 
					opponentMove.name + "!", GameMap.width/15, (int) (GameMap.height*.85));
		}
		if(opponentMoveEffects) {
			g.drawString(opponentMove.moveEffects(), GameMap.width/15, (int) (GameMap.height*.85));
		}
		if(noItems) {
			g.drawString("You have no items.", GameMap.width/15, (int) (GameMap.height*.85));
		}
		if(noOtherPokemon) {
			g.drawString("You have no other Pokemon.", GameMap.width/15, (int) (GameMap.height*.85));
		}
		if(opponentPokemonFainted) {
			g.drawString(opponent.name + " fainted!", GameMap.width/15, (int) (GameMap.height*.85));
		}
		if(playerPokemonFainted) {
			g.drawString(player.currentPokemon().name + " fainted! git gud (Game Over).", GameMap.width/15, (int) (GameMap.height*.85));
		}
	}
}
