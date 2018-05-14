package TP7;

public class Gourmandise extends Nourriture {
		private int apportLoyaute;
		private int apportSatisfaction;
		
	public Gourmandise(String nom, int frequence, int apport, String[] compatibilites, int apportLoyaute, int apportSatisfaction) {
		super(nom, frequence, apport, compatibilites);
		this.apportLoyaute=apportLoyaute;
		this.apportSatisfaction=apportSatisfaction;
	}
	
	public String toString() {
			return (super.toString() + ". Elle augmente la satisfaction de " + this.apportSatisfaction + " et la loyauté de " + this.apportLoyaute);
	}
	
	public Gourmandise genAlea() {
		if (Math.round(100 * Math.random()) < this.getFrequence()) {
			return new Gourmandise(this.getNom(), this.getFrequence(), this.getApport(), this.getCompatibilites(),  this.apportLoyaute, this.apportSatisfaction);
		}
		else {
			return null;
		}
	}
	
	@Override
	public void utiliser(Joueur j, int indexPokemon) {
		Pokemon mangeur = j.getPokemons()[indexPokemon];
		if(indexPokemon < j.getPokemons().length && indexPokemon >= 0 && j.getPokemons()[indexPokemon] != null) {
			if (estCompatible(mangeur.getType()) == true) {
				if (mangeur.getAppetit() >= this.getApport()) {
					mangeur.setLoyaute(mangeur.getLoyaute()+this.apportLoyaute);
					mangeur.setSatisfaction(mangeur.getSatisfaction()+this.apportSatisfaction);	
				}
				else {
					mangeur.setAppetit(0);
				}
				this.baisserUtilisation(1);
			}
			else {
				System.out.println("Ce pokemon ne peut pas manger cette gourmandise car il n'est pas compatible.");
			}
		}
	}

}