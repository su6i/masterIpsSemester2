package linkedList;

import linkedListSol.MyLinkedList;

public class MainMyLinkedList {

	public static void main(String[] arg) {
		
		MyLinkedList<String> maListe = new MyLinkedList<>();
		System.out.println("taille = "+maListe.size());
		System.out.println("vide ? "+maListe.isEmpty());
		maListe.add("n");
		System.out.println("taille = "+maListe.size());
		System.out.println("vide ? "+maListe.isEmpty());
		System.out.println(maListe);
		System.out.println(maListe.toStringInverse());
		maListe.add("e");
		System.out.println("taille = "+maListe.size());
		System.out.println("vide ? "+maListe.isEmpty());
		System.out.println(maListe);
		System.out.println(maListe.toStringInverse());
		maListe.add("z");
		System.out.println(maListe);
		System.out.println(maListe.toStringInverse());
		System.out.println("vide ? "+maListe.isEmpty());
		System.out.println("taille = "+maListe.size());
		System.out.println("element -1 "+maListe.get(-1));
		System.out.println("element 0 "+maListe.get(0));	
		System.out.println("element 1 "+maListe.get(1));			
		System.out.println("element 2 "+maListe.get(2));
		System.out.println("element 3 "+maListe.get(3));
		System.out.println("contient n ? "+maListe.contains("n"));	
		System.out.println("contient e ? "+maListe.contains("e"));	
		System.out.println("contient z ? "+maListe.contains("z"));	
		System.out.println("contient o ? "+maListe.contains("o"));	
				
	}
}
