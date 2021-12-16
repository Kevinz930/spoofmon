package gameobjects.pokemon.moves;


public class AquaJet extends Moves{
	
	public AquaJet() {
		super();
		name = "Aqua Jet";
		type = "Water";
		power = 40;
		pp = 20;
		originalPP = 20;
	}
	
	public void activate() {
		super.activate();
	}
	
	public String moveEffects() {
		return defender.name + " took " + calculateDamage() + " damage.";
	}
}