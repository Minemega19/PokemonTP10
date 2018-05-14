package Item;

import TP7.Pokemon;

public class ItemVetement extends ItemEquipable {

	private int pourcentageSatisfaction;
	private String couleur;
	// Les vêtements augmentent la satisfaction des Pokemons
	
	public ItemVetement(String nom, int frequence,int pourcentageSatisfaction,String couleur) {
		super(nom, frequence);
		this.pourcentageSatisfaction = pourcentageSatisfaction;
		this.couleur=couleur;
	}

	@Override
	public ItemVetement genAlea() {
		return new ItemVetement(getNom(), getFrequence(), this.pourcentageSatisfaction,this.couleur);
	}

	@Override
	public void equipe(Pokemon p) {
		super.equipe(p);
		p.setSatisfaction(p.getSatisfaction()*(1+(this.pourcentageSatisfaction/100)));
	}

	@Override
	public void desequipe() {
		this.getPokemonEquipe().setSatisfaction(this.getPokemonEquipe().getSatisfaction()*(1-(this.pourcentageSatisfaction/100)));
		super.desequipe();
	}

	public int getPourcentageSatisfaction() {
		return pourcentageSatisfaction;
	}

	public void setPourcentageSatisfaction(int pourcentageSatisfaction) {
		this.pourcentageSatisfaction = pourcentageSatisfaction;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

}
