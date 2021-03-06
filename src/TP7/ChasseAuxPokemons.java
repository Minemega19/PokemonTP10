package TP7;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

public class ChasseAuxPokemons {

	public static void main(String[] args) {
		
		final Map<String, Attaque> mappeAttaques = new HashMap<>();
		mappeAttaques.put("bulle", new AttaqueBulle());
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
		
		//On test le fonctionnement de nos �changes
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
		
		final ArrayList<Pokemon> pokemonList = new ArrayList<>();
		try(FileReader lecteur = new FileReader("src/TP7/text.txt")){
			Scanner s = new Scanner(lecteur);
			while(s.hasNext()) {
				String name = s.next();
				String type = s.next();
				int niveau = s.nextInt();
				boolean diurne = s.nextBoolean();
				int attaque = s.nextInt();
				int defense = s.nextInt();
				int attaqueSpeciale = s.nextInt();
				int defenseSpeciale = s.nextInt();
				ArrayList<Attaque> sesAttaques = new ArrayList<>();
				String nomAttaque = s.next();
				while(! nomAttaque.equals("END")) {
					sesAttaques.add(mappeAttaques.get(nomAttaque).genAttaque());
					nomAttaque = s.next();
				}
				Attaque[] sesAttaquesTableau = new Attaque[sesAttaques.size()];
				for(int i = 0; i<sesAttaques.size(); i++) {
					sesAttaquesTableau[i] = sesAttaques.get(i);
				}
				//pokemonList.add(new Pokemon(nom, type, niveau, diurne, nomDonne, monJoueur, appetit, satisfaction, loyaute,attack,defense,speAttack,speDefense, hp,frequency,sesAttaques, sonItem));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
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