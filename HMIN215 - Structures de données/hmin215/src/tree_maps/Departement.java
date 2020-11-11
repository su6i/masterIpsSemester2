package tree_maps;

public class Departement {
	private String nom;
	private String numero;
	private double superficie;
    private String préfecture;
    private int nbHabitants;
    private int nbCommunes;
	public Departement(String nom, String numero,
				double superficie, String préfecture, 
				int nbHabitants, int nbCommunes) {
		this.nom = nom;
		this.numero = numero;
		this.superficie = superficie;
		this.préfecture = préfecture;
		this.nbHabitants = nbHabitants;
		this.nbCommunes = nbCommunes;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public String getPréfecture() {
		return préfecture;
	}
	public void setPréfecture(String préfecture) {
		this.préfecture = préfecture;
	}
	public int getNbHabitants() {
		return nbHabitants;
	}
	public void setNbHabitants(int nbHabitants) {
		this.nbHabitants = nbHabitants;
	}
	public int getNbCommunes() {
		return nbCommunes;
	}
	public void setNbCommunes(int nbCommunes) {
		this.nbCommunes = nbCommunes;
	}
	@Override
	public String toString() {
		return "Departement [nom=" + nom + ", numero=" + numero + ", superficie=" + superficie + ", préfecture="
				+ préfecture + ", nbHabitants=" + nbHabitants + ", nbCommunes=" + nbCommunes + "]";
	}
}
