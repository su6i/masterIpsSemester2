package interfaces;

public interface ILosange extends Iquadrilatere{
	
	double getCote();
	void setCote(double c);
	double getAngle();
	void setAngle(double a);

	
	// perimetre
	default double perimetre() {
		return this.getCote()*4;
	}
	
	default double aire() {
		return Math.pow(this.getCote(), 2) * Math.sin(Math.toRadians(this.getAngle()));
	}

	

}
