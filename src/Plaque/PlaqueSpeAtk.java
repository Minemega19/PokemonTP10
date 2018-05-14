package Plaque;

import TP7.Pokemon;

public class PlaqueSpeAtk extends Plaque {

	public PlaqueSpeAtk(String nom, int frequence, String type) {
		super(nom, frequence, type);
	}
	@Override
	public void equipe(Pokemon p) {
		super.equipe(p);
		if (this.estCompatible(p)){
			p.setSpeAttack((int) (p.getSpeAttack()*(1+(super.getPourcentageEnplus()/100))));
		}
	}

	@Override
	public void desequipe() {		
		if (this.estCompatible(this.getPokemonEquipe())){
			this.getPokemonEquipe().setSpeAttack((int) (this.getPokemonEquipe().getSpeAttack()*(1-(super.getPourcentageEnplus()/100))));
		}
		super.desequipe();
	}
	@Override
	public PlaqueSpeAtk genAlea() {
		return new PlaqueSpeAtk(this.getNom(), this.getFrequence(), this.getType());
	}

}
