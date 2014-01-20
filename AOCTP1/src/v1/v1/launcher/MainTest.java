package v1.launcher;

import v1.controller.MoteurMetronomeController;
import v1.controller.MoteurMetronomeControllerImpl;
import v1.model.MoteurMetronomeImpl;
import v1.utils.Horloge;
import v1.utils.HorlogeImpl;
import v1.view.MoteurMetronomeViewImpl;


public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//On crée la vue	
		MoteurMetronomeViewImpl mmvi = new MoteurMetronomeViewImpl();
		//On la rend visible
		mmvi.setVisible(true);
		
		//On crée le modèle
		MoteurMetronomeImpl mmimpl = new MoteurMetronomeImpl();
		
		//On crée l'horloge utilisé par l'application
		Horloge h = new HorlogeImpl();
		
		//On met en place l'horloge pour la vue et le modèle
		mmimpl.setHorloge(h);
		mmvi.setHorloge(h);

		//On crée le controlleur de l'application, qui s'occupera de la lancer.
		MoteurMetronomeController mcci = new MoteurMetronomeControllerImpl(mmvi,mmimpl);
	}

}
