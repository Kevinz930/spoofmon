package gameobjects.terrain;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import gameobjects.pokemon.*;
import gamefiles.GameMap;
import gamefiles.battle.Battle;
import gamefiles.battle.PokemonBattle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grass extends TerrainObject{
	public Grass(int r, int c) {
		super(r, c);
		try {
			URL url = getClass().getResource("grass.png");
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		try {
			URL url = getClass().getResource("grasshalf.png");
			drawOverImg = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		passable = true;
		if(floor == GameMap.player.floor && row == GameMap.player().row() && col == GameMap.player().col()) {
			containsPlayer = true;
			drawOver = true;
		}
	}
	
	public void tick() {
		checkForPlayer();
		if(floor == GameMap.player.floor && row == GameMap.player().row() && col == GameMap.player().col() &&
				!(GameMap.player.walkingForward || GameMap.player.walkingBackward || GameMap.player.walkingForward)) {
			drawOver = true;
		} else if(GameMap.player.walkingBackward){
			if(GameMap.player.steps < GameMap.player.steps/5) {
				drawOver = true;
			}
		} else {
			drawOver = false;
		}
	}
	
	public void checkForPlayer() {
		if(containsPlayer == false) {
			if(floor == GameMap.player.floor && row == GameMap.player().row() && col == GameMap.player().col() && 
					!GameMap.player().moving()) {
				double x = Math.random();
				if(x < .1) {
					GameMap.battle = new PokemonBattle(new Hotdogmon());
				} else if(x < 1){
					
				}
					
				containsPlayer = true;
			}
		}
		if(floor != GameMap.player.floor || row != GameMap.player().row() ||  col != GameMap.player().col())
			containsPlayer = false;
	}
}
