package interfaces;

public class RectangleTab implements IRectangle{
	
	//declaration
	private double tab[] =  new double [2];   // for largeur and hauteur
	public RectangleTab(double h, double l) {
		this.setLargeur(l);
		this.setHauteur(h);
	}
	
	public double getLargeur() {
		return tab[0];
	}
	
	public void setLargeur(double l) {
		if (l >= 0)
			tab[0] = l;
		else 
			System.out.println("Error");
	}
	
	public double getHauteur(){
		return tab[1];
	}
	
	public void setHauteur(double h){
		if (h >= 0)
			tab[1] = h;
		else
			System.out.println("Error");
	}
	
	public String toString(){
		return "Largeur = " + this.getLargeur() + " Hateur = " + this.getHauteur();
	}
	
	
	
	

}
