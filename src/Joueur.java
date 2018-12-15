import java.util.*;

/**
* @param piocheDeDepart une LinkedList de Domino ( voir class Domino )
*
*/

class Joueur {

	private final int idJoueur;
	private static int nbJoueurs;
	private int points;
	private ArrayList<Domino> mainDuJoueur;

	public Joueur(ArrayList<Domino> piocheDeDepart){
		this.nbJoueurs ++;
		this.idJoueur = this.nbJoueurs;
		this.points = 0;
		this.mainDuJoueur = piocheDeDepart;
	}

	public static int getNbJoueurs(){
		return nbJoueurs;
	}

	/**
	* @return un int contenant tout les points du joueurs ( son score)
	*/

	public int getPoints(){
		return this.points;
	}

	/**
	* @return une linked list avec la main courante du joueur
	*/

	public ArrayList<Domino> getMainDuJoueur(){
		return this.mainDuJoueur;
	}


	/**
	* @return le nombre de piece restantes
	*/

	public int getNombrePiecesRestantes(){
		return this.mainDuJoueur.size();
	}

	/**
	* @return un domino dans la main du joueur, et la supprime de sa main
	*/

	public Domino getDominoAuPif(){
		Random numAlea = new Random();
		int numAleaDomino = numAlea.nextInt(this.mainDuJoueur.size() + 1); // Parce que le n est exclusif

		Domino dominoARetourner = this.mainDuJoueur.get(numAleaDomino);

		// Enlève le domino qui est sorti de la pioche du joueur.
		// TODO : est-ce que c'est la meilleur manière de faire ?
		// On pourrait aussi marquer un domino comme jouer, et donc ne pas avoir
		// à le supprimer ?
		this.mainDuJoueur.remove(numAleaDomino);

		return dominoARetourner;
	}

	// Methode qui compte le nombre de point de la main d'un joueur.

	public void compterLesPoints(){
		for(int i=0; i<this.mainDuJoueur.size(); i++){
			this.points += this.mainDuJoueur.get(i).getValeurTotale();
		}
	}

	/**
	* @return un domino spécifique.
	* @exception IndexOutOfBoundsException si on essaye d'acceder à un domino qui n'existe pas.
	*/

	public Domino getDominoNumero(int i) throws IndexOutOfBoundsException {
		if(i < 0 || i > this.mainDuJoueur.size() ){
			throw new IndexOutOfBoundsException();
		} else {
			return this.mainDuJoueur.get(i);
		}
	}

	/**
	* @return Le dernier domino de la pioche.
	* @exception NegativeArraySizeException si il ne reste plus de domino dans la pioche.
	*/

	public Domino getNextDomino() throws NegativeArraySizeException {
		if (this.mainDuJoueur.size() == 0) {
			throw new NegativeArraySizeException();
		}
		int tailleDeLaPioche = this.mainDuJoueur.size();
		Domino piocheDuJoueur = this.mainDuJoueur.get(tailleDeLaPioche);
		this.mainDuJoueur.remove(tailleDeLaPioche);
		return piocheDuJoueur;
	}

	/**
	* @return retourne le numero du joueur.
	*/
	public int getIdJoueur(){
		return this.idJoueur;
	}
}
