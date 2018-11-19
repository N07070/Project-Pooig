import java.util.*;

// TO DO : Ajouter la javadoc

class Joueur {

	private final int idJoueur;
	private static int nbJoueurs;
	private int points;
	private LinkedList<Domino> mainDuJoueur;

	public Joueur(LinkedList<Domino> piocheDeDepart){
		this.nbJoueurs ++;
		this.idJoueur = this.nbJoueurs;
		this.points = 0;
		this.mainDuJoueur = piocheDeDepart;
	}

	public int getPoints(){
		return this.points;
	}

	public LinkedList<Domino> getMainDuJoueur(){
		return this.mainDuJoueur;
	}

	public int getNombrePiecesRestantes(){
		return this.mainDuJoueur.size();
	}

	public int getDominoAuPif(){
		return this.mainDuJoueur.get(Random.nextInt(this.mainDuJoueur.size()));
	}

	public Domino getDominoNumero(int i){
		return this.mainDuJoueur.get(i);
	}

	public int getIdJoueur(){
		return this.idJoueur;
	}
}
