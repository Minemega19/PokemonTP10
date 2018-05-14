package TP7;

import java.util.TreeSet;

public class Pokedex {
	private TreeSet<Integer> setPokemon;
	
	public Pokedex(){
		setPokemon = new TreeSet<Integer>();
	}
	
	public void rencontrer(Pokemon p){
		this.setPokemon.add(p.getNumeroPokedex());//pas besoins de gerer les doublons vue que c est un treeSet
	}
	
	public void rencontrer(Pokemon[] pokemons){
		for(int i = 0 ;i<pokemons.length;i++){
			this.rencontrer(pokemons[i]);
		}
	}
	
	public void Charger(String chemin){
		
	}
	
	public void Sauvegarder(String chemin){
		
	}
}
