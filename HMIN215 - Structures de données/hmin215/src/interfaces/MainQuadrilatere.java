package interfaces;

public class MainQuadrilatere {

	public static void main(String[] args) {
		IRectangle r = new Rectangle(4, 5);
		System.out.println(r + " aire " + r.aire() + " Perimetre = " + r.perimetre());
		
		// Second implementation
		r = new RectangleTab(4, 5);
		System.out.println(r + " aireTab " + r.aire() + " PerimetreTab = " + r.perimetre());

	}

}
