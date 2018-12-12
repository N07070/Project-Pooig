import java.awt.*;

public class MainGUI {
	private DominoView v;
	private DominoModele m;

	public MainGUI(){
		this.m = new DominoModele();
		this.v = new DominoView(this.m);
		this.v.setVisible(true); // On affiche le l'interface
	}

	public static void main(String[] args) {
		// On creer un event queue pour ne pas modifier
		// deux element de l'UI en mm temps et crash
		EventQueue.invokeLater(() -> {
			MainGUI m = new MainGUI();
		});
	}
}
