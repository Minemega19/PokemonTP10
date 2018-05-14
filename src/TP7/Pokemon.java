package TP7;

import java.util.ArrayList;

import Attaque.Attaque;
import Item.ItemEquipable;

public class Pokemon {
	private String nom;
	private String type;
	private int niveau;
	private boolean diurne;
	private String nomDonne;
	private Joueur monJoueur;
	private int appetit;
	private int satisfaction;
	private int loyaute;
	private int attack;
	private int defense;
	private int speAttack;
	private int speDefense;
	private int hp;
	private int frequency;
	private ArrayList<Attaque> sesAttaques;
	private ItemEquipable sonItem;
	
	public Pokemon (String nom, String type, int niveau, boolean diurne, int attack, int defense, int speAttack, int speDefense, int hp, int frequency, ArrayList<Attaque> sesAttaques) {
		this(nom, type, niveau, diurne, null, null, attack, defense, speAttack, speDefense, 30, frequency, sesAttaques);
	}
	
	public Pokemon (String nom, String type, int niveau, boolean diurne, String nomDonne, Joueur monJoueur, int attack, int defense, int speAttack, int speDefense, int hp, int frequency, ArrayList<Attaque> attaques) {
		this.nom=nom;
		this.type=type;
		this.niveau=niveau;
		this.diurne=diurne;
		this.nomDonne=nomDonne;
		this.monJoueur=monJoueur;
		this.appetit=50;
		this.satisfaction=50;
		this.loyaute=0;
		this.attack=attack;
		this.defense=defense;
		this.speAttack=speAttack;
		this.speDefense=speDefense;
		this.hp=30;
		this.frequency=frequency;
		this.sesAttaques= new ArrayList<Attaque>();
		for (int i = 0; i < attaques.size(); i++) {
			if (i < this.sesAttaques.size()) {
				this.addAttaque(attaques.get(i));
			}
		}
		
	}
	public Pokemon(String nom, String type, int niveau, boolean diurne, String nomDonne, Joueur monJoueur, int appetit, int satisfaction, int loyaute, int attack, int defense, int speAttack, int speDefense, int hp, int frequency, ArrayList<Attaque> sesAttaques, ItemEquipable sonItem) {
				super();
				int i = 0;
				this.nom = nom;
				this.type = type;
				this.niveau = niveau;
				this.diurne = diurne;
				this.nomDonne = nomDonne;
				this.monJoueur = monJoueur;
				this.appetit = appetit;
				this.satisfaction = satisfaction;
				this.loyaute = loyaute;
				this.attack = attack;
				this.defense = defense;
				this.speAttack = speAttack;
				this.speDefense = speDefense;
				this.hp = hp;
				this.frequency = frequency;
				while (i < sesAttaques.size()){
					this.addAttaque(sesAttaques.get(i)) ;
				}
				
				this.sonItem = sonItem;
	}
	public int getAppetit () {
		return this.appetit;
	}
	
	public int getSatisfaction () {
		return this.satisfaction;
	}
	
	public int getLoyaute () {
		return this.loyaute;
	}
	
	public void setAppetit (int appetit) {
		this.appetit=appetit;
	}
	
	public void setSatisfaction (int satisfaction) {
		this.satisfaction=satisfaction;
	}
	
	public void setLoyaute (int loyaute) {
		this.loyaute=loyaute;
	}
	
	public String getNom() {
		return this.nom;
	}
		
	public String getType() {
		return this.type;
	}
	
	public String getNomDonne () {
		return this.nomDonne;
	}
	
	public void setNomDonne(String nomDonne) {
		if (null == this.nomDonne) {
			this.monteLoyaute(10);
		}
		else {
			this.baisseLoyaute(10);
		}	
		this.nomDonne=nomDonne;
	}
	
	public int getNiveau() {
		return this.niveau;
	}
	
	public Joueur getMonJoueur () {
		return monJoueur;
	}
	
	public void setMonJoueur (Joueur monJoueur) {
		this.monJoueur = monJoueur;
	}
	
