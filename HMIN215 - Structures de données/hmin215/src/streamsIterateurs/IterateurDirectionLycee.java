package streamsIterateurs;

import java.util.Iterator;

public class IterateurDirectionLycee implements Iterator<EmployeLycee> {
	
	private DirectionLycee directionAParcourir;
	private int nbMembreDejaRetournes = 0;
	
	public IterateurDirectionLycee(DirectionLycee directionAParcourir) {
		this.directionAParcourir = directionAParcourir;
	}
	 

	@Override
	public boolean hasNext() {
		
		return nbMembreDejaRetournes < 5;
	}

	@Override
	public EmployeLycee next() {
		EmployeLycee e = null;
		
		if (nbMembreDejaRetournes == 0) {
			e = directionAParcourir.getProviseur();
		}
		
		if (nbMembreDejaRetournes == 1) {
			e = directionAParcourir.getProviseurAdjoint();
		}
		
		if (nbMembreDejaRetournes == 2) {
			e = directionAParcourir.getGestionnaire();
		}
		
		if (nbMembreDejaRetournes == 3) {
			e = directionAParcourir.getConseillerPrincipaldEducation();
		}
		
		if (nbMembreDejaRetournes == 4) {
			e = directionAParcourir.getChefDeTravaux();
		}
		
		nbMembreDejaRetournes++;
		
		
		// Deuxième façon avec Switch case
		
		/*
		 switch (nbMembreDejaRetournes) {
		case 0:
			directionAParcourir.getProviseur();
			break;
		case 1:
			directionAParcourir.getProviseurAdjoint();
			break;
		case 2:
			directionAParcourir.getGestionnaire();
			break;
		case 3:
			directionAParcourir.getConseillerPrincipaldEducation();
			break;
		case 4:
			directionAParcourir.getChefDeTravaux();
			break;

		default:
			nbMembreDejaRetournes++;
			break;
		}
		
		*/
		
		
		return e;
	}

}
