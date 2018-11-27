import java.util.*;

public class Plateau {

  // La taille du plateau est composé d'une hauteur, et d'un longueur.
  private int taille;

  // le plateau contient une série de dominos.
  private ArrayList <Domino> dominos;

  /* On créant le plateau, on fiche sa hauteur et sa largeur,
  et on crée une liste vide de dominos qu'on complétera au fur et à mesure de l'avancement du jeu. */
  public Plateau (int t){
    this.taille = t;
    this.dominos = new ArrayList <Domino>();
  }

  public int getTaille(){
    return this.taille;
  }

  // Détermine si le plateau est vide ou pas.
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

  public void addDomino(Domino domJoue){
    if(positionEstBonne(domJoue)){
      dominos.add(domJoue);
    }
  }

  // Retourne la liste de tous les dominos joués.
  public ArrayList <Domino> getDominos() {
    return this.dominos;
  }

  public int nbDominos(){
    return this.dominos.size();
  }
  // Donne le nombre de dominos dèja joués.
}
