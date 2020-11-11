package GenericiteBornee;
import java.util.ArrayList;

public class Rayon <AnyTypeOfProduct extends ObjetAvecEtiquette<String>>{
private ArrayList<AnyTypeOfProduct> contenu=new ArrayList<AnyTypeOfProduct>();

// ...

// Constructeur
public Rayon () {
	
	// nothing for instance
}

// methode listingContenu
public String listingContenu(){
	String listing="";
	for (AnyTypeOfProduct c:contenu)
		listing += c.getEtiquette();
	return listing;
	}

// method ajout
public void ajout(AnyTypeOfProduct c) {
	if (!contenu.contains(c)) {
		contenu.add(c);
	}
	
	
}


// ...

// Pour declare une borne (comme : ObjetAvecEtiquette<String>> ) pour un parametre generique 
// on n'utulise que "extends" 


}