public class Main {
	public static void main(String[] args) {
	  CommandLineInterface j1 = new CommandLineInterface();
		DominoModele t = new DominoModele();
		DominoView test = new DominoView(t);
		test.setVisible(true);
	}
}
