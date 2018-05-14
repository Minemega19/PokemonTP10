package TP7;

import Item.Item;

public class Jouet extends Item implements Utilisable, Modifiable {
	private int apportAppetit;
	private int apportSatisfaction;
	private int apportLoyaute;
	
	public Jouet(String nom, int frequence, int maxUtilisation, int apportAppetit, int apportSatisfaction, int apportLoyaute) {
		super(nom, frequence, maxUtilisation);
		this.apportAppetit=apportAppetit;
		this.apportSatisfaction=apportSatisfaction;
		this.apportLoyaute=apportLoyaute;
	}

	@Override
	public void modifier() {
		this.setNom(this.getNom() + " magique");
		this.apportAppetit += 20;
		this.apportSatisfaction += 10;
		this.apportLoyaute += 15;
		this.resetUtilisation();
	}

	@Override
	public void utiliser(Joueur j, int indexPokemon) {
		Pokemon p = j.getPokemons()[indexPokemon];
		if(indexPokemon < j.getPokemons().length && indexPokemon >= 0 && j.getPokemons()[indexPokemon] != null) {
			if(this.getRestUtilisation() > 0) {
				p.monteAppetit(this.apportAppetit);
				p.monteSatisfaction(this.apportSatisfaction);
				this.baisserUtilisation(1);
				p.monteLoyaute(this.apportLoyaute);
			}
			else {
				System.out.println("Vous ne pouvez plus utiliser ce jouet.");
			}
		}
		else {
			System.out.println("Erreur, pokemon inexistant ou mauvais index séléctionner.");
		}
	}

	@Override
	public Item genAlea() {
		if (super.seraGenere()){
			return new Jouet(this.getNom(), this.getFrequence(), this.getMaxUtilisation(), this.apportAppetit, this.apportSatisfaction, this.apportLoyaute);
		}
		else {
			return null;
		}
	}
	
	public String toString() {
		return (this.getNom() + " : " + this.getFrequence() + ", " + this.apportAppetit + ", " + this.apportSatisfaction + ", " + this.apportLoyaute + ", " + this.getRestUtilisation() + "/" + this.getMaxUtilisation());
	}
	
	
}
