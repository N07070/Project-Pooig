import java.util.*;

public class Plateau {
	/**
	* Classe Plateau : Surface de jeu
	* @author Mehdi
	* @param taille la taille du plateau est composé d'une hauteur, et d'un longueur.
	* @param dominos Le plateau contient une série de dominos (les joués)
	*/
	private int taille;
	private ArrayList<Domino> dominos;

	/* On créant le plateau, on fiche sa hauteur et sa largeur,
	et on crée une liste vide de dominos qu'on complétera au fur et à mesure de l'avancement du jeu. */
	public Plateau (int t){
		this.taille = t;
		this.dominos = new ArrayList <Domino>();
	}

	/**
	* @return taille du Plateau
	*/

	public int getTaille(){
		return this.taille;
	}

	/**
	* @return Si le plateau est vide ou pas
	*/

	public boolean isEmpty(){
		return this.dominos.isEmpty();
	}

	// Fonction qui vérifie que le domino est bien dans le plateau.
	public boolean positionEstBonne(Domino d, int[] pos, int orientation) {
		// Pour rappel : pos[0] = x, pos[1] = y,
		// Orientation  Nord -> 0, Est-> 1, Sud -> 2, Ouest-> 3
		int[] posP2 = new int[2];
		boolean orientationOK = false;

		// On vérifie que la première pièce du domino est bien inscrite dans le plateau
		// C'est à dire que la position donnée par le joueur est bonne
		if (pos[0] > 0 && pos[0] <= this.taille
			&& pos[1] > 0 && pos[1] <= this.taille) {
			// On vérifie ensuite en fonction de l'orientation
			switch(orientation) {
				case 0: // Nord y - 1
					if (pos[0] >= 0 && pos[0] < this.taille
						&& pos[1] - 1 >= 0 && pos[1] - 1 < this.taille) {
						orientationOK = true;
						posP2[0] = pos[0];
						posP2[1] = pos[1] - 1;
					}
					break;
				case 1: // Est x+1
					if (pos[0] + 1 >= 0 && pos[0] + 1 < this.taille
						&& pos[1]>= 0 && pos[1]< this.taille) {
						orientationOK = true;
						posP2[0] = pos[0] + 1;
						posP2[1] = pos[1];
					}
					break;
				case 2: // Sud y + 1
					if (pos[0] >= 0 && pos[0] < this.taille
						&& pos[1] + 1 >= 0 && pos[1] + 1 < this.taille) {
						orientationOK = true;
						posP2[0] = pos[0];
						posP2[1] = pos[1] + 1;
					}
					break;
				case 3: // Ouest x - 1
					if (pos[0] - 1 >= 0 && pos[0] - 1 < this.taille
						&& pos[1] >= 0 && pos[1] < this.taille) {
						orientationOK = true;
						posP2[0] = pos[0] - 1;
						posP2[1] = pos[1];
					}
					break;
				default:
					return false;
				}
			} else {
				return false;
			}

		// On vérifie pour les deux pièces du domino
		// qu'elles ne sont pas sur une autre pièce.
		if (orientationOK) {
			for (Domino dominoSurLePlateau : dominos ) {
				if (dominoSurLePlateau.getPremierPiece().getX() == pos[0]
				|| dominoSurLePlateau.getPremierPiece().getY() == pos[1]
				|| dominoSurLePlateau.getDeuxiemePiece().getX() == posP2[0]
				|| dominoSurLePlateau.getDeuxiemePiece().getY() == posP2[1]) {
					return false;
				}
			}
			return  true;
		} else {
			return false;
		}
	}

