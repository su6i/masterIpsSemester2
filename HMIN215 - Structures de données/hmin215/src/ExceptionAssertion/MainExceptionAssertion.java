package ExceptionAssertion;

public class MainExceptionAssertion {

	public static void main(String[] args) {
		
		try {
			PileBornee<String> myPileBornee = new PileBornee<>();
			myPileBornee.empiler("Orange");
			myPileBornee.empiler("Pomme");
			myPileBornee.empiler("Poire");
			myPileBornee.empiler("Citron");
			myPileBornee.empiler("Banane");
			
			
		} catch (PileVideException e) {
			System.out.println(e.getMessage());
		}
		catch (TailleMaxDepasseException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
