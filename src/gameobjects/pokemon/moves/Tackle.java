package gameobjects.pokemon.moves;

import gamefiles.GameMap;
import gamefiles.battle.PokemonBattle;
import gamefiles.battle.TrainerBattle;
import gameobjects.pokemon.Pokemon;
import gameobjects.trainers.player.Player;

public class Tackle extends Moves{

	public Tackle() {
		super();
		name = "Tackle";
		type = "Normal";
		power = 40;
		pp = 35;
		originalPP = 35;
	}
	
	public void activate() {
		super.activate();
	}
	
	public String moveEffects() {
		return defender.name + " took " + calculateDamage() + " damage.";
	}
}
