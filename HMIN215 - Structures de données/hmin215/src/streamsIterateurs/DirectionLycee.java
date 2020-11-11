package streamsIterateurs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DirectionLycee implements Iterable<EmployeLycee> {
	//au moment de l'ajout de Iterable<EmployeLycee>une erreur s'affiche pour nous dire qu'il faut une m�thode iterator
	private EmployeLycee proviseur,
						proviseurAdjoint,
						conseillerPrincipaldEducation,
						gestionnaire,
						chefDeTravaux; 
	//IMPORTANT : les iterations sont importantes parce qu'on travaille sur des attributs et non pas des classes d'ou l'utilisation de ce dernier 

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
	
	//
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
	//le this ici fait appel au constructeur de la classe IteratorDirectionLycee
	//DirectionLycee :ca devient un agrega pour pouvoir mettre un iterateur d'ou la methode iterator
	public Iterator<EmployeLycee> iterator() {
		return new IterateurDirectionLycee(this);
	}
	
	
	
	//********* ITERATEUR ******************
	         
	// Ecrire ageMoyen avec l'itérateur et for 
	//Avec 3 Version 
	
	 //1ere Version de maniere implicite 
	public int ageMoyen2() {
		int sommeAge = 0 ; 
		for (EmployeLycee e : this) //le this est pris comme une liste et il fait reference a une liste d'attribut
			sommeAge += e.getAge(); //e attributs de la classe EmployeeLycee
		return (sommeAge/5);
	 
	}
	//2eme Version de maniere explicite

	public int ageMoyen3() {
		Iterator<EmployeLycee> ite = this.iterator() ;
		int sommeAge =0 ;
		while (ite.hasNext())
			sommeAge  += ite.next().getAge();
		return (sommeAge/5);
	}
	
	
	// Ecrire recruteApres avec for (quand l'iterateur existe)
	  //cette m�thode nous permet d'ecrire recruteApres de maniere plus simple 
	  //en manipulant les attributs avec e 
	public ArrayList<EmployeLycee> recruteApresIterateur(int annee){
		ArrayList<EmployeLycee> res=new ArrayList<EmployeLycee>();
		for (EmployeLycee e :this)
			if(e.getAnneeRecrutement()>=annee)
				res.add(e);
		return res;
	}
	
	// Ecrire afficheNoms avec for (quand l'iterateur existe)
	public void afficheNomsIterateur() {
		for (EmployeLycee e:this)
			System.out.println("le nom: "+e.getNom());
		
	}
	
	
	// Ecrire afficheNomsRecrutesApres avec for (quand l'iterateur existe) 
	public void afficheNomRecrutesApresIterateur(int annee) {
		ArrayList<EmployeLycee> noms=recruteApresIterateur(annee);
		for (EmployeLycee e:noms)
			System.out.println(e.getNom());
	}
	
	
	
	//********* STREAM ******************
	
	// Ecrire une methode retournant une liste contenant les membres de la direction
	// Cette liste est un support pour les exercices sur les streams
	public ArrayList<EmployeLycee>membres(){
		//cette liste nous sert a cree le flux pour utiliser le stream juste apres
		ArrayList<EmployeLycee> listeMembres = new ArrayList<>();
		for (EmployeLycee e : this)
			listeMembres.add(e);
		return listeMembres;
	}
	
	// Ecrire ageMoyen avec un stream sur la liste precedente , lui faire retourner un double 
	 public double ageMoyenStream() {
		 return 
		 membres() // ou on peut mettre le return this.membres()
		 .stream()
		 .mapToDouble(l-> l.getAge()) //le l est un element avec le quel on parcours
		 // le mapToDouble a �t� mis pour eviter les probleme de typage
		 .average().getAsDouble() ;// pour le calcul de la moyenne 
	 }
	
	// Ecrire recruteApres avec un stream
	 ArrayList<EmployeLycee> recruteApresStream(int annee){
	    List<EmployeLycee> employe= membres()
		 .stream()
		 //filtre le stream
		 .filter(m->m.getAnneeRecrutement()>=annee)
		 // le collecte et le met dans une liste
		 .collect(Collectors.toList());
		ArrayList<EmployeLycee> res=new ArrayList<EmployeLycee>(employe);
		return res;
	    
       }
	 
	
	// Ecrire afficheNoms avec un stream
	 public void afficheNomsStream(int annee) {
		 membres().stream()
		 .filter(m->m.getAnneeRecrutement()>=annee)
		 //map:fonction de prejection 
		 .map(m->m.getNom())
		 .forEach(nom->System.out.println(" le nom est : "+nom));
		 
	 }
	
	/*
	public void afficheNomsStream(int annee) {
		 membres().stream()
		 //map:fonction de prejection 
		 .map(m->m.getNom())
		 .forEach(nom->System.out.println(" le nom est : "+nom));
		 
	 }
	*/
	
	// Ecrire afficheNomsRecrutesApres avec un stream
	 public void afficheNomsRecruteApresStream(int annee) {
		 
		 ArrayList<EmployeLycee> noms=recruteApresStream(annee);
		 for(EmployeLycee m:noms)
			 System.out.println(m.getNom());
		 
	 }
	
	/*
	public void afficheNomsRecrutesApresStream(int annee) {
		 membres().stream()
		 .filter(m->m.getAnneeRecrutement()>=annee)	 
		 .map(m->m.getNom())
		 .forEach(nom->System.out.println(" le nom est : "+nom));
		 
	 }
	*/
	
	//********* SYNTHESE ******************
	
	// Ecrire une methode retournant l'age moyen 
	// des membres d'une certaine categorie recrutes
	// avant une certaine annee 
	 
	// version 1 : sans considerer l'iterateur (pas de for)
	 public double syntheseAgeMoyen(Categorie categorie , int annee) {
		 double resultat=0;
		 int i=0;
		 if ((getProviseur().getCategorie().equals(categorie))&&
				 (getProviseur().getAnneeRecrutement()<annee)) {
			 resultat +=getProviseur().getAge();
			 i++;
		 }
		 
		 if ((getProviseurAdjoint().getCategorie().equals(categorie))&&
				 (getProviseurAdjoint().getAnneeRecrutement()<annee)) {
			 resultat +=getProviseurAdjoint().getAge();
			 i++;
		 }
		 
		 if ((getGestionnaire().getCategorie().equals(categorie))&&
				 (getGestionnaire().getAnneeRecrutement()<annee)) {
			 resultat +=getGestionnaire().getAge();
			 i++;
		 }
		 
		 if ((getChefDeTravaux().getCategorie().equals(categorie))&&
				 (getChefDeTravaux().getAnneeRecrutement()<annee)) {
			 resultat +=getChefDeTravaux().getAge();
			 i++;
		 }
		 if (i>0)
			 return resultat/i;
		 else return 0;
		 
	 }
	
	 // version 2 : en considérant l'iterateur (avec for)
	 public double syntheseAgeMoyenIterateur(Categorie categorie,int annee) {
		 int sommeAge=0 ; 
		 int nombre=0;
		 for (EmployeLycee e : this) 
			 if(e.getAnneeRecrutement()<=annee &&
			 		e.getCategorie().equals(categorie)){
				 sommeAge +=e.getAge() ; 
				 nombre++; 
			 } 
		 //pour eviter la division par 0 car nombre des membres peut etre 0
		 if (nombre>0) 
			 return sommeAge/nombre;
		 else return 0;
	 }
	 
	// version 3 : avec un stream
	 public double ageMoyenSyntheseStream(Categorie categorie,int annee) {
		 return 
			 membres().stream()
			 .filter(m->m.getAnneeRecrutement()<annee)
			 .filter(m->m.getCategorie()==categorie)
			 .mapToDouble(EmployeLycee::getAge) // ou (m-> m.getAge())?
			 .average().getAsDouble();
				 
	 }
	
	//*********  ******************
	
	// Ecrire une methode retournant l'annee de recrutement
	// la plus ancienne pour les employes 
	// d'un certain corps
	
	// version 1 : sans considerer l'iterateur (pas de for)
	 public int anneeRecrutementAncienne(Categorie categorie) {
		 ArrayList<Integer>employeCategorie=new ArrayList<Integer>();
		 if(getProviseur().getCategorie().equals(categorie))
				 employeCategorie.add(getProviseur().getAnneeRecrutement());
		 
		 if(getProviseurAdjoint().getCategorie().equals(categorie))
			 employeCategorie.add(getProviseurAdjoint().getAnneeRecrutement());
		 
		 if(getConseillerPrincipaldEducation().getCategorie().equals(categorie))
			 employeCategorie.add(getConseillerPrincipaldEducation().getAnneeRecrutement());
		 
		 if(getGestionnaire().getCategorie().equals(categorie))
			 employeCategorie.add(getGestionnaire().getAnneeRecrutement());
		 
		 
		 if(getChefDeTravaux().getCategorie().equals(categorie))
			 employeCategorie.add(getChefDeTravaux().getAnneeRecrutement());
		 
		 return Collections.min(employeCategorie);
	 }
	 
	// version 2 : en considérant l'iterateur (avec for)
	 public int anneeRecrutementAncienneIterateur(Categorie categorie) {
		 ArrayList<Integer>employeCategorie=new ArrayList<Integer>();
		 for (EmployeLycee e:this)
			 if(e.getCategorie().equals(categorie)) 
				 employeCategorie.add(e.getAnneeRecrutement()); 
				 
		 return Collections.min(employeCategorie); 
		 }
	// version 3 : avec un stream 
	 public int anneeRecrutementAncienneStream(Categorie categorie) {
		 return membres()
				 .stream()
				 .filter(m->m.getCategorie()==categorie)
				 .mapToInt(EmployeLycee::getAnneeRecrutement)
				 // :: methode qui vient d'une autre classe
				 .min()
				 .getAsInt();
		 
	 }
	
}
