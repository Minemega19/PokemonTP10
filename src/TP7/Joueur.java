package TP7;

import Item.ChangeItems;
import Item.Item;

public class Joueur {
	private String nom;
	private String prenom;
	private int age;
	private Pokemon[] mesPokemons;
	private Nourriture[] caisseNourriture;
	private Item[] sacItems;
	private Pokedex pokedex;
	
	public Joueur (String nom, String prenom, int age, Pokemon mesPokemons[], Item[] sacItems) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.mesPokemons = mesPokemons;
		this.caisseNourriture = new Nourriture[10];
		this.sacItems = new Item[15];
		this.pokedex = new Pokedex();
		this.rencontrer(this.mesPokemons);
	}
	
	public boolean verifCaisse() {
		for(int i = 0; i < this.caisseNourriture.length; i++) {
			if (this.caisseNourriture[i] == null) {
				return true;
			}
		}
		return false;
	}
	
	public void ajoutNourriture (Nourriture n) {
		int i = 0;
		if(this.verifCaisse() == true) {
			while (this.caisseNourriture[i] != null) {
				i++;
			}
				this.caisseNourriture[i] = n;
		}
		else {
			System.out.println("Vous n'avez plus de place dans votre caisse de nourriture.");
		}
	}
	
	// methode rend -1 si pas de place ou la place (entre 0 et 9) si on a de la place
	public int premierePlaceLibre() {
		int premierePlace = -1; // =pas de place
		int i = 0;
		
		while (premierePlace == -1 && i<this.caisseNourriture.length) {
			if (null == this.caisseNourriture[i])
				premierePlace = i;
			i++;
		}
		return premierePlace;
	}
	
	public boolean aLaPlace() {
		if (this.premierePlaceLibre() == -1){
			return false;
		}

		return true;
	}
	
	public String afficheCaisse() {
		String contenus = "";
		
		for(int i = 0; i < this.caisseNourriture.length; i++) {
			if (null != this.caisseNourriture[i]) {
				contenus += i + " : " + this.caisseNourriture[i] + "\n";
			}
		}
		if (contenus.equals("")) {
			System.out.println("Caisse vide.");
		}
		return contenus;
	}
	
	public Nourriture[] getCaisseNourriture() {
		return this.caisseNourriture;
	}
	
	public void lacherNourriture (int index) {
		if (index < 0 || index >= this.caisseNourriture.length) {
			System.out.println("Il faut choisir un index entre 0 et " + this.caisseNourriture.length);
		}
		else {
			if (null == this.caisseNourriture[index])
				System.out.println("Rien a lacher la.");
			else
				this.caisseNourriture[index] = null;
		}
	}
	
	public String afficherPokemons() {
		String mesPokemons = "";
		for (int i = 0; i<this.mesPokemons.length; i++) {
			if (null != this.mesPokemons[i]) {
				mesPokemons += i + " : " + this.mesPokemons[i] + "\n";
			}
		}
		return mesPokemons;
	}
	
	public void regarderPokemon(Pokemon p) {
		boolean regarde = false;
		int i = 0;
		
		while (!regarde && i < this.mesPokemons.length) {
			if (p == this.mesPokemons[i]) {
				regarde = true;
				System.out.println(p);
			}
			i++;
		}
		
		if(!regarde) {
			System.out.println("Vous n'etes pas le maitre de ce pokemon !");
			this.rencontrer(p);
		}
	}
	
	public void nourrir (Pokemon p, int index) {
		if(p.getMonJoueur() == this) {
			if(this.caisseNourriture[index] != null) {
				if(this.caisseNourriture[index].estCompatible(p.getType())) {
					p.utiliser(this.caisseNourriture[index]);
					this.lacherNourriture(index);
				}
				else {
					System.out.println("Ce pokemon n'est pas compatible avec cet aliment.");
				}
			}
			else {
				System.out.println("Il n'y a pas de nourriture à cet emplacement.");
			}
		}
		else {
			System.out.println("Vous ne pouvez pas nourrir ce pokemon car il ne vous appartient pas.");
			this.rencontrer(p);
		}
		System.out.println();
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public Pokemon[] getPokemons() {
		return this.mesPokemons;
	}
	
	public void nommer(Pokemon p, String nom) {
		if (p.getMonJoueur() == this) {
				p.setNomDonne(nom);
		}
		else {
			System.out.println("Vous ne pouvez pas nommer ce pokemon puisque vous n'etes pas son maitre !");
			this.rencontrer(p);
		}
	}
	
	public void capturer(Pokemon p) {
		boolean capture = false;
		int i = 0;
		this.rencontrer(p);
		if (p.getMonJoueur() != null) {
			System.out.println("Vous ne pouvez pas capturer un pokemon qui a deja un maitre.");
		}
		else{
			while (!capture && i < this.mesPokemons.length) {
				if ((this.mesPokemons[i] == null && !capture)) {
					this.mesPokemons[i] = p;
					p.setMonJoueur(this);
					p.estCapture();
					capture = true;
				}
				i++;
			}
			if (!capture) {
				System.out.println("Vous ne pouvez pas capturer le pokemon " + p.getNom() + " puisque vous avez deja 5 pokemons !");
			}
		}
	}
	
	public void liberer(Pokemon p) {
		boolean libere = false;
		int i = 0;
		
		while (!libere && i < this.mesPokemons.length) {
			if ((this.mesPokemons[i] == p)) {
				this.mesPokemons[i] = null;
				p.setNomDonne(null);
				p.setMonJoueur(null);
				p.estLibere();
				libere = true;
			}
			i++;
		}
		if (!libere) {
			System.out.println("Vous ne pouvez pas liberer ce pokemon puisque vous n'etes pas son maitre.");
		}
	}
	
	public void donner(Pokemon p, Joueur autreJoueur) {
		boolean donne = false;
		int i = 0;
		
		while (!donne && i < this.mesPokemons.length) {
			if (this.mesPokemons[i] == p) {
				int j = 0;
				while (!donne && j < autreJoueur.mesPokemons.length){
					if (autreJoueur.mesPokemons[j] == null) {
						this.mesPokemons[i] = null;
						autreJoueur.mesPokemons[j] = p;
						p.setMonJoueur(autreJoueur);
						donne = true;
					}
					j++;
				}
				if (! donne) {
					System.out.println("Vous ne pouvez pas donner ce pokemon a " + autreJoueur.prenom + " puisqu'il a deja 5 pokemons dans son entourage !");
				}
			}
			i++;
		}
		if (! donne) {
			System.out.println("Vous ne pouvez pas donner ce pokemon puisque vous n'etes pas son maitre !");
		}
	}
	
	public void echanger(Pokemon p, Joueur autreJoueur, Pokemon autrePokemon) {
		boolean echange = false;
		int i = 0;
		this.rencontrer(autrePokemon);
		while (!echange && i < this.mesPokemons.length) {
			if (this.mesPokemons[i] == p) {
				int j = 0;
				while (!echange && j < autreJoueur.mesPokemons.length) {
					if (autreJoueur.mesPokemons[j] == autrePokemon) {
						mesPokemons[i] = autrePokemon;
						autreJoueur.mesPokemons[j] = p;
						p.setMonJoueur(autreJoueur);
						autrePokemon.setMonJoueur(this);
						echange = true;
					}
					j++;
				}
				if (! echange) {
					System.out.println("Vous ne pouvez pas echanger ce pokemon avec " + autreJoueur.prenom + " puisque " + autreJoueur.nom + " n'est pas le maitre du pokemon que vous souhaitez !");
				}
			}
			i++;
		}
		if (! echange) {
			System.out.println("Vous ne pouvez pas echanger ce pokemon avec " + autreJoueur.prenom + " puisque vous n'etes pas son maitre !");
		}
	}

	public Item[] getSacItems() {
		return sacItems;
	}

	public void donnerItem(int indexPokemon, int indexItem) {
		if(indexPokemon < this.mesPokemons.length && indexPokemon >= 0 && this.mesPokemons[indexPokemon] != null && indexItem < this.sacItems.length && indexItem >= 0 && this.sacItems[indexItem] != null) {
			if (this.sacItems[indexItem] instanceof Utilisable == true) {
				this.mesPokemons[indexPokemon].utiliser((Utilisable) this.sacItems[indexItem]);
				
				if(this.sacItems[indexItem].getRestUtilisation() == 0) {
					this.sacItems[indexItem] = null;
				}
				
			} else {
				System.out.println("Erreur, cet item n'est pas utilisable.");
			}
		} else {
			System.out.println("Erreur, l'index saisi pour l'item ou le pokemon est incorrect.");
		}
	}
	
	public void modifierItem(int indexChangeur, int indexAModifier) {
		if(indexChangeur < this.sacItems.length && indexChangeur >= 0 && this.sacItems[indexChangeur] != null && indexAModifier < this.sacItems.length && indexAModifier >= 0 && this.sacItems[indexAModifier] != null) {
			if (this.sacItems[indexChangeur] instanceof ChangeItems && this.sacItems[indexAModifier] instanceof Modifiable) {
				((ChangeItems) this.sacItems[indexChangeur]).utiliser((Modifiable)this.sacItems[indexAModifier]);
				if(this.sacItems[indexChangeur].getRestUtilisation() == 0) {
					this.sacItems[indexChangeur] = null;
				}
			} else {
				System.out.println("Erreur, ces items ne sont soit pas modifiable, soit pas changeur.");
			}
		} else {
			System.out.println("Erreur, l'index saisi pour l'item modifiable ou l'item changeur est incorrect.");
		}
	}
	
	public void addItem(Item item) {
		int i = 0;
		while(i < this.sacItems.length && this.sacItems[i] != null) {
			i++;
		}
		if(this.sacItems[i] == null) {
			this.sacItems[i] = item;
		}
		else {
			System.out.println("Erreur, impossible d'ajouter cet item à votre sac.");
		}
	}
	
	public void lacherItem(int index) {
		if(index < this.sacItems.length && index >= 0) {
			if(this.sacItems[index] != null) {
				this.sacItems[index] = null;
			}
			else {
				System.out.println("Erreur, il n'y a déjà rien à cet emplacement.");
			}
		} else {
			System.out.println("Erreur, index saisi inccorect.");
		}
	}
	
	public String afficherSacItems() {
		String contenus = "";
		
		for(int i = 0; i < this.sacItems.length; i++) {
			if (null != this.sacItems[i]) {
				contenus += i + " : " + this.sacItems[i] + "\n";
			}
		}
		if (contenus.equals("")) {
			System.out.println("Sac d'items vide.");
		}
		return contenus;
	}

	public Pokedex getPokedex() {
		return pokedex;
	}
	public void rencontrer(Pokemon p ){
		this.pokedex.rencontrer(p);
	}
	public void rencontrer(Pokemon[] pokemons){
		this.rencontrer(pokemons);
	}
}