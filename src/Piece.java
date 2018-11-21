public class Piece {

	/**
	* class Piece qui contient la valeur de la piece et sa position
	* @author Nelson P et Mehdi X
	* @param valeur une valeur entre 0 et 6
	* @param position une array contenant la position x en position 0 et y en position 1
	*
	*/

	private int valeur;
	private int[] position = new int[2];

	protected Piece(int x, int y, int valeur){
		this.position[0] = x;
		this.position[1] = y;
		this.valeur = valeur;
	}

	protected int getX(){
		return this.position[0];
	}

	protected void setPosition(int x, int y){
		this.position[0] = x;
		this.position[1] = y;
	}

	protected int getY(){
		return this.position[1];
	}

	protected int getValeur(){
		return this.valeur;
	}
}
