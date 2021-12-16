package gameobjects.pokemon.moves;
import gamefiles.GameMap;
import gameobjects.*;
import gameobjects.pokemon.Pokemon;
public class Moves {
	public int power, pp, originalPP, damage, accuracy;
	public String name, type;
	public Pokemon attacker, defender;
	
	public Moves() {
	}
	
	public void activate() {
		if(GameMap.battle.movesGrid.active) {
			attacker = GameMap.battle.player.currentPokemon();
			defender = GameMap.battle.opponentPokemon();
		} else {
			attacker = GameMap.battle.opponentPokemon();
			defender = GameMap.battle.player.currentPokemon();
		}
		damage();
	}
	
	public int calculateDamage() {
		if(power == 0) {
			return 0;
		}
		int damage = (int) (( ((( (2*attacker.level)/5) + 2) * power * (attacker.attack/defender.defense)
														/50) 							 + 2 ) *calculateEffectiveness());
		if(damage < 0)
			return 0;
		return damage;
	}
	
	public void damage() {
		if(pp <= 0) {
			GameMap.battle.movesGrid.setActive();
			return;
		}
		defender.health -= calculateDamage();
		pp--;
	}
	
	public double calculateEffectiveness() {
		if(type.equals("Grass") && GameMap.battle.opponentPokemon().type.equals("Fire"))
			return .5;
		if(type.equals("Fire") && GameMap.battle.opponentPokemon().type.equals("Grass"))
			return 2;
		if(type.equals("Grass") && GameMap.battle.opponentPokemon().type.equals("Water"))
			return 2;
		if(type.equals("Water") && GameMap.battle.opponentPokemon().type.equals("Fire"))
			return .5;
		return 1;
	}
	
	public String moveEffects() {
		//define in subclass
		return null;
	}
	
	public int pp() {
		return pp;
	}
	
}
