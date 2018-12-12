import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DominoControleur implements ChangeListener {


	// Controleur se charger de récuperer les evements de la vue et de mettre
	// à jour le modèle
	private DominoView dView;

    public DominoControleur(DominoView view) {
        this.dView = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
		// Code du TP9 à virer, pour le moment il est là en référance
        // Modele m = view.getModele();
        // JSlider[] sliders = view.getSliders();
		//
        // float red = sliders[0].getValue();
        // float green = sliders[1].getValue();
        // float blue = sliders[2].getValue();
		//
		// // On divise par 100 pour avoir un float
        // red = red / 100;
        // green = green / 100;
        // blue = blue / 100;
		//
        // m.setRed(red);
        // m.setBlue(blue);
        // m.setGreen(green);


        dView.miseAJour();
    }
}
