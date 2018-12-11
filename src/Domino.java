public class Domino {

	/**
	* Domino : implementation du pion de jeu
	* @param piece1 la premier pièce, au pièce gauche
	* @param piece2 la deuxième pièce, au pièce droite
	* @param orientation l'orientation de la pièce. 0 pour horizontale, 1 pour verticale
	* @author Nelson P
	*/

	private Piece piece1;
	private Piece piece2;
	private int orientation;

	/**
	* La position par défaut de toutes les pieces, qui n'ont pas encore été
	* pausé sur le plateau, est de 0,0.
	* @param val1 la valeur de gauche
	* @param val2 la valeur de droite
	*/

	public Domino(int val1, int val2) {
		this.piece1 = new Piece(0, 0, val1);
		this.piece2 = new Piece(0, 0, val2);
		this.orientation = 0;
	}

	public int getValeurPremierCote(){
		return this.piece1.getValeur();
	}

	public int getValeurDeuxiemeCote(){
		return this.piece2.getValeur();
	}

	// Vérifie que la piece jouée est compatible.
	public boolean estCompatible (Domino dom){
		if(this.piece2 == this.piece1){
			return true;
		} else return false;
	}

	public int[][] getPosition(){
		int[][] positionDomino = new int[2][2];
		positionDomino[0][0] = this.piece1.getX();
		positionDomino[0][1] = this.piece1.getY();
		positionDomino[1][0] = this.piece2.getX();
		positionDomino[1][1] = this.piece2.getY();

		return positionDomino;
	}


}
