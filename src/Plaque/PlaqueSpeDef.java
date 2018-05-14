package Plaque;

import TP7.Pokemon;

public class PlaqueSpeDef extends Plaque{

	public PlaqueSpeDef(String nom, int frequence, String type) {
		super(nom, frequence, type);
	}
	@Override
	public void equipe(Pokemon p) {
		super.equipe(p);
		if (this.estCompatible(p)){
			p.setSpeDefense((int) (p.getSpeDefense()*(1+(super.getPourcentageEnplus()/100))));
		}
	}

	@Override
	public void desequipe() {		
		if (this.estCompatible(this.getPokemonEquipe())){
			this.getPokemonEquipe().setSpeDefense((int) (this.getPokemonEquipe().getSpeDefense()*(1-(super.getPourcentageEnplus()/100))));
		}
		super.desequipe();
	}
	@Override
	public PlaqueSpeDef genAlea() {
		return new PlaqueSpeDef(this.getNom(), this.getFrequence(), this.getType());
	}

}
