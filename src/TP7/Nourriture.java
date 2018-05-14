package TP7;

import Item.Item;

public class Nourriture extends Item implements Utilisable {
	private int apport;
	private String[] compatibilites;
	public Nourriture(String nom, int frequence, int apport, String[] compatibilites) {
		super(nom, frequence, 1);	
		this.apport=apport;
		this.compatibilites = compatibilites;
	}
	
	public boolean estCompatible (String type) {
		for (int i = 0; i < this.compatibilites.length; i++) {
			if (type.equals(this.compatibilites[i]))
				return true;
		}
		return false;
	}
	
	public int getApport() {
		return apport;
	}
	
	public String[] getCompatibilites() {
		return compatibilites;
	}
	
	@Override
	public String toString() {
		String compatibilites = this.compatibilites[0];

		for (int i = 1; i < this.compatibilites.length; ++i) {
			compatibilites = compatibilites + ", " + this.compatibilites[i];
		}
		
		return (this.getNom() + " : " + this.getFrequence() + ", " + this.apport + ", " + this.getRestUtilisation() + "/" + this.getMaxUtilisation() + ", types compatibles : " + compatibilites);
	}
	
	@Override
	public void utiliser(Joueur j, int indexPokemon) {
		Pokemon mangeur = j.getPokemons()[indexPokemon];
		if(indexPokemon < j.getPokemons().length && indexPokemon >= 0 && j.getPokemons()[indexPokemon] != null) {
			if (estCompatible(mangeur.getType()) == true) {
				if (mangeur.getAppetit() >= this.apport) {
					mangeur.setAppetit(mangeur.getAppetit() - this.apport);
				}
				else {
					mangeur.setAppetit(0);
				}
				this.baisserUtilisation(1);
			}
			else {
				System.out.println("Ce pokemon ne peut pas manger cette ingrédient car il n'est pas compatible.");
			}
		}
	}

	@Override
	public Item genAlea() {
		if (super.seraGenere()){
			return new Nourriture(this.getNom(), this.getFrequence(), this.apport, this.compatibilites);
		}
		else {
			return null;
		}
	}
}
