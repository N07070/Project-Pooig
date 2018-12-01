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
					default:
						break;
				}
			}
		}
	}

	public boolean verifierEntreeUtilisateur(String entreeUtilisateur){
		if (entreeUtilisateur.length() < 1){
			System.out.println("Veuillez entrer du texte.");
			return false;
		} else {
			return true;
		}
	}

	public void commencerLeJeu(Scanner scan){
		System.out.println(" ====== DOMINO - Pretty Oblivious Overshot Irritant Game EDITION ======");

		int tailleDuPlateau;
		int nbrJoueurs;

		do {
			System.out.println("\n>> Le plateau doit faire quel taille ? ( Entre 10 et 100 )");
			System.out.print(">> ");
			tailleDuPlateau = scan.nextInt();
		} while (tailleDuPlateau < 10 && tailleDuPlateau > 100);

		do {
			System.out.println("\n>> Combien de joueurs ? ( 2 à 4)");
			System.out.print(">> ");
			nbrJoueurs = scan.nextInt();
		} while (nbrJoueurs < 2 && nbrJoueurs > 4);

		this.jeuEnCours = new Jouer(tailleDuPlateau, nbrJoueurs);
	}

	public void poserUnDomino(){

		System.out.println("Merci d'avoir joué !");
	}

	public void quitterLeJeu(){
		this.continueLeJeu = false;
	}

	public void aide(){
		System.out.println("quitter - Quitte le jeu.");
		System.out.println("aide - affiche cette aide");
		System.out.println("");
	}

	public void afficherLePlateau(){
		this.jeuEnCours.getPlateau().getTaille();
	}
}
