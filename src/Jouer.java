import java.util.ArrayList;
public class Jouer {

	private int nbJoueurs;
	private ArrayList<Joueur> joueurListe;;
	private int tourCourant;

	public Jouer(int nbJoueurs){
		// Creer le nombre de joueur
		if (nbJoueurs > 0 && nbJoueurs <= 4) {
			for (int i = 0; i < nbJoueurs; i++) {

		}
		// Initialiser le tour courant
	}

	public ArrayList<Joueur> getJoueurListe(){
		return this.joueurListe;
	}

	public int getTourCourant(){
		return this.tourCourant;
	}

}
