package gameobjects.pokemon;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import gamefiles.*;
import gameobjects.pokemon.moves.Ember;
import gameobjects.pokemon.moves.Growl;
import gameobjects.pokemon.moves.Growth;
import gameobjects.pokemon.moves.Tackle;
import gameobjects.pokemon.moves.VineWhip;

public class Hotdogmon extends Pokemon implements Cloneable{
	protected int dx = 0, dy = 0;
	protected int steps;
	protected boolean moving = false;
	Image imgLeft, imgRight, imgUp, imgDown;
	
	public Hotdogmon() {
		super();
		try { 
			URL url = getClass().getResource("hotdogmon.png");
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		originalHealth = 30;
		originalAttack = 45;
		originalDefense = 20;
		originalSpeed = 56;
		name = "Hotdogmon";
		type = "Fire";
		resetStats();
		moves = new ArrayList<>(Arrays.asList(new Tackle(), new Ember(), 
				new Growl(), new Growth()));
	}
	
	public void drawOpponent(Graphics g) {
		g.drawImage(img, (int)(GameMap.width*.67), (int)(GameMap.height*.01),
				(int)(GameMap.width/4),(int)(GameMap.height/2.1), null);
	}
}
