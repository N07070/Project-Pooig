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
  public boolean positionEstBonne(Domino d){
    if (d.getPosition()[0][0] >= 0 && d.getPosition()[0][0] <= taille
    && d.getPosition()[0][1] >= 0 &&  d.getPosition()[0][1] <= taille) {
      if(d.getPosition()[1][0] >= 0 && d.getPosition()[1][0] <= taille
      && d.getPosition()[1][1] >= 0 && d.getPosition()[1][1] <= taille){
        if((d.getPosition()[1][0] == d.getPosition()[0][0] -1 || d.getPosition()[1][0] == d.getPosition()[0][0] +1)
        && (d.getPosition()[1][1] == d.getPosition()[0][1] -1 || d.getPosition()[1][1] == d.getPosition()[0][1] +1)){
          return true;
        }
      }
    }
    return false;
  }

  // Cette méthode ajoute le domino joué sur le plateau
  public void addDomino(Domino domJoue){
    if(positionEstBonne(domJoue)){
      dominos.add(domJoue);
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
