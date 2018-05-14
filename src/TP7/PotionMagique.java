package TP7;

public class PotionMagique extends Nourriture {
	
	public PotionMagique(String nom, int frequence) {
		super(nom, frequence, 1, null);
	}
	
	public String toString() {
		return ("L'ingrédient " + super.getNom() + " apparait a une fréquence de " + super.getFrequence() + " et augmente le niveau de 1.");
	}
	
	public PotionMagique genAlea() {
		if (Math.round(100 * Math.random()) < super.getFrequence()) {
			return new PotionMagique(this.getNom(), this.getFrequence());
		}
		else {
			return null;
		}
	}
	
	@Override
	public void utiliser(Joueur j, int indexPokemon) {
		Pokemon mangeur = j.getPokemons()[indexPokemon];
		if(indexPokemon < j.getPokemons().length && indexPokemon >= 0 && j.getPokemons()[indexPokemon] != null) {
				mangeur.miseANiveau();	
				this.baisserUtilisation(1);
		} else {
			System.out.println("Erreur, indexPokemon non - valide.");
		}
	}
}
