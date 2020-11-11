package linkedList;

//Amir SHIRALI POUR


/* Inspired from 
 * http://www.docjar.com/html/api/java/util/LinkedList.java.html
 */

public class MyNode<E> {
	
	// exceptionnellement les attributs sont laissés visibles dans le package
	// cela permettra de simplifier le code
	
	
	MyNode<E> prev;
	E item;
	MyNode<E> next;
	

	MyNode(MyNode<E> prev, E element, MyNode<E> next) {
		
		this.prev = prev;
		this.item = element;
		this.next = next;
		
	}
}