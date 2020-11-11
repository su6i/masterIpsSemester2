package GenericiteBornee;

public class Produit implements ObjetAvecEtiquette<String>{
	
	private String etiquette = "nothing";
			
	// .......
			

	// Constructeur
	
	public Produit(String etiquette) {
		this.etiquette = etiquette;
	}

	// Getters and Setters
	public String getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(String etiquette) {
		this.etiquette = etiquette;
	}

}
