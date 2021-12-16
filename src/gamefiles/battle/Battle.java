package gamefiles.battle;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import gamefiles.GameLauncher;
import gamefiles.GameMap;
import gameobjects.*;
import gameobjects.trainers.*;
import gameobjects.pokemon.*;
import gameobjects.pokemon.moves.Moves;

public class Battle {
	JTextArea textArea;
	public Image background;
	public ActionGrid actionGrid;
	public MovesGrid movesGrid;
	public Trainer player;
	Pokemon opponent;
	public boolean newBattle = true;
	Moves opponentMove;
	
	public boolean playerUsedMove;
	public boolean playerMoveEffects;
	public boolean opponentUsedMove;
	public boolean opponentMoveEffects;
	public boolean opponentPokemonFainted;
	public boolean playerPokemonFainted;
	public boolean noItems;
	public boolean noOtherPokemon;
	
	public Battle() {	
		player = GameMap.player();
		player.setCurrentPokemon(0);
		actionGrid = new ActionGrid();
		movesGrid = new MovesGrid();
		for(int x = 0; x < player.party.size(); x++) {
			player.party.get(x).resetStats();
		}
	}
	
	public void playerTurn() {
		movesGrid.active = false;
		actionGrid.setActive();
	}
	
	public void opponentTurn() {
		//define in subclass
	}
	
	public void spaceKey() {
	}
	
	public void checkPlayerPokemonFainted() {
		if(player.currentPokemon().health <= 0) {
			playerPokemonFainted = true;
		}
	}
	
	public void checkOpponentFainted() {
		if(opponentPokemon().health <= 0) {
			opponentPokemonFainted = true;
		}
	}
	
	public void escapeKey() {
		if(movesGrid.active()) {
			movesGrid.active = false;
			actionGrid.setActive();
		}
		else if(noItems) {
			noItems = false;
			actionGrid.setActive();
		}
		else if(noOtherPokemon) {
			noOtherPokemon = false;
			actionGrid.setActive();
		}
	}
	
	public Pokemon opponentPokemon() {
		//define in subclass
		return null;
	}
	
	public void setTextArea() {
		textArea = new JTextArea(3, 10);
	    textArea.setText("test test test");
	    textArea.setWrapStyleWord(true);
	    textArea.setLineWrap(true);
	    textArea.setOpaque(false);
	    textArea.setEditable(true);
	    textArea.setFocusable(false);
	    textArea.setFont(UIManager.getFont(new Font("TimesRoman", Font.PLAIN, 35)));
	    GameLauncher.gameFrame.getContentPane().add(textArea, BorderLayout.CENTER);;
	}
	
	public void draw(Graphics g){
		try {
			URL url = getClass().getResource("background.png");
			background = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawImage(background, 0, 0, GameMap.width, GameMap.height, null);
		g.setColor(Color.BLACK);
		g.drawString(player.currentPokemon().name, (int)(GameMap.width*.595), (int)(GameMap.height*.575));
		g.setColor(Color.GREEN);
		if((double)player.currentPokemon().health/(double)player.currentPokemon().originalHealth <= .5)
			g.setColor(Color.ORANGE);
		if((double)player.currentPokemon().health/(double)player.currentPokemon().originalHealth <= .25)
			g.setColor(Color.RED);
		g.fillRect((int)(GameMap.width*.77), (int)(GameMap.height*.61), 
				(int)((GameMap.width*.197)*((double)player.currentPokemon().health/(double)player.currentPokemon().
				originalHealth)), (int)(GameMap.height*.021));
	}
}
