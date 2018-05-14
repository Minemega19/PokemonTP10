package Attaque;
import TP7.Pokemon;

public abstract class Attaque {
	private String nom;
	private String[] typeCompatible;
	private int puissance;
	private int precision;
	private int repetition;
	private int repetitionRest;
	private static String[] ALL_TYPES = {"ACIER", "COMBAT", "DRAGON", "EAU", "ELECTRIK", "FEE", "FEU", "GLACE", "INSECTE", "NORMAL", "PLANTE", "POISON", "PSY", "ROCHE", "SOL", "SPECTRE", "TENEBRES", "VOL"};
	public Attaque(String nom, String[] typeCompatible, int puissance, int precision, int repetition) {
		this.nom = nom;
		this.typeCompatible = typeCompatible;
		this.puissance = puissance;
		this.precision = precision;
		this.repetition = repetition;
		this.repetitionRest=repetition;
	}
	public abstract Attaque genAttaque();
	public Attaque(String nom, int puissance, int precision, int repetition) {
		this(nom, ALL_TYPES,puissance, precision, repetition);
	}

	public void resetRepetitions() {
		this.repetitionRest = this.repetition;
	}
	
	public void baisseRepetitions() {
		this.repetitionRest = this.repetitionRest-1;
		if (this.repetitionRest < 0) {
			this.repetitionRest = 0;
		}
	}
	
	public String toString() {
		String resultat = this.nom + " : " + this.puissance + ", " + this.precision + ", " + this.repetition + ", " + this.repetitionRest + ", compatible avec ";
		if (this.typeCompatible.equals(ALL_TYPES)) {
			resultat += "tous types de Pokemon.";
		}
		else {
			for (int i = 0; i < this.typeCompatible.length; i++) {
				resultat += "type " + this.typeCompatible[i] + ", ";
			}
		}
		return resultat;
	}
	
	public abstract void utiliser(Pokemon attaquant, Pokemon victime);
	
	public abstract boolean estCompatible(Pokemon p);
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String[] getType() {
		return typeCompatible;
	}

	public void setType(String[] type) {
		this.typeCompatible = typeCompatible;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public int getRepetition() {
		return repetition;
	}

	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}

	public int getRepetitionRest() {
		return repetitionRest;
	}

	public void setRepetitionRest(int repetitionRest) {
		this.repetitionRest = repetitionRest;
	}

	public String[] getTypeCompatible() {
		return typeCompatible;
	}

	public void setTypeCompatible(String[] typeCompatible) {
		this.typeCompatible = typeCompatible;
	}
	
	

}
