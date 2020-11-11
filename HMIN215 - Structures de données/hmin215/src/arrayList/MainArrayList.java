package arrayList;

import java.util.Arrays;

public class MainArrayList {

	public static void main(String[] args) {
		
		// création du tableau
		String[] tableau = new String[6];
		
		// par défaut il contient null dans toutes les cases
		System.out.println(Arrays.toString(tableau));
		
		// on stocke "z" "e" et "n"
		tableau[0]="z";
		tableau[1]="e";
		tableau[2]="n";
		System.out.println(Arrays.toString(tableau));

		// on ajoute "o" entre "e" et "n"
		// pour cela, on décale d'abord le "n" à droite
		tableau[3]=tableau[2];
		tableau[2]="o";
		System.out.println(Arrays.toString(tableau));

		//on repart du tableau dans son état d'origine
		tableau[0]="z";
		tableau[1]="e";
		tableau[2]="n";
		tableau[3]=null;		
		System.out.println(Arrays.toString(tableau));
		
		// on veut mettre "i", "t", "u", "d", "e"
		tableau[3]="i";		
		tableau[4]="t";
		tableau[5]="u";
		System.out.println(Arrays.toString(tableau));
		// ennuyeux : plus de place
		// tableau[6]="d";	provoquera une erreur !
		// Exception in thread "main" 
		// java.lang.ArrayIndexOutOfBoundsException: 
		// Index 6 out of bounds for length 6
		// donc on n'insiste pas ...
		
		// on crée un tableau plus grand
		String[] tableauPlusGrand = new String[10];
		
		// on recopie soigneusement
		for (int i = 0; i < tableau.length; i++)
			tableauPlusGrand[i] = tableau[i];
		System.out.println(Arrays.toString(tableauPlusGrand));
		
		// et on peut ajouter ce qui manque
		tableauPlusGrand[6]="d";
		tableauPlusGrand[7]="e";
		System.out.println(Arrays.toString(tableauPlusGrand));
	}

}
