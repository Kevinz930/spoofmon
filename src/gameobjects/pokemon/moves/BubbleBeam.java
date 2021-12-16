package gameobjects.pokemon.moves;


public class BubbleBeam extends Moves{
	
	public BubbleBeam() {
		super();
		name = "Bubble Beam";
		type = "Water";
		power = 65;
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