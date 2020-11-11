package streamsIterateurs;

import java.util.ArrayList;
import java.util.Iterator;

// This is a comment!

public class DirectionLycee implements Iterable<EmployeLycee>{
	private EmployeLycee proviseur,
						proviseurAdjoint,
						conseillerPrincipaldEducation,
						gestionnaire,
						chefDeTravaux;

	public DirectionLycee() {
	}

	public EmployeLycee getProviseur() {
		return proviseur;
	}

	public void setProviseur(EmployeLycee proviseur) {
		this.proviseur = proviseur;
	}

	public EmployeLycee getProviseurAdjoint() {
		return proviseurAdjoint;
	}

	public void setProviseurAdjoint(EmployeLycee proviseurAdjoint) {
		this.proviseurAdjoint = proviseurAdjoint;
	}

	public EmployeLycee getConseillerPrincipaldEducation() {
		return conseillerPrincipaldEducation;
	}

	public void setConseillerPrincipaldEducation(EmployeLycee conseillerPrincipaldEducation) {
		this.conseillerPrincipaldEducation = conseillerPrincipaldEducation;
	}

	public EmployeLycee getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(EmployeLycee gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public EmployeLycee getChefDeTravaux() {
		return chefDeTravaux;
	}

	public void setChefDeTravaux(EmployeLycee chefDeTravaux) {
		this.chefDeTravaux = chefDeTravaux;
	}
	
	public String toString() {
		String res ="Direction du lycee "
				+"\nproviseur "+this.getProviseur()
				+"\nproviseur adjoint "+this.getProviseurAdjoint()	
				+"\ngestionnaire "+this.getGestionnaire()		
				+"\nCPE "+this.getConseillerPrincipaldEducation()	
				+"\nChef de travaux "+this.getChefDeTravaux();
		return res;
	}
	
	public int ageMoyen() {
		 return (this.getProviseur().getAge()+
				this.getProviseurAdjoint().getAge()+
				this.getConseillerPrincipaldEducation().getAge()+
				this.getGestionnaire().getAge()+
				this.getChefDeTravaux().getAge())/5;
	}
	
	public ArrayList<EmployeLycee> recruteApres(int annee) {
		ArrayList<EmployeLycee> res = new ArrayList<>();
		 if (this.getProviseur().getAnneeRecrutement()>=annee)
			 res.add(this.getProviseur());
		 if (this.getProviseurAdjoint().getAnneeRecrutement()>=annee)
			 res.add(this.getProviseurAdjoint());
		 if (this.getConseillerPrincipaldEducation().getAnneeRecrutement()>=annee)
			 res.add(this.getConseillerPrincipaldEducation());		 
		 if (this.getGestionnaire().getAnneeRecrutement()>=annee)
			 res.add(this.getGestionnaire());
		 if (this.getChefDeTravaux().getAnneeRecrutement()>=annee)
			 res.add(this.getChefDeTravaux());
		return res;
	}
	
	public void afficheNoms() {
		System.out.println(
				"\n"+this.getProviseur().getNom()+" "
				+"\n"+this.getProviseurAdjoint().getNom()+" "
				+"\n"+this.getGestionnaire().getNom()+" "		
				+"\n"+this.getConseillerPrincipaldEducation().getNom()+" "	
				+"\n"+this.getChefDeTravaux().getNom()+" ");
	}
	
	public void afficheNomsRecrutesApres(int annee) {
		ArrayList<EmployeLycee> recrues = this.recruteApres(annee);
		for (EmployeLycee e : recrues)
				System.out.println(e.getNom()+" ");
	}

	@Override
	public Iterator<EmployeLycee> iterator() {
		return new IterateurDirectionLycee(this);
	}
	
	//********* ITERATEUR ******************
	
	// Ecrire ageMoyen avec l'itérateur et for
	
	
	// Both methods work only with implementation of iterators!
	
	public int ageMoyenAvecIterateur1() {
		int sommeAge = 0;
		for(EmployeLycee e: this)
			sommeAge += e.getAge(); break;
		 return (sommeAge/5);
	}
	
	public int ageMoyenAvecIterateur2() {
		int sommeAge = 0;
		Iterator<EmployeLycee> ite = this.iterator();
		while (ite.hasNext()) {
			sommeAge += ite.next().getAge();
		}
		return (sommeAge/5);
	}
	
	// map = projection
	// filter = selection
	
	
	
	
	// Ecrire recruteApres avec for (quand l'iterateur existe)
	
	public Arr
	
	// Ecrire afficheNoms avec for (quand l'iterateur existe)
	
	// Ecrire afficheNomsRecrutesApres avec for (quand l'iterateur existe)
	
	//********* STREAM ******************
	
	// Ecrire une methode retournant une liste contenant les membres de la direction
	// Cette liste est un support pour les exercices sur les streams
	
	public ArrayList<EmployeLycee> membres() {
		ArrayList<EmployeLycee> res = new ArrayList<EmployeLycee>();
		for(EmployeLycee e: this)
			res.add(e);
		return res;
		
	}
	
	// Ecrire ageMoyen avec un stream sur la liste precedente
	
	// ça vien dans l'examen 
	
	public double ageMoyenStream() {
		
		return this.membres().stream()
				.mapToDouble(m-> m.getAge())
				.average()
				.getAsDouble();
		
		
	}
	
	// Ecrire recruteApres avec un stream
	
	// Ecrire afficheNoms avec un stream
	
	// Ecrire afficheNomsRecrutesApres avec un stream
	
	//********* SYNTHESE ******************
	
	// Ecrire une methode retournant l'age moyen 
	// des membres d'une certaine categorie recrutes
	// avant une certaine annee
	
	// version 1 : sans considerer l'iterateur (pas de for)
	// version 2 : en considérant l'iterateur (avec for)
	// version 3 : avec un stream
	
	//*********  ******************
	
	// Ecrire une methode retournant l'annee de recrutement
	// la plus ancienne pour les employes 
	// d'un certain corps
	
	// version 1 : sans considerer l'iterateur (pas de for)
	// version 2 : en considérant l'iterateur (avec for)
	// version 3 : avec un stream
	
}