	public void direBonjour(String periodeJournee) {
		String salut;
		if (periodeJournee.equals("jour")){
			salut = "bonjour";
		}
		else {
			salut = "bonsoir";
		}
		if ((periodeJournee.equals("jour") && this.diurne) || (periodeJournee.equals("nuit") && !this.diurne)) {
			System.out.println(this.nom + " dit " +salut + " !");
		}
		else {
			System.out.println(nom + " dit zzzzzzzzzz !");
		}
	}
	
	public String toString() {
		String resultat = "";
		
		if (monJoueur != null) {
			if (this.nomDonne != null){
				resultat += (this.nomDonne + " est un pokemon du genre " + this.nom + ", du type " + this.type + ", qui a le niveau " + this.niveau + ". Ce pokemon appartient a " + monJoueur.getNom() + " " + monJoueur.getPrenom() + ". Il/Elle a un appetit de " + this.appetit + ", un niveau de satisfaction de " + this.satisfaction + " et une loyaute aupres son maitre de " + this.loyaute + ".");

			}
			else {
				resultat += ("Voici un pokemon du genre " + this.nom + ", du type " + this.type + ", qui a le niveau " + this.niveau + ". Ce pokemon appartient a " + this.monJoueur.getNom() + " " + this.monJoueur.getPrenom() + ". Il/Elle a un appetit de " + this.appetit + ", un niveau de satisfaction de " + this.satisfaction + " et une loyaute aupres son maitre de " + this.loyaute + ".");
			}
			
		} else {
			resultat += "Voici un pokemon du genre " + this.nom + ", du type " + this.type + ", qui a le niveau " + this.niveau + ". Ce pokemon n'a pas encore de maitre. Il/Elle a un appetit de " + this.appetit + " une satisfaction de " + this.satisfaction + " et une loyaute de " + this.loyaute + ".";
		}
		
		resultat += " Ce pokemon a une attaque de " + this.attack + ", une defense de " + this.defense + ", une attaque speciale de " + this.speAttack + ", une defense speciale " + this.speDefense + " et les attaques suivantes : " ;
		
		for (int i = 0; i < this.sesAttaques.size(); i++) {
			if (null != this.sesAttaques.get(i)) {
				resultat += this.sesAttaques.get(i).getNom() + ", ";
			}
		}
		
		return resultat;
	}
	
	public void estCapture() {
		this.loyaute = 0;
		if (this.satisfaction > 10) {
			this.satisfaction = 10;
		}
		if (this.appetit > 10) {
			this.appetit = 10;
		}
	}
	
	public void estLibere() {
		if (this.loyaute > 10) {
			this.baisseSatisfaction(this.loyaute - 10);
		}
		this.loyaute = 0;
	}
	
	public void baisseAppetit(int difference) {
		this.appetit = this.appetit - difference;
		if (this.appetit < 0) {
			this.appetit = 0;
		}
	}
	
	public void monteAppetit(int difference) {
		this.appetit = this.appetit + difference;
		if (this.appetit > 100) {
			this.appetit = 100;
		}
	}
	
	public void baisseSatisfaction(int difference) {
		this.satisfaction = this.satisfaction - difference;
		if (this.satisfaction < 0) {
			this.satisfaction = 0;
		}
	}
	
	public void monteSatisfaction(int difference) {
		this.satisfaction = this.satisfaction + difference;
		if (this.satisfaction > 100) {
			this.satisfaction = 100;
		}
	}
	
	public void baisseLoyaute(int difference) {
		this.loyaute = this.loyaute - difference;
		if (this.loyaute < 0) {
			this.loyaute = 0;
		}
	}
	
	public void monteLoyaute(int difference) {
		this.loyaute = this.loyaute + difference;
		if (this.loyaute > 100) {
			this.loyaute = 100;
		}
	}
	
	public void utiliser(Utilisable itemUtilisables) {
		if(this.getMonJoueur() == null) {
			System.out.println("Erreur, ce pokemon n'a pas de maître.");
		} else {
			itemUtilisables.utiliser(this.getMonJoueur(), this.getIndex());
		}
	}
	
	private int getIndex() {
		int i = 0;
		if(this.getMonJoueur() == null) {
			return -1;
		}
		else {
			while(this != this.getMonJoueur().getPokemons()[i] && i < this.getMonJoueur().getPokemons().length) {
				i++;
			}
			if(this == this.getMonJoueur().getPokemons()[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public void miseANiveau() {
		this.niveau= niveau+1;
	}
	
	public int premierePlaceLibre() {
		int premierePlace = -1; // =pas de place
		int i = 0;
		
		while (premierePlace == -1 && i<this.sesAttaques.size()) {
			if (null == this.sesAttaques.get(i))
				premierePlace = i;
			i++;
		}
		return premierePlace;
	}
	
	public void addAttaque(Attaque a) {
		boolean ajoute = false;
		boolean incompatibiliteTrouvee = false;
		int i = 0;
		
		if (a.estCompatible(this)) {
			while(!ajoute && i < this.sesAttaques.size() && this.sesAttaques.size()<= 4) {
				if (null == sesAttaques.get(i)) {
					sesAttaques.add(i, a);
					ajoute = true;
				}
				i++;
			}
		}
		else {
			System.out.println("Votre pokemon n'est pas compatible avec cette attaque");
			incompatibiliteTrouvee = true;
		}
		
		if (!ajoute && !incompatibiliteTrouvee) {
			System.out.println("Votre pokemon a deja le nombre maximale d'attaques possible. Enlevez une attaque et ressayez.");
		}
	}
	
	public void removeAttack(int index) {
		if(index >= 0 && index < this.sesAttaques.size()) {
			this.sesAttaques.remove(index);
		}
		else {
			System.out.println("Erreur, veuillez séléctionner une attaques.");
		}
	}
	
	public void regarderAttaques() {		
		for(int i=0; i < this.sesAttaques.size();i++) {
			if (this.sesAttaques.get(i) != null) {
				System.out.println(i + " : " + this.sesAttaques.get(i).getNom() + ", repetitions restantes " + this.sesAttaques.get(i).getRepetitionRest());
			}
			i++;
		}
	}
	
	public void resetAttaques() {
		for(int i=0; i < this.sesAttaques.size()-1;i++) {
			if(this.sesAttaques.get(i) != null) {
				sesAttaques.get(i).resetRepetitions();
			}
		}
	}
	
	public boolean sEstEvanoui() {
		return (this.hp == 0);
	}
	
	public void estBlesse(int domage) {
		this.hp = this.hp - domage;
		if(this.hp < 0) {
			this.hp = 0;
		}
	}
	
	public void utiliseAttaque(int index, Pokemon victime) {
		if(victime.sEstEvanoui() == false) {
			if(index > 0 && index < sesAttaques.size()) {
				if(this.sesAttaques.get(index)!=null) {
					this.sesAttaques.get(index).utiliser(this, victime);
				}
				else {
					System.out.println("Attaque non - valide !");
				}
			}
		}
		else {
			System.out.println("Le pokemon s'est déjà évanoui.");
		}
	}

	public boolean isDiurne() {
		return diurne;
	}

	public void setDiurne(boolean diurne) {
		this.diurne = diurne;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeAttack() {
		return speAttack;
	}

	public void setSpeAttack(int speAttack) {
		this.speAttack = speAttack;
	}

	public int getSpeDefense() {
		return speDefense;
	}

	public void setSpeDefense(int speDefense) {
		this.speDefense = speDefense;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public ArrayList<Attaque> getSesAttaques() {
		return sesAttaques;
	}

	public void setSesAttaques(ArrayList<Attaque> sesAttaques) {
		if(sesAttaques.size()<=4)
			this.sesAttaques = sesAttaques;
		else
			System.out.println("votre ArrayList d entree est trop grande");
		
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
		
	public ItemEquipable getSonItem() {
		return sonItem;
	}
	
	public void attribue(ItemEquipable sonItem) {
		this.sonItem = sonItem;
		sonItem.equipe(this);
	}
		
	public void retirer(){
		this.sonItem.desequipe();
		this.sonItem=null;
	}
}
