package linkedList;

//Amir SHIRALI POUR



import java.util.*;
public class MyLinkedList <E>
       extends AbstractSequentialList<E>
       implements List<E>
{
	
	
	// private MyLinkedList<E> myLinedList;
	
	private int size = 0; 
       /**
        * Pointer to first node.
        * Invariant: (first == null && last == null) ||
        *            (first.prev == null && first.item != null)
        */
	private MyNode<E> first=null;
       /**
        * Pointer to last node.
        * Invariant: (first == null && last == null) ||
        *            (last.next == null && last.item != null)
        */
	private MyNode<E> last=null;

	public MyLinkedList() {} 
	
	// une liste vide est telle que first == null && last == null
	@Override   
	public boolean isEmpty() {
		
		return (first == null && last == null);
	}
	
	// ajout à la fin de la chaîne
	@Override 
	public boolean add(E element) {
		MyNode<E> newNod = new MyNode<E>(null, null, null);
		newNod.prev = last;
		newNod.item = element; 
		newNod.next = null;    // I know that it's not necessary!
		
		if (this.isEmpty()) {
			this.first = newNod;
			this.last = newNod;
		}
			
		else {
			this.last.next = newNod;
			this.last = newNod;
		}
		
		size++;
		return true;
	}
	
	// cherche si l'élément est au milieu
	@Override 
	public boolean contains(Object element) {
		MyNode<E> current = new MyNode<E>(null, null, null);
		current = first;
		boolean result = false;
		
		while(current != null) {
			if(current.item == element) {
				result =  true;
			}
			current = current.next;
		}
		return result;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public E get(int i) {
		MyNode<E> current = new MyNode<E>(null, null, null);
		
		current= first;
		int cursor = 0;
		if (i<0 || i>this.size()-1)
			return null;
		else {
			while (cursor != i) {
				current = current.next;
				cursor++;
			}
		return current.item;
			
		}
		
		
	}
	
	@Override
	public String toString() {
		
		MyNode<E> current = new MyNode<E>(null, null, null);
		
		String result = "";
		current= first;
		
		while (current !=null) {
			result += current.item;
			current = current.next;
		}
		return result;
		
	}	
	
	public String toStringInverse() {
		MyNode<E> current = new MyNode<E>(null, null, null);
		
		String result = "";
		current= last;
		
		while (current !=null) {
			result += current.item;
			current = current.prev;
		}
		return result;
	}	
	
	// methode ecrite pour respecter l'interface mais que l'on ne va
	// pas implementer dans ce TP
	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}
}