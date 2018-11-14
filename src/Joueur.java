import java.util.Random;

// TODO : Ajouter la javadoc

class Joueur {

	private final int numeroDeJoeur;
	private static int nbrJoueurs;
	private int nbrDePoints;
	private LinkedList<Domino> mainDuJoeur;

	public Joueur(LinkedList<Domino> piocheDeDepart){
		this.numeroDeJoeur = this.nbrJoueurs++;
		this.nbrDePoints = 0;
		this.mainDuJoeur = piocheDeDepart;
	}

	public int getNbrDePoints(){
		return this.nbrDePoints;
	}

	public int getNombrePiecesRestantes(){
		return this.mainDuJoeur.size();
	}

	public int getDominoAuPif(){
		return this.mainDuJoeur.get(Random.nextInt(this.mainDuJoeur.size()));
	}

	public int getDominoNumero(int i){
		return this.mainDuJoeur.get(i);
	}

	public int getNumeroDeJoueur(){
		return this.numeroDeJoeur;
	}
}
