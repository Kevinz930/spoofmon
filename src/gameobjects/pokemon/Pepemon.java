package gameobjects.pokemon;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import gamefiles.*;
import gameobjects.pokemon.moves.Growl;
import gameobjects.pokemon.moves.Growth;
import gameobjects.pokemon.moves.Tackle;
import gameobjects.pokemon.moves.VineWhip;

public class Pepemon extends Pokemon{
	protected int dx = 0, dy = 0;
	protected int steps;
	protected boolean moving = false;
	Image imgLeft, imgRight, imgUp, imgDown;
	
	public Pepemon() {
		super();
		try { 
			URL url = getClass().getResource("pepemon.png");
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		originalHealth = 39;
		originalAttack = 52;
		originalDefense = 43;
		originalSpeed = 65;
		name = "Pepemon";
		type = "Grass";
		resetStats();
		moves = new ArrayList<>(Arrays.asList(new Tackle(), new VineWhip(), 
				new Growl(), new Growth()));
	}
	
	public void drawPlayer(Graphics g) {
		g.drawImage(img, (int)(GameMap.width*.15), (int)(GameMap.height*.27), 
				(int)(GameMap.width/4),(int)(GameMap.height/2.1), null);
	}
}
