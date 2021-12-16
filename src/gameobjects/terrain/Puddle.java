package gameobjects.terrain;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import gamefiles.GameMap;
import gamefiles.battle.PokemonBattle;
import gameobjects.pokemon.Hotdogmon;
import gameobjects.pokemon.Magikarp;
import gameobjects.pokemon.Patrickmon;

public class Puddle extends TerrainObject{
	
	public Puddle(int r, int c) {
		super(r, c);
		try {
			URL url = getClass().getResource("puddle.png");
			img = ImageIO.read(url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		passable = true;
		if(floor == GameMap.player.floor && row == GameMap.player().row() && col == GameMap.player().col()) {
			containsPlayer = true;
		}
	}
	
	public void tick() {
		checkForPlayer();
	}
	
	public void checkForPlayer() {
		if(containsPlayer == false) {
			if(floor == GameMap.player.floor && row == GameMap.player().row() && col == GameMap.player().col() && 
					!GameMap.player().moving()) {
				double x = Math.random();
				if(x < .07) {
					GameMap.battle = new PokemonBattle(new Magikarp());
				} else if(x < .1){
					GameMap.battle = new PokemonBattle(new Patrickmon());
				}
					
				containsPlayer = true;
			}
		}
		if(floor != GameMap.player.floor || row != GameMap.player().row() ||  col != GameMap.player().col())
			containsPlayer = false;
	}
	
}
