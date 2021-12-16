package gameobjects.pokemon.moves;

public class StarfishStare extends Moves{
	
	public StarfishStare() {
		super();
		name = "Starfish Stare";
		type = "Normal";
		power = 0;
		pp = 30;
		originalPP = 30;
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
