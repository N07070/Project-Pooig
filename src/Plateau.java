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
		boolean adjacenceOK = false;

		// On vérifie que la première pièce du domino est bien inscrite dans le plateau
		// C'est à dire que la position donnée par la joueur est bonne
		// Et on vérifie que les valeurs cote à cote sont similaires #adjacenceOK dans le même switch

		if (pos[0] >= 0 && pos[0] < this.taille
			&& pos[1] >= 0 && pos[1] < this.taille) {
			// On vérifie ensuite en fonction de l'orientation
			switch(orientation) {
				case 0: // Nord y - 1
					if (pos[0] >= 0 && pos[0] < this.taille
						&& pos[1] - 1 >= 0 && pos[1] - 1 < this.taille) {
						orientationOK = true;
						posP2[0] = pos[0];
						posP2[1] = pos[1] - 1;
					}
					if (dominos.get(pos[1]-1).getValeurDeuxiemeCote() == d.getValeurPremierCote()){
						adjacenceOK = true;
					}
					break;
				case 1: // Est x+1
					if (pos[0] + 1 >= 0 && pos[0] + 1 < this.taille
						&& pos[1]>= 0 && pos[1]< this.taille) {
						orientationOK = true;
						posP2[0] = pos[0] + 1;
						posP2[1] = pos[1];
					}
					if (dominos.get(pos[0]+1).getValeurDeuxiemeCote() == d.getValeurPremierCote()){
						adjacenceOK = true;
					}
					break;
				case 2: // Sud y + 1
					if (pos[0] >= 0 && pos[0] < this.taille
						&& pos[1] + 1 >= 0 && pos[1] + 1 < this.taille) {
						orientationOK = true;
						posP2[0] = pos[0];
						posP2[1] = pos[1] + 1;
					}
					if (dominos.get(pos[1]+1).getValeurDeuxiemeCote() == d.getValeurPremierCote()){
						adjacenceOK = true;
					}
					break;
				case 3: // Ouest x - 1
					if (pos[0] - 1 >= 0 && pos[0] - 1 < this.taille
						&& pos[1] >= 0 && pos[1] < this.taille) {
						orientationOK = true;
						posP2[0] = pos[0] - 1;
						posP2[1] = pos[1];
					}
					if (dominos.get(pos[0]-1).getValeurDeuxiemeCote() == d.getValeurPremierCote()){
						adjacenceOK = true;
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
		if (orientationOK && adjacenceOK) {
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
	// Cette méthode ajoute le domino joué sur le plateau
	public boolean addDomino(Domino domJoue, int[] pos, int orientation){
		if(positionEstBonne(domJoue, pos, orientation)){
			domJoue.setPosition(pos, orientation);
		  	dominos.add(domJoue);
		  	return true;
	  } else {
		  return false;
	  }
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
