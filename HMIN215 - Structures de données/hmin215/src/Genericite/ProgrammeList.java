package Genericite;

import interfaces.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeList {

	public static void main(String[] args) {
		
		Genericite.List maliste = new ListeConcrete();
		java.util.List <Rectangle> maliste2 = new ArrayList<>();     //on peut ecrire = new ArrayList<Rectangle>();
		Rectangle r1 = new Rectangle(5, 8);
		maliste.add(4);
		maliste2.add(r1);
		Rectangle r = maliste2.get(0);								// Cette fois-ce on n'aura pas problème de Cast
		// maliste2.add(4); 										// ça ne marche pas, car la difinition de List en java c'est differant et elle prend un objet en parametre
		// Object O = new Rectangle();
		if (maliste.get(0) instanceof Rectangle){
			Rectangle r2 = (Rectangle) maliste.get(0);
			// r.aire();       // ça va echoué avec cast
			// System.out.println(r.aire());   // ça va echoué avec cast
			// le Cast à deux inconvenient, n'est pas du tout recommandé 
		}
		
		Paire<Rectangle,String> p1 = new Paire<Rectangle,String>(new Rectangle(5,6),"plus grand chiffre");   
		Rectangle r3=p1.getFst();
				
		

	}
}
