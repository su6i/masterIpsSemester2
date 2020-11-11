package interfaces;

public class Rectangle implements IRectangle {
	
	private double largeur,hauteur;
	
	public Rectangle (double hauteur, double largeur){
		
		this.setHauteur(hauteur);
		this.setLargeur(largeur);
	}
	

	@Override
	public double getLargeur() {
		return this.largeur;
	}

	@Override
	public void setLargeur(double l) {
		if (l >= 0)
			this.largeur = l;
		else System.out.println("Error");
	}

	@Override
	public double getHauteur() {
		return this.hauteur;
	}

	@Override
	public void setHauteur(double h) {
		if (h >= 0)
			this.hauteur = h;
		else System.out.println("Error");
	}
	
	public String toString(){
		return "Largeur = " + this.getLargeur() + " Hateur = " + this.getHauteur();
	}

		
		
	}