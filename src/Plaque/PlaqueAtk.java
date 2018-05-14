package Plaque;

import TP7.Pokemon;

public class PlaqueAtk extends Plaque{

	public PlaqueAtk(String nom, int frequence, String type) {
		super(nom, frequence, type);
	}
	@Override
	public void equipe(Pokemon p) {
		super.equipe(p);
		if (this.estCompatible(p)){
			p.setAttack((int) (p.getAttack()*(1+(super.getPourcentageEnplus()/100))));
		}
	}

	@Override
	public void desequipe() {		
		if (this.estCompatible(this.getPokemonEquipe())){
			this.getPokemonEquipe().setAttack((int) (this.getPokemonEquipe().getAttack()*(1-(super.getPourcentageEnplus()/100))));
		}
		super.desequipe();
	}
	@Override
	public PlaqueAtk genAlea() {
		return new PlaqueAtk(this.getNom(), this.getFrequence(), this.getType());
	}


}
