 import java.util.*;

public class CommandLineInterface {

	Jouer jeuEnCours;
	boolean continueLeJeu = true;

	public CommandLineInterface(){
		Scanner scan = new Scanner(System.in);
		commencerLeJeu(scan);

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
						break;
					case "joueur":
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

		while (tailleDuPlateau < 10 && tailleDuPlateau > 100) {
			System.out.println(">> Le plateau doit faire quel taille ? ( Entre 10 et 100 )");
			System.out.print(">> ");
			tailleDuPlateau = scan.nextInt();
		}

		while (nbrJoueurs < 2 && nbrJoueurs > 4) {
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
		if (this.jeuEnCours.getPlateau().isEmpty()){
			for (int i = 0; i < this.jeuEnCours.getPlateau().getTaille(); i++ ) {
				for (int j = 0 ; j < this.jeuEnCours.getPlateau().getTaille() ; j ++  ) {
					// Bordure du plateau
					if (i == 0 || i == this.jeuEnCours.getPlateau().getTaille()  - 1) {
						System.out.println("bordure");
					}
				}
			}
		}
	}
}
