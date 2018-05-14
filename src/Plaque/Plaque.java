package Plaque;

import Item.ItemEquipable;
import TP7.Pokemon;

public abstract class Plaque extends ItemEquipable {

	private String type;
	private static int pourcentageEnplus=10;
	
	public Plaque(String nom, int frequence,String type) {
		super(nom, frequence);
		this.type=type;

	}
	public boolean estCompatible(Pokemon p ){
		boolean estCompatible = false;
		if(p.getType()==this.type)
			estCompatible=true;
		return estCompatible;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static int getPourcentageEnplus() {
		return pourcentageEnplus;
	}

	public static void setPourcentageEnplus(int pourcentageEnplus) {
		Plaque.pourcentageEnplus = pourcentageEnplus;
	}



}
