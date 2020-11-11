package interfaces;

public class Carre implements ICarre{
	private double cote;
	
	public Carre(double cote) {
		this.setCote(cote);
	}

	@Override
	public double getCote() {
		return this.cote;
	}

	@Override
	public void setCote(double c) {
		if (c >= 0)
			this.cote = c;
		else System.out.println("Error");
	}

	@Override
	public double getAngle() {
		return IRectangle.angle;
	}

	@Override
	public void setAngle(double a) {
		System.out.println("Impossible");
	}


	@Override
	public double getLargeur() {
		return this.getCote();
	}

	@Override
	public void setLargeur(double l) {
		this.setCote(l);
	}

	@Override
	public double getHauteur() {
		return this.getCote();
	}

	@Override
	public void setHauteur(double h) {
		this.setCote(h);
		
	}
	
	public String toString(){
		return "Carre de cote = " + this.getCote();
	}
		
		
	}


	


