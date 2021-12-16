package gameobjects.pokemon;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import gameobjects.*;
import gameobjects.pokemon.moves.*;

public class Pokemon extends MovableObject{
	public List<Moves> moves;
	public int health, attack, defense, speed, level, experience = 0;
	public int originalHealth, originalAttack, originalDefense, originalSpeed;
	public int attackStage = 0, defenseStage = 0, speedStage= 0;
	public String name, type;
	
	public Pokemon() {
		super(0, 0);
		level = (int)(floor * ((Math.random()/3) + .85));
		if(level == 0)
			level = 1;
	}
	
	public void drawPlayer(Graphics g) {
	}
	
	public void drawOpponent(Graphics g) {
	}
	
	public void resetStats() {
		health = originalHealth;
		attack = originalAttack;
		defense = originalDefense;
		speed = originalSpeed;
		attackStage = 0;
		defenseStage = 0;
		speedStage = 0;
//		for(Moves x : moves) {
//			x.pp = x.originalPP;
//		}
	}
	
	public int health() {
		return health;
	}
	
	public int level() {
		return level;
	}
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}
}
