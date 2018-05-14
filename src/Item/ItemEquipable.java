package Item;

import TP7.Pokemon;

public class ItemEquipable extends Item {
	
	private Pokemon pokemonEquipe;
	// Les items équipable pourront être des rollers, des chapeaux, une cape.

	public ItemEquipable(String nom, int frequence, int maxUtilisation, Pokemon pokemonEquipe) {
		super(nom, frequence, maxUtilisation);
		this.pokemonEquipe = pokemonEquipe;
	}

	public ItemEquipable(String nom, int frequence) {
		super(nom, frequence,(int)Integer.MAX_VALUE);
		this.pokemonEquipe=null;
	}

	@Override
	public ItemEquipable genAlea() {
		return new ItemEquipable(getNom(), getFrequence());
	}

	@Override
	public void baisserUtilisation(int difference) {
		// Ne descend pas;
	}

	@Override
	public void monterUtilisation(int difference) {
		// ne peut pas monter
	}

	@Override
	public void resetUtilisation() {
		// ne bouge pas
	}
	public void equipe(Pokemon p){
		if (this.pokemonEquipe==null){
		this.pokemonEquipe=p;
		p.attribue(this);
		System.out.println("votre Item a bien ete equipe");
		}
		else{
			System.out.println("Pokemon deja equipe");
		}
	}
	public void desequipe(){
		if (this.pokemonEquipe!=null){
			this.pokemonEquipe.retirer();
			this.pokemonEquipe=null;
			System.out.println("votre Item a ete desequipe");
		}
		else{
			System.out.println("aucun Pokemon equipe");
		}
	}

	public Pokemon getPokemonEquipe() {
		return pokemonEquipe;
	}

	public void setPokemonEquipe(Pokemon pokemonEquipe) {
		this.pokemonEquipe = pokemonEquipe;
	}

}