	public boolean estAdjacent(Domino domJoue, int[] pos, int orientation){
		// Vérifie si la position donnée pour un domino est
		// adjacente à un domino sur le plateau
		// et que la valeur de la position adjacente est bonne
		boolean estAdja = false;
		int[] posP1 = new int[2];
		int[] posP2 = new int[2];

		posP1 = pos;

		switch(orientation) {
			case 0: // Nord y - 1
				posP2[0] = pos[0];
				posP2[1] = pos[1] - 1;
				break;
			case 1: // Est x+1
				posP2[0] = pos[0] + 1;
				posP2[1] = pos[1];
				break;
			case 2: // Sud y + 1
				posP2[0] = pos[0];
				posP2[1] = pos[1] + 1;
				break;
			case 3: // Ouest x - 1
				posP2[0] = pos[0] - 1;
				posP2[1] = pos[1];
				break;
			default:
				return false;
			}

		if (dominos.size() == 0) {
			estAdja = true;
		} else {
			for (Domino dominoSurLePlateau : dominos ) {
				// On vérifie pour la première pièce
				// On vérifie pour la position donnée que il existe au moins un
				// domino sur le plateau qui soit adjacent

				// Première pièce du domino équivalente à la première pièce d'un domino adja
				// en haut

				// Première pièce du domino pausée sur le plateau

				//		   [x,y-1]
				//	[x-1,y][ x,y ][x+1,y]
				//		   [x,y+1]

				if (orientation != 0 && dominoSurLePlateau.getPremierPiece().getX() == posP1[0]
				&& dominoSurLePlateau.getPremierPiece().getY() - 1 == posP1[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurPremierCote()) {
					estAdja = true;
				} else if (orientation != 2 && dominoSurLePlateau.getPremierPiece().getX() == posP1[0]
				&& dominoSurLePlateau.getPremierPiece().getY() + 1 == posP1[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurPremierCote()){
					estAdja = true;
				} else if (orientation != 3 && dominoSurLePlateau.getPremierPiece().getX() - 1 == posP1[0]
				&& dominoSurLePlateau.getPremierPiece().getY()== posP1[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurPremierCote()){
					estAdja = true;
				} else if(orientation != 1 && dominoSurLePlateau.getPremierPiece().getX() + 1 == posP1[0]
				&& dominoSurLePlateau.getPremierPiece().getY()== posP1[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurPremierCote()){
					estAdja = true;
				} else {
					System.out.println("Y'a un bug dans ta fonction coco.");
				}

				if (orientation != 2 && dominoSurLePlateau.getPremierPiece().getX() == posP2[0]
				&& dominoSurLePlateau.getPremierPiece().getY() - 1 == posP2[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurDeuxiemeCote()) {
					estAdja = true;
				} else if (orientation != 0 && dominoSurLePlateau.getPremierPiece().getX() == posP2[0]
				&& dominoSurLePlateau.getPremierPiece().getY() + 1 == posP2[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurDeuxiemeCote()){
					estAdja = true;
				} else if (orientation != 1 && dominoSurLePlateau.getPremierPiece().getX() - 1 == posP2[0]
				&& dominoSurLePlateau.getPremierPiece().getY()== posP2[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurDeuxiemeCote()){
					estAdja = true;
				} else if(orientation != 3 && dominoSurLePlateau.getPremierPiece().getX() + 1 == posP2[0]
				&& dominoSurLePlateau.getPremierPiece().getY()== posP2[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurDeuxiemeCote()){
					estAdja = true;
				} else {
					System.out.println("Y'a un bug dans ta fonction coco.");
				}

				// Deuxième pièce des domino du plateau

				if (orientation != 0 && dominoSurLePlateau.getDeuxiemePiece().getX() == posP1[0]
				&& dominoSurLePlateau.getDeuxiemePiece().getY() - 1 == posP1[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurPremierCote()) {
					estAdja = true;
				} else if (orientation != 2 && dominoSurLePlateau.getDeuxiemePiece().getX() == posP1[0]
				&& dominoSurLePlateau.getDeuxiemePiece().getY() + 1 == posP1[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurPremierCote()){
					estAdja = true;
				} else if (orientation != 3 && dominoSurLePlateau.getDeuxiemePiece().getX() - 1 == posP1[0]
				&& dominoSurLePlateau.getDeuxiemePiece().getY()== posP1[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurPremierCote()){
					estAdja = true;
				} else if(orientation != 1 && dominoSurLePlateau.getDeuxiemePiece().getX() + 1 == posP1[0]
				&& dominoSurLePlateau.getDeuxiemePiece().getY()== posP1[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurPremierCote()){
					estAdja = true;
				} else {
					System.out.println("Y'a un bug dans ta fonction coco.");
				}

				if (orientation != 2 && dominoSurLePlateau.getDeuxiemePiece().getX() == posP2[0]
				&& dominoSurLePlateau.getDeuxiemePiece().getY() - 1 == posP2[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurDeuxiemeCote()) {
					estAdja = true;
				} else if (orientation != 0 && dominoSurLePlateau.getDeuxiemePiece().getX() == posP2[0]
				&& dominoSurLePlateau.getDeuxiemePiece().getY() + 1 == posP2[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurDeuxiemeCote()){
					estAdja = true;
				} else if (orientation != 1 && dominoSurLePlateau.getDeuxiemePiece().getX() - 1 == posP2[0]
				&& dominoSurLePlateau.getDeuxiemePiece().getY()== posP2[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurDeuxiemeCote()){
					estAdja = true;
				} else if(orientation != 3 && dominoSurLePlateau.getDeuxiemePiece().getX() + 1 == posP2[0]
				&& dominoSurLePlateau.getDeuxiemePiece().getY()== posP2[1]
				&& dominoSurLePlateau.getValeurPremierCote() == domJoue.getValeurDeuxiemeCote()){
					estAdja = true;
				} else {
					System.out.println("Y'a un bug dans ta fonction coco.");
				}
			}
		}

		return estAdja;
	}

	// /* Cette fonction vérifie que la valeur de la première pièce
	// présente sur le plateau et celle de la pièce à poser est
	// la même (Si l'utilisateur décide de la mettre au début) */
	// public boolean estAdjacentDébut(Domino d, int orientation){
	// 	if (dominos.get(0).getValeurPremierCote() == d.getValeurDeuxiemeCote()){
	// 		return true;
	// 	}
	// 	return false;
	// }
	//
	// /* Cette fonction vérifie que la valeur de la dernière pièce
	//  présente sur le plateau et celle de la pièce à poser est
	//  la même (Si l'utilisateur décide de la mettre à la fin) */
	// public boolean estAdjacentFin(Domino d, int orientation){
	// 	int k = dominos.size();
	// 	if (dominos.get(k).getValeurDeuxiemeCote() == d.getValeurPremierCote()){
	// 		return true;
	// 	}
	// 	return false;
	// }

	// Cette méthode ajoute le domino joué sur le plateau

	// && estAdjacent(domJoue, pos, orientation)
	public boolean addDomino(Domino domJoue, int[] pos, int orientation){
		if(positionEstBonne(domJoue, pos, orientation) && estAdjacent(domJoue, pos, orientation)){
			domJoue.setPosition(pos, orientation);
		  	dominos.add(domJoue);
		  	return true;
	  	}
		return false;
	}

	/**
	* @return la liste de tous les dominos joués.
	*/
	public ArrayList <Domino> getDominos() {
		return this.dominos;
	}

	/**
	* @return si le domino est déja joué
	*/
	public boolean dominoEstSurLePlateau(Domino dom){
		if(dominos.contains(dom)){
		  return true;
		} else return false;
	}

	/**
	* @return le nombre de dominos dèja joués.
	*/
	public int nbDominos(){
		return this.dominos.size();
	}
}
