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
import gameobjects.pokemon.moves.AquaJet;
import gameobjects.pokemon.moves.BubbleBeam;
import gameobjects.pokemon.moves.Jellyfishing;
import gameobjects.pokemon.moves.Splash;
import gameobjects.pokemon.moves.StarfishStare;

public class Magikarp extends Pokemon implements Cloneable{
	protected int dx = 0, dy = 0;
	protected int steps;
	protected boolean moving = false;
	Image imgLeft, imgRight, imgUp, imgDown;
	
	public Magikarp() {
		super();
		try { 
			URL url = getClass().getResource("magikarp.png");
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		originalHealth = 15;
		originalAttack = 25;
		originalDefense = 10;
		originalSpeed = 30;
		name = "Magikarp";
		type = "Water";
		resetStats();
		moves = new ArrayList<>(Arrays.asList(new Splash(), new Splash(), 
				new Tackle(), new Tackle()));
	}
	
	public void drawOpponent(Graphics g) {
		g.drawImage(img, (int)(GameMap.width*.55), (int)(GameMap.height*-.14),
				(int)(GameMap.width/2),(int)(GameMap.height/1.2), null);
	}
}
