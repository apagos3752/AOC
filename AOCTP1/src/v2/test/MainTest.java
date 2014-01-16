package test;

import model.MoteurMetronomeImpl;
import utils.Horloge;
import utils.HorlogeImpl;
import view.ClavierImpl;
import view.Materiel;
import adapteur.AdapteurImpl;
import adapteur.IAdapteur;
import controller.MoteurMetronomeController;
import controller.MoteurMetronomeControllerImpl;


public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Horloge h = new HorlogeImpl();
		Materiel.setUp(h);
		MoteurMetronomeImpl mmimpl = new MoteurMetronomeImpl();
		
		
		mmimpl.setHorloge(h);
		//mmimpl.setEtatMarche(true);
		
		MoteurMetronomeController mcci = new MoteurMetronomeControllerImpl(mmimpl);
	}

}
