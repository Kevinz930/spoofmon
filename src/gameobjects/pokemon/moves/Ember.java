package gameobjects.pokemon.moves;

import gameobjects.pokemon.Pokemon;

public class Ember extends Moves{
	
	public Ember() {
		super();
		name = "Ember";
		type = "Fire";
		power = 40;
		pp = 25;
		originalPP = 25;
	}

	public void activate() {
		super.activate();
	}
	
	public String moveEffects() {
		return defender.name + " took " + calculateDamage() + " damage.";
	}
	
}
