package gameobjects.trainers;
import java.util.ArrayList;
import java.util.List;

import gamefiles.*;
import gameobjects.MovableObject;
import gameobjects.pokemon.Pokemon;

public class Trainer extends MovableObject{
	public List<Pokemon> party = new ArrayList<Pokemon>();
	public int currentPokemon;
	
	public Trainer(int r, int c) {
		super(r, c);
	}
	
	public void tick() {
		checkForPlayer();
	}
	
	public void checkForPlayer() {
	}
	
	public Pokemon getPokemon(int x) {
		return party.get(x);
	}
	
	public Pokemon currentPokemon() {
		return party.get(currentPokemon);
	}
	
	public void setCurrentPokemon(int x) {
		currentPokemon = x;
	}

}
