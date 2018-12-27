 import java.util.*;

public class CommandLineInterface {

	Jouer jeuEnCours;
	boolean continueLeJeu = true;

	public CommandLineInterface(){
		Scanner scan = new Scanner(System.in);

		commencerLeJeu(scan);

		while (continueLeJeu) {
			System.out.println();
			System.out.print(">> ");
			String entreeUtilisateur = scan.nextLine();
			if (verifierEntreeUtilisateur(entreeUtilisateur)) {
				// Déroulement de la partie
				switch (entreeUtilisateur){
					case "quitter":
						quitterLeJeu();
						break;
					case "aide":
						aide();
						break;
					case "jouer":
						jouer();
						break;
					default:
						break;
				}
			}
		}
	}

	public boolean verifierEntreeUtilisateur(String entreeUtilisateur){
		if (entreeUtilisateur.length() < 1){
			aide();
			return false;
		} else {
			return true;
		}
	}

	public void commencerLeJeu(Scanner scan){
		System.out.println(" ====== DOMINO - Pretty Oblivious Overshot Irritant Game EDITION ======");

		int tailleDuPlateau = 0;
		int nbrJoueurs = 0;

		while (tailleDuPlateau < 5 || tailleDuPlateau > 100) {
			System.out.println(">> Le plateau doit faire quel taille ? ( Entre 5 et 100 )");
			System.out.print(">> ");
			tailleDuPlateau = scan.nextInt();
		}

		while (nbrJoueurs < 2 || nbrJoueurs > 4) {
			System.out.println(">> Combien de joueurs ? ( 2 à 4)");
			System.out.print(">> ");
			nbrJoueurs = scan.nextInt();
		}

		this.jeuEnCours = new Jouer(tailleDuPlateau, nbrJoueurs);
	}

	public void jouer(){
		// Si il joueur n'a plus de Domino, on arrête le jeu.
		for ( Joueur j : jeuEnCours.getJoueurListe() ) {
			if (j.getMainDuJoueur().size() == 0) {
				// Fin du jeu.
				finDuJeu();
			}
		}

		// Récuperer le tour du joueur courant
		Joueur joueurCourant = jeuEnCours.getJoueurX(jeuEnCours.getTourDuJoueurX());
		// Faire jouer le joueur
		System.out.println(">> C'est au tour du joueur " + joueurCourant.getIdJoueur());
		// Montrer le plateau
		afficherLePlateau();
		// Montrer au joueur ses dominos
		System.out.println();
		System.out.println(">> Main courrante du joueur : ");
		afficherLaMainDuJoueur(joueurCourant);
		// Demander au joueur d'un placer un
		// joueurCourant.placerUnDomino();
		// On passe au prochain tour
		jeuEnCours.passerAuProchainTour();

	}

	public void quitterLeJeu(){
		this.continueLeJeu = false;
	}

	public void aide(){
		System.out.println("quitter - quitte le jeu");
		System.out.println("aide - affiche cette aide");
		System.out.println("jouer - commencer à jouer");
	}

	public void finDuJeu(){
		System.out.println("Merci d'avoir joué !");
	}

	public void afficherLaMainDuJoueur(Joueur j){
		for(Domino d : j.getMainDuJoueur()){
			System.out.print("["+ d.getValeurPremierCote() +"|"+ d.getValeurDeuxiemeCote() +"], ");
		}
	}

	public void afficherLePlateau(){
		// La taille du plateau n'a pas vocation à évoluer durant la partie
		String[][] plateau = new String[this.jeuEnCours.getPlateau().getTaille()][this.jeuEnCours.getPlateau().getTaille()];

		if (this.jeuEnCours.getPlateau().isEmpty()){
			// Comme le plateau est un carré, on se fait pas chier
			for (int x = 0; x < this.jeuEnCours.getPlateau().getTaille(); x++ ) {
				for (int y = 0; y < this.jeuEnCours.getPlateau().getTaille(); y++ ) {
					plateau[x][y] = "[ ]";
				}
			}

			for (int x = 0; x < this.jeuEnCours.getPlateau().getTaille(); x++ ) {
				for (int y = 0; y < this.jeuEnCours.getPlateau().getTaille(); y++ ) {
					System.out.print(plateau[x][y]);
				}
				System.out.println();
			}


		} else {
			ArrayList<Domino> dominoSurLePlateau = this.jeuEnCours.getPlateau().getDominos();
			for (Domino d : dominoSurLePlateau ) {
				// Pour chaque domino, on récupère la position de la pièce 1 et 2, que l'on place
				// à la positio i,j respective
				plateau[d.getPremierPiece().getX()][d.getPremierPiece().getY()] = Integer.toString(d.getPremierPiece().getValeur());
			}
		}
	}


	public void placerUnDomino(){
		System.out.println(">> Quel domino voullez-vous placer ?");

		System.out.println(">> Où voulez-vous le placer ?");

		System.out.println(">> Dans quel position ?");
	}
}
