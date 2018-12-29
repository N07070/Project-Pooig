

import java.util.*;
public class Jouer {

	/**
	* classe Jouer : Met en place la logique du jeu

	* @author Mehdi

	* @param nbJoueurs le nombre de joueur dans la partie
	* @param joueurListe une ArrayList qui contient les joueurs
	* @param tourCourant le tour X de la partie
	* @param tourDuJoueurX détermine quel joueur doit jouer
	* @param tableDeJeu le plateau sur lequel les dominos sont posés
	* @param lesDominos la liste de tous les dominos restants non distribués
	*/

	private int nbJoueurs;
	private ArrayList<Joueur> joueurListe = new ArrayList<Joueur>();
	private int tourDuJoueurX;
	private int tourCourant;
	private Plateau tableDeJeu;
	private ArrayList<Domino> lesDominos;


	public Jouer(int tailleDuPlateau, int nbrJoueurs){
		this.nbJoueurs = nbrJoueurs;
		this.tableDeJeu = new Plateau(tailleDuPlateau);

        lesDominos = genererLesDominos();

        // On init les joueurs
		if (nbJoueurs > 0 && nbJoueurs <= 4) {
			int nombreDeDominoParJoueurs = (int) lesDominos.size() / nbJoueurs;
			for (int i = 0; i < nbJoueurs; i++) {
				// On récupère une partie du total des dominos pour chaque joueurs
		        ArrayList<Domino> dominosPourJoueur = new ArrayList<Domino>();
		        for (int j = 0 ; j < nombreDeDominoParJoueurs ; j++ ) {
					int nombreAleatoire = (int)(Math.random()*((lesDominos.size())));
			        dominosPourJoueur.add(lesDominos.get(nombreAleatoire));
			        lesDominos.remove(nombreAleatoire);

					// Only for test
					System.out.println("le nombre de dominos restant "+lesDominos.size());
					System.out.println("le nombre de dominos attribué pour joueur " + i + " "+dominosPourJoueur.size());
				}

      		this.joueurListe.add(new Joueur(dominosPourJoueur));
			}
		}
		// Initialiser le tour courant
		this.tourCourant = 0;

		// On choisit un joueur au hasard pour commencer
		int nombreAleatoire = (int)(Math.random()*((nbJoueurs)));
		this.tourDuJoueurX = nombreAleatoire;
	}

	public ArrayList<Joueur> getJoueurListe(){
		return this.joueurListe;
	}

	public Joueur getJoueurX(int x) throws IndexOutOfBoundsException {
		try {
			return this.joueurListe.get(x);
		} catch(IndexOutOfBoundsException e) {
			throw e;
		}
	}

	public void setNbJoueurs(int nbrJoueurs){
		this.nbJoueurs = nbrJoueurs;
	}

	public int getTourCourant(){
		return this.tourCourant;
	}

	public int getTourDuJoueurX(){
	  return this.tourDuJoueurX;
	}

	public Plateau getPlateau(){
		return this.tableDeJeu;
	}

	public void passerAuProchainTour(){
	  // Les joueurs sont de 0 à X,
	  // mais il y aura X + 1 joueur vu que 0 est une valeur.
	  // +Basic 101 CS stuff dumbass+
	  if (this.tourDuJoueurX == nbJoueurs - 1) {
			this.tourDuJoueurX = 0;
	  } else {
	    this.tourDuJoueurX++;
	  }
	}

	// On crée les 28 dominos du jeu
	public ArrayList<Domino> genererLesDominos(){
		lesDominos = new ArrayList<Domino>();
	  for (int i = 0; i < 7 ; i++ ) {
	    for (int j = i; j < 7 ; j++ ) {
	      lesDominos.add(new Domino(i,j));
			}
		}
		/**
		* Retourne le pack de dominos
		* @return les dominos
		*/
		return lesDominos;
	}

	public void placerUnDomino(Domino pieceDuJoueur, int[] position){
	  	getTourDuJoueurX();
			this.tableDeJeu.addDomino(pieceDuJoueur);
	}
}
