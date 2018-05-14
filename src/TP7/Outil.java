package TP7;

import Item.ChangeItems;
import Item.Item;

public class Outil extends Item implements ChangeItems {

	public Outil(String nom, int frequence, int maxUtilisation) {
		super(nom, frequence, maxUtilisation);
	}

	public Item genAlea() {
		if (super.seraGenere()){
			return new Outil(this.getNom(), this.getFrequence(), this.getMaxUtilisation());
		}
		else {
			return null;
		}
	}

	@Override
	public void utiliser(Modifiable item) {
		if(this.getRestUtilisation() > 0) {
			item.modifier();
			this.baisserUtilisation(1);

		}
	}
}
