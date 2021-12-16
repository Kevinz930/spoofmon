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
import gameobjects.pokemon.moves.StarfishStare;


public class Patrickmon extends Pokemon implements Cloneable{
	protected int dx = 0, dy = 0;
	protected int steps;
	protected boolean moving = false;
	Image imgLeft, imgRight, imgUp, imgDown;
	
	public Patrickmon() {
		super();
		try { 
			URL url = getClass().getResource("patrickmon.png");
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		originalHealth = 18;
		originalAttack = 52;
		originalDefense = 14;
		originalSpeed = 40;
		name = "Patrickmon";
		type = "Water";
		resetStats();
		moves = new ArrayList<>(Arrays.asList(new AquaJet(), new BubbleBeam(), 
				new Jellyfishing(), new StarfishStare()));
	}
	
	public void drawOpponent(Graphics g) {
		g.drawImage(img, (int)(GameMap.width*.67), (int)(GameMap.height*.01),
				(int)(GameMap.width/4),(int)(GameMap.height/2.1), null);
	}
}
