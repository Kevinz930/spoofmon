package gameobjects.pokemon.moves;

import gameobjects.pokemon.Pokemon;

public class VineWhip extends Moves{
	
	public VineWhip() {
		super();
		name = "Vine Whip";
		type = "Grass";
		power = 45;
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
