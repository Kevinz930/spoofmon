package gameobjects.pokemon.moves;

public class Splash extends Moves{
	
	public Splash() {
		super();
		name = "Splash";
		type = "Water";
		power = 0;
		pp = 25;
		originalPP = 25;
	}

	public void activate() {
		super.activate();
	}
	
	public String moveEffects() {
		return "Nothing happened...";
	}
	
}
