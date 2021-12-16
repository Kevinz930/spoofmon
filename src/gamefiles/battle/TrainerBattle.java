package gamefiles.battle;

import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import gamefiles.GameMap;
import gameobjects.MovableObject;
import gameobjects.pokemon.Pokemon;
import gameobjects.pokemon.moves.Moves;
import gameobjects.trainers.Trainer;

public class TrainerBattle extends Battle{
	Trainer opponentTrainer;
	
	public TrainerBattle(Trainer opponentTrainer) {
		this.opponentTrainer = opponentTrainer;
		opponentTrainer.setCurrentPokemon(0);
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		opponentTrainer.currentPokemon().draw(g);
	}
	
	public Pokemon enemyPokemon() {
		return opponentTrainer.currentPokemon();
	}
	
	public void damageOpponent(int damage) {
		opponentTrainer.currentPokemon().setHealth(opponent.health() - damage);
	}

}
