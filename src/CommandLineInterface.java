import java.util.*;

public class CommandLineInterface {

	Joueur jeuEnCours;

	public CommandLineInterface(){
		Scanner scan = new Scanner(System.in);
		while (verifierEntreeUtilisateur(scan.nextLine())) {
			// Déroulement de la partie
			switch (scan.nextLine()){

			}
		}
	}

	public boolean verifierEntreeUtilisateur(String entreeUtilisateur){
		if (entreeUtilisateur.length() < 1){
			System.out.println("Veuilliez entrer du texte.");
			return false;
		} else {
			return true;
		}
	}

	public void afficherLePlateau(){
		this.jeuEnCours.getPlateau().getTaille();
	}
}
