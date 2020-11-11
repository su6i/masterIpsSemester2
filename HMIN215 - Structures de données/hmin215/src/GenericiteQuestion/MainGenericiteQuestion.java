package GenericiteQuestion;

import interfaces.Rectangle;

public class MainGenericiteQuestion {

	public static void main(String[] args) {
		
		FileAttente<Personne> myFileAttantePersonne = new FileAttente<Personne>();
		FileAttente<Rectangle> myFileAttanteRectangle = new FileAttente<Rectangle>();
		
		Personne p1 = new Personne();
		Rectangle r1 = new Rectangle(4, 5);
		
		myFileAttantePersonne.entre(p1);
		myFileAttanteRectangle.entre(r1);
		
		
		/* — Ecrivez un programme qui montre comment appeler ces méthodes. */
		FileAttente<Personne> mySecondFileAttantePersonne = new FileAttente<Personne>();
		FileAttente.fileIdentique(myFileAttantePersonne, mySecondFileAttantePersonne);
		myFileAttantePersonne.objetIdentique(mySecondFileAttantePersonne);
		
		
				
		

	}

}
