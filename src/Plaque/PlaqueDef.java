package Plaque;

import TP7.Pokemon;

public class PlaqueDef extends Plaque {

	public PlaqueDef(String nom, int frequence, String type) {
		super(nom, frequence, type);
	}
	
	
	@Override
	public void equipe(Pokemon p) {
		super.equipe(p);
		if (this.estCompatible(p)){
			p.setDefense((int) (p.getDefense()*(1+(super.getPourcentageEnplus()/100))));
		}
	}

	@Override
	public void desequipe() {		
		if (this.estCompatible(this.getPokemonEquipe())){
			this.getPokemonEquipe().setDefense((int) (this.getPokemonEquipe().getDefense()*(1-(super.getPourcentageEnplus()/100))));
		}
		super.desequipe();
	}
	@Override
	public PlaqueDef genAlea() {
		return new PlaqueDef(this.getNom(), this.getFrequence(), this.getType());
	}

}
