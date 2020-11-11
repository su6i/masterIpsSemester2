package GenericiteQuestion;

import java.util.ArrayList;

public class FileAttente <TypeObjetEnAttante>
{
	private String nomFile;
	private static int nbTypeObjetEnAttanteEntreesTotal = 0;
	private ArrayList<TypeObjetEnAttante> contenu;
	public FileAttente(){
		contenu=new ArrayList<TypeObjetEnAttante>();
		}
	public void entre(TypeObjetEnAttante p){
		contenu.add(p); 
		nbTypeObjetEnAttanteEntreesTotal++;
		}
	public TypeObjetEnAttante sort()
{
		TypeObjetEnAttante p=null;
		if (!contenu.isEmpty())
			{
			p=contenu.get(0);
			contenu.remove(0);
			}
		return p;
		}
	public int nbElements(){return contenu.size();}
	public boolean estVide(){return contenu.isEmpty();}
	public String toString(){return ""+descriptionContenu();}
	private String descriptionContenu()
	{
		String resultat = "";
		for (TypeObjetEnAttante p:this.contenu)
			resultat += p + " ";
		return resultat;
		}
	
	/* — Ecrivez pour la classe générique File d’attente une méthode statique permettant
	de retourner le nombre d’éléments entrés dans toutes les files d’attente (utilisez l’at-
	tribut existant nbPersonnesEntreesTotal en le renommant nbElementsEntres- */
	
	public static int nbElementsEntresTotal() {
		return nbTypeObjetEnAttanteEntreesTotal;
	}
	
	/* — Ecrivez pour la classe générique File d’attente une méthode statique prenant en
	paramètre deux files d’attente contenant des objets de même type et retournant vrai
	si elles contiennent les mêmes objets. */
	// functional programming method
	public static <x> boolean fileIdentique(FileAttente<x> f1, FileAttente<x> f2) {
		return f1.contenu.equals(f2.contenu);		
	}
	
	/* — Ecrivez pour la classe générique File d’attente une méthode non statique pre-
	nant en paramètre une file d’attente contenant des objets du même type que la file
	receveur et retournant vrai si les deux files contiennent les mêmes objets. */
	// Object oriented method
	public boolean objetIdentique(FileAttente f) {
		return this.contenu.equals(f.contenu);
	}
	
	/* Question 3 Ecrivez pour la classe générique File d’attente une méthode non statique
	prenant en paramètre une file d’attente avec des éléments qui ne sont pas forcément du
	même type que la file receveur et retournant vrai si les deux files sont de la même longueur.
	Ecrivez un programme qui montre comment l’appeler sur une file de rectangles et sur une
	file de personnes. */
	
	public boolean longeurIdentique(FileAttente<TypeObjetEnAttante> f) {
		if(this.nbElements() == f.nbElements()){
			return true;
		}
		else return false;
		
		
	}
	
	
	
	
	}
