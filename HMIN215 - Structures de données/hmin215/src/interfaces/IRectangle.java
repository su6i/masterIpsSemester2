package interfaces;

public interface IRectangle extends Iquadrilatere {
	
	int angle = 90;
	double  getLargeur();
	void setLargeur(double l);
	double getHauteur();
	void setHauteur(double h);
	
	// perimetre
	default double perimetre() {
		return this.getLargeur()*2+
				this.getHauteur()*2;
	}
	
	// aire
	default double aire() {
		return this.getLargeur() * this.getHauteur();
	}
	
	//egal
	default boolean egal (IRectangle i) {
		return (this.getLargeur() == i.getLargeur()) && (this.getHauteur() == i.getHauteur());
	}
	
	// exemple de methode static
	static boolean egal (IRectangle r1, IRectangle r2) {
		return r1.egal(r2);
	}
	

}
