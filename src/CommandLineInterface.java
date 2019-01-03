 import java.util.*;

public class CommandLineInterface {

	Jouer jeuEnCours;
	boolean continueLeJeu = true;

	public CommandLineInterface(){
		Scanner scan = new Scanner(System.in);

		commencerLeJeu(scan);
        aide();

		while (continueLeJeu) {
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
						jouer(scan);
						break;
					default:
						break;
				}
			}
		}

        finDuJeu();
	}

	public boolean verifierEntreeUtilisateur(String entreeUtilisateur){
		if (entreeUtilisateur.length() < 1){
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

	public void jouer(Scanner scan){
		while (jeuEnCours.getJoueurX(jeuEnCours.getTourDuJoueurX()).getMainDuJoueur().size() != 0 ){
			// String ANSI_CLS = "\u001b[2J";
			// String ANSI_HOME = "\u001b[H";
			// System.out.print(ANSI_CLS + ANSI_HOME);
			// System.out.flush();
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
			placerUnDomino(scan, joueurCourant);
			// On passe au prochain tour
			jeuEnCours.passerAuProchainTour();
		}

        continueLeJeu = false;
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
        int i = 0;
		for( Domino d : j.getMainDuJoueur()){
			System.out.print(Integer.toString(i) + ") ["+ d.getValeurPremierCote() +"|"+ d.getValeurDeuxiemeCote() +"], ");
            i++;
            if( i % 5 == 0 ){
                System.out.println();
            }
        }
	}

	public void afficherLePlateau(){
		// La taille du plateau n'a pas vocation à évoluer durant la partie
		String[][] plateau = new String[this.jeuEnCours.getPlateau().getTaille() + 1][this.jeuEnCours.getPlateau().getTaille() + 1];

		if (this.jeuEnCours.getPlateau().isEmpty()){
			// Comme le plateau est un carré, on se fait pas chier
			for (int x = 0; x <= this.jeuEnCours.getPlateau().getTaille(); x++ ) {
				for (int y = 0; y <= this.jeuEnCours.getPlateau().getTaille(); y++ ) {
                    if (y == 0 && x == 0) {
                        plateau[x][y] = " x\\y ";
                    } else if (x == 0) {
                        plateau[x][y] = " "+ y +" ";
                    } else if (y == 0){
                        plateau[x][y] = " "+ x +" ";
                    } else {
                        plateau[x][y] = "[ ]";
                    }
				}
			}

			for (int x = 0; x <= this.jeuEnCours.getPlateau().getTaille(); x++ ) {
				for (int y = 0; y <= this.jeuEnCours.getPlateau().getTaille(); y++ ) {
					System.out.print(plateau[x][y]);
				}
				System.out.println();
			}


		} else {
			ArrayList<Domino> dominoSurLePlateau = this.jeuEnCours.getPlateau().getDominos();
			for (Domino d : dominoSurLePlateau ) {
				// Pour chaque domino, on récupère la position de la pièce 1 et 2, que l'on place
				// à la positio i,j respective
				plateau[d.getPremierPiece().getX()][d.getPremierPiece().getY()] = "[" + Integer.toString(d.getPremierPiece().getValeur()) + "]";
				plateau[d.getDeuxiemePiece().getX()][d.getDeuxiemePiece().getY()] = "[" + Integer.toString(d.getDeuxiemePiece().getValeur()) + "]";
			}

			for (int x = 0; x <= this.jeuEnCours.getPlateau().getTaille(); x++ ) {
				for (int y = 0; y <= this.jeuEnCours.getPlateau().getTaille(); y++ ) {
                    if (y == 0) {
                        plateau[x][y] = " "+ x +" ";
                    } else if (x == 0) {
                        plateau[x][y] = " "+ y +" ";
                    } else if (plateau[x][y] == null) {
						plateau[x][y] = "[ ] ";
					}
				}
			}

			for (int x = 0; x <= this.jeuEnCours.getPlateau().getTaille(); x++ ) {
				for (int y = 0; y <= this.jeuEnCours.getPlateau().getTaille(); y++ ) {
					System.out.print(plateau[x][y]);
				}
				System.out.println();
			}
		}
	}


	public void placerUnDomino(Scanner scan, Joueur joueurCourant){
		System.out.println();
		System.out.println(">> Quel domino voulez-vous placer ?");
		System.out.print(">> ");
		// On récupère le Domino X
		int idDominoAPlacer = scan.nextInt();
		while (idDominoAPlacer < 0 || idDominoAPlacer > joueurCourant.getNombrePiecesRestantes()){
			System.out.println();
			System.out.println(">> Quel domino voulez-vous placer ?");
			System.out.print(">> ");
			idDominoAPlacer = scan.nextInt();
		}

		int[] localisationDeLaPremierPieceDuDomino = new int[2];
		System.out.println(">> Où voulez-vous le placer ?");
		System.out.print(" >> En X :");
		localisationDeLaPremierPieceDuDomino[0] = scan.nextInt();
		System.out.print(" >> En Y :");
		localisationDeLaPremierPieceDuDomino[1] = scan.nextInt();

		while (localisationDeLaPremierPieceDuDomino[0] < 0 || localisationDeLaPremierPieceDuDomino[0] > jeuEnCours.getPlateau().getTaille()
			|| localisationDeLaPremierPieceDuDomino[1] < 0 || localisationDeLaPremierPieceDuDomino[1] > jeuEnCours.getPlateau().getTaille()){
			System.out.println(">> Où voulez-vous le placer ?");
			System.out.print(" >> En X : ");
			localisationDeLaPremierPieceDuDomino[0] = scan.nextInt();
			System.out.print(" >> En Y : ");
			localisationDeLaPremierPieceDuDomino[1] = scan.nextInt();
		}

		System.out.println(">> Dans quel position ?\n >> 0 : Nord\n >> 1 : Est\n >> 2 : Sud\n >> 3 : Ouest");
		System.out.print(" >> ");
		int orientationDuDomino = scan.nextInt();
		while (orientationDuDomino < 0 || orientationDuDomino > 3){
			System.out.println(">> Dans quel position ?\n >> 0 : Nord\n >> 1 : Est\n >> 2 : Sud\n >> 3 : Ouest");
			System.out.print(" >> ");
			orientationDuDomino = scan.nextInt();
		}

		if (this.jeuEnCours.getPlateau().addDomino(joueurCourant.getDominoNumero(idDominoAPlacer), localisationDeLaPremierPieceDuDomino, orientationDuDomino)) {
			afficherLePlateau();
		} else {
			System.out.println(">> La position du Domino est illégal... Veulliez recommencer.");
			placerUnDomino(scan, joueurCourant);
		}
	}
}
