package ExceptionAssertion;

public interface IPile<T>{
	
	void initialiser();
	void empiler(T t) throws PileVideException, TailleMaxDepasseException;
	T depiler()throws PileVideException;;
	T sommet() throws PileVideException;
	boolean estVide();
}