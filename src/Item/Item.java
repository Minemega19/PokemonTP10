package Item;

public abstract class Item {
	private String nom;
	private int frequence;
	private int maxUtilisation;
	private int restUtilisation;
	
	public Item(String nom, int frequence, int maxUtilisation) {
		this.nom = nom;
		this.frequence = frequence;
		this.maxUtilisation = maxUtilisation;
		this.restUtilisation = maxUtilisation;
	}
	
	public void baisserUtilisation(int difference) {
		this.restUtilisation = this.restUtilisation - difference;
	}
	
	public void monterUtilisation(int difference) {
		this.restUtilisation = this.restUtilisation + difference;
	}
	
	public void resetUtilisation() {
		this.restUtilisation = this.maxUtilisation;
	}
	
	public boolean seraGenere() {
		if(this.frequence > 100*Math.random()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return (this.nom + " : " + this.frequence + ", " + this.restUtilisation + "/" + this.maxUtilisation);
	}
	
	public abstract Item genAlea();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getFrequence() {
		return frequence;
	}

	public int getMaxUtilisation() {
		return maxUtilisation;
	}

	public int getRestUtilisation() {
		return restUtilisation;
	}	
}
