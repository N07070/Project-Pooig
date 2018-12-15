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
		System.out.println("Merci d'avoir joué !");
	}

	public void quitterLeJeu(){
		this.continueLeJeu = false;
	}

	public void aide(){
		System.out.println("quitter - quitte le jeu");
		System.out.println("aide - affiche cette aide");
		System.out.println("jouer - commencer à jouer");
	}

	public void afficherLePlateau(){
		this.jeuEnCours.getPlateau().getTaille();
	}
}
