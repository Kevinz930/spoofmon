package gameobjects.pokemon.moves;

import gamefiles.GameMap;
import gameobjects.pokemon.Pokemon;

public class Growl extends Moves{
	
	public Growl() {
		super();
		name = "Growl";
		type = "Normal";
		power = 0;
		pp = 40;
		originalPP = 40;
	}
	
	public void activate() {
		super.activate();
		if(pp <= 0 || defender.attackStage <= -6) {
			return;
		}
		defender.attack = (int) (defender.attack * .5);
		defender.attackStage--;
		pp--;
	}
	
	public String moveEffects() {
		return defender.name + "'s attack fell by one stage.";
	}
}
