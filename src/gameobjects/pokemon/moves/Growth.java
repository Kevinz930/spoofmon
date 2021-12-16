package gameobjects.pokemon.moves;

import gamefiles.GameMap;
import gameobjects.pokemon.Pokemon;

public class Growth extends Moves{
	
	public Growth() {
		super();
		name = "Growth";
		type = "Normal";
		power = 0;
		pp = 40;
		originalPP = 40;
	}
	
	public void activate() {
		super.activate();
		if(pp <= 0 || attacker.attackStage >= 6) {
			return;
		}
		attacker.attack += attacker.originalAttack * .5;
		attacker.attackStage++;
		pp--;
	}
	
	public String moveEffects() {
		return attacker.name + "'s attack rose by one stage.";
	}

}
