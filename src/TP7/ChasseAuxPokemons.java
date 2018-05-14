package TP7;
import java.util.ArrayList;
import java.util.Arrays;

import Attaque.Attaque;
import Attaque.AttaqueBulle;
import Attaque.AttaqueCoupDeTete;
import Attaque.AttaqueEnfer;
import Attaque.AttaqueFeinte;
import Attaque.AttaqueMorsure;
import Attaque.AttaquePistoleEau;
import Attaque.AttaqueTackle;
import Attaque.AttaqueTornadeFeuilles;
import Item.Item;
import Item.ItemEquipable;
import Item.ItemVetement;
import Plaque.PlaqueAtk;

public class ChasseAuxPokemons {

	public static void main(String[] args) {

		final Pokemon piplup = new Pokemon("Piplup", "EAU", 5, false, null, null, 51, 53, 61, 56, 0, 0, new ArrayList<Attaque>(Arrays.asList(new AttaqueTackle(), new AttaqueMorsure(), new AttaquePistoleEau(), new AttaqueEnfer())));
		final Pokemon rowlet = new Pokemon("Rowlet", "PLANTE", 10, true, null, null, 55, 55, 50, 55, 0, 0, new ArrayList<Attaque>(Arrays.asList(new AttaqueMorsure(), new AttaqueFeinte(), new AttaqueTornadeFeuilles())));
		final Pokemon totodile = new Pokemon("Totodile", "EAU", 8, false, null, null, 65, 64, 44, 48, 0, 0, new ArrayList<Attaque>(Arrays.asList(new AttaqueBulle(), new AttaqueCoupDeTete())));
		 
		final Joueur Adrien = new Joueur("Dupont", "Jean", 20, new Pokemon[5], new Item[15]);
		final Joueur Louis = new Joueur("Martin", "Gabrielle", 18, new Pokemon[5], new Item[15]);
				
		System.out.println(piplup);
		Adrien.capturer(piplup);
		System.out.println(piplup);
		
		//On renomme piplup en pascal
		Adrien.nommer(piplup, "Pascal");
		System.out.println(piplup);
		
		Adrien.nommer(piplup, "Emmanuel");
		System.out.println(piplup);

		Adrien.donner(piplup, Louis);

		Adrien.capturer(rowlet);
		Adrien.nommer(rowlet, "Soizic");
		
		//On test le fonctionnement de nos échanges
		Adrien.echanger(rowlet, Louis, piplup);

		// Test de la nourriture
		final Nourriture tartiflette = new Nourriture("tartiflette", 30, 35,new String[] {"DRAGON", "FEU", "COMBAT", "EAU", "ELECTRIQUE"});
		final Nourriture ratatouille = new Nourriture("ratatouille", 30, 10, new String[] {"PLANTE", "EAU", "VOL", "FEU", "NORMAL", "ELECTRIQUE", "COMBAT"}); 
		
		final Gourmandise barreChocolatee = new Gourmandise("Barre Chocolatee", 10, 20, new String[] {"DRAGON", "FEU", "COMBAT", "EAU", "ELECTRIQUE"}, 5, 7);
		final PotionMagique mojito = new PotionMagique("mojito", 2);
		
		final Jouet balle = new Jouet("Balle", 20, 30, 10, 15, 5);
		final Outil Marteau = new Outil("Baguette", 10, 5);
		
		System.out.println(balle);
		System.out.println(Marteau);
		Adrien.addItem(Marteau);
		Adrien.addItem(balle);
		System.out.println(Adrien.afficherSacItems());
		System.out.println(Adrien.afficherPokemons());
		Adrien.donnerItem(0,1);
		System.out.println(Adrien.afficherSacItems());
		Adrien.modifierItem(0, 1);
		System.out.println(Adrien.afficherSacItems());
		
		// Tests des ajouts originaux
		/*final ItemVetement cape = new ItemVetement("Cape", 30, 5,"Bleu");
		System.out.println(cape);
		
		piplup.attribue(cape);
		System.out.println(piplup.getSonItem().getNom());
		
		final ItemEquipable roller = new ItemEquipable("Roller", 30, 2,piplup);
		System.out.println(roller);
		final PlaqueAtk plaqueFeu = new PlaqueAtk("plaque feu", 30," feu");
		rowlet.attribue(plaqueFeu);
		rowlet.retirer();*/
	}
}