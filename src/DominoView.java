import java.awt.*;
import javax.swing.*;

public class DominoView extends JFrame {

	private static final int largeur = 900;
	private static final int hauteur = 700;
	private DominoModele modele;

	public DominoView (DominoModele md) {
		this.modele = md;

		// On créer la fenêtre pour contenir les différentes parties;
		// La première qui contient l'affichage du jeu courant,
		// La deuxieme avec les options du jeu.
		Container containerDomino = getContentPane();
		containerDomino.setLayout(new GridLayout(2,1));

		// On mets quelques paramètres par défault
		setSize(this.largeur, this.hauteur);
		setTitle("Domino - POOIG Edition");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		// On creer les deux panels;
		JPanel panelDuJeu = new JPanel();
		JPanel panelDesOptions = new JPanel();
		containerDomino.add(panelDuJeu);
		containerDomino.add(panelDesOptions);

		// On crée les boutons pour le panel des options
		JButton jouer = new JButton("Jouer");
		JButton aide = new JButton("Aide");
		JButton quitter = new JButton("Quitter");
		panelDesOptions.add(jouer);
		panelDesOptions.add(aide);
		panelDesOptions.add(quitter);


		// Couleur par défault avant que l'on fasse un choix.
		panelDuJeu.setBackground(Color.black);
		panelDesOptions.setBackground(Color.cyan);

		// On créer un nouveau controleur qui se chargera de
		// faire le lien entre les deux panels
		DominoControleur panelControl = new DominoControleur(this);


		// On fait la mise à jour du panel
		miseAJour();

	}

	public void miseAJour(){

	}

	public DominoModele getModele() {
		return modele;
	}
}
