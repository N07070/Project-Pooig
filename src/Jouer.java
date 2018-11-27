import java.util.ArrayList;
import java.util.Random;

public class Jouer {

	private int nbJoueurs;
	private ArrayList<Joueur> joueurListe;
	private int tourCourant;
    private int tourDuJoueurX;
    private Plateau tableDeJeu;

	public Jouer(int nbJoueurs, int tailleDuPlateau){
        this.nbJoueurs = nbJoueurs;
        this.tableDeJeu = new Plateau(tailleDuPlateau, tailleDuPlateau);
        
        ArrayList<Domino> lesDominos = genererLesDominos();

        // On init les joueurs
		if (nbJoueurs > 0 && nbJoueurs <= 4) {
			for (int i = 0; i < nbJoueurs; i++) {
                // On récupère une partie du total des dominos pour chaque joueurs
                // TODO : optimiser cette partie
                int nombreDeDominoParJoueurs = (int) lesDominos.size() / nbJoueurs;
                ArrayList<Domino> dominosPourJoueur = new ArrayList<Domino>;

                for (int j = 0 ; j <= nombreDeDominoParJoueurs ; j++ ) {
                    Random numAlea = new Random(lesDominos.size());
                    dominosPourJoueur.add(lesDominos.get(numAlea));
                    lesDominos.remove(numAlea);
                }

                this.joueurListe.add(new Joueur(dominosPourJoueur));
            }
		}

        // Initialiser le tour courant
        this.tourCourant = 0;

        // On choisit un joueur au hasard pour commencer
        this.tourDuJoueurX = new Random.nextInt(nbJoueurs);
    }

	public ArrayList<Joueur> getJoueurListe(){
		return this.joueurListe;
	}

	public int getTourCourant(){
		return this.tourCourant;
	}

    public int getTourDuJoueurX(){
        return this.tourDuJoueurX;
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

    // On creer les 28 dominos du jeu
    public ArrayList<Domino> genererLesDominos(){
        lesDominos = new ArrayList<Domino>();
        for (int i = 0; i < 7 ; i++ ) {
            for (int j = 0; j < 7 ; j++ ) {
                lesDominos.add(new Domino(i,j));
            }
        }

        // Rends les domino !!!
        return lesDominos;
    }

    public void placerUnDomino(Domino pieceAJoueur, int[] position){
        getTourDuJoueurX()

        /* Prendre en compte plusieurs choses :
            - Est-ce que y'a déjà des domino sur la table
                - Si oui, il faut que le placement soit adjacent à un Domino
            - Est-ce que on peut placer le domino
        */
    }

}
