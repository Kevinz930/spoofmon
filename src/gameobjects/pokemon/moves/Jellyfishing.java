package gameobjects.pokemon.moves;

import gamefiles.GameMap;

public class Jellyfishing extends Moves{
	
	public Jellyfishing() {
		super();
		name = "Jellyfishing";
		type = "Normal";
		power = 0;
		pp = 15;
		originalPP = 15;
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
		return attacker.name + "'s attack rose by two stages.";
	}

}
