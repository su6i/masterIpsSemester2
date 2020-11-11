package interfaces;

public interface ICarre extends ILosange,IRectangle {
	
	
	// perimetre
	default double perimetre() {
		return ILosange.super.perimetre();
	}
	
	// aire
	default double aire() {
		return Math.pow(this.getCote(), 2);
	}

}
