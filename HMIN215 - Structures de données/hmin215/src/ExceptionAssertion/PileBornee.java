package ExceptionAssertion;

public class PileBornee <T> extends Pile <T> implements IpileBornee <T> {
	private int tailleMax;
	
	public PileBornee() {
		tailleMax = 10;
	}
	
	public PileBornee(int taille) {
		this.setTailleMax(taille);
	}

	@Override
	public void initialiser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void empiler(T t) throws TailleMaxDepasseException, PileVideException {
		if(this.nbElements() == tailleMax) throw new TailleMaxDepasseException("en empilant");
		super.empiler(t);
		assert this.nbElements() <= tailleMax;
		
	}

	@Override
	public T depiler() throws PileVideException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T sommet() throws PileVideException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTailleMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTailleMax(int nouvelleTaille) {
		// TODO Auto-generated method stub
		
	}
	

}
