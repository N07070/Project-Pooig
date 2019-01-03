public class Domino {

	/**
	* Domino : implementation du pion de jeu
	* @param piece1 la premier pièce, au pièce gauche
	* @param piece2 la deuxième pièce, au pièce droite
	* @param orientation l'orientation de la pièce.Nord -> 0, Est-> 1, Sud -> 2, Ouest-> 3
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

	/**
	* @return valeur premier coté du domino
	*/
	public int getValeurPremierCote(){
		return this.piece1.getValeur();
	}

	public Piece getPremierPiece(){
		return this.piece1;
	}

	/**
	* @return valeur deuxième coté du domino
	*/
	public int getValeurDeuxiemeCote(){
		return this.piece2.getValeur();
	}


	public Piece getDeuxiemePiece(){
		return this.piece2;
	}

	/**
	* @return valeur totale du domino
	*/
	public int getValeurTotale(){
		return getValeurPremierCote()+getValeurDeuxiemeCote();
	}

	/**
	* @return si le domino est un double (mêmes côtès)
	*/
	public boolean estDouble(){
		return this.piece1.getValeur() == this.piece2.getValeur();
	}

	/**
	* @return si la pièce à poser est compatible avec la pièce déja sur le plateau
	*/

	/**
	* @return la position du domino sur le plateau en tableau de tableau d'entiers
	*/
	public int[][] getPosition(){
		int[][] positionDomino = new int[2][2];
		positionDomino[0][0] = this.piece1.getX();
		positionDomino[0][1] = this.piece1.getY();
		positionDomino[1][0] = this.piece2.getX();
		positionDomino[1][1] = this.piece2.getY();

		return positionDomino;
	}

	public void setPosition(int[] position, int orientation){
		this.piece1.setPosition(position[0], position[1]);

		switch(orientation){
			case 0:
				this.piece2.setPosition(position[0] - 1, position[1]);
				break;
			case 1:
				this.piece2.setPosition(position[0], position[1] + 1);
				break;
			case 2:
				this.piece2.setPosition(position[0] + 1 , position[1]);
				break;
			case 3:
				this.piece2.setPosition(position[0], position[1] - 1);
				break;
		}

		this.orientation = orientation;
	}

}
