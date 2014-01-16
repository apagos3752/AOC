package test;

import model.MoteurMetronomeImpl;
import utils.Horloge;
import utils.HorlogeImpl;
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
		Materiel m = new Materiel(h);
		MoteurMetronomeImpl mmimpl = new MoteurMetronomeImpl();
		
		
		mmimpl.setHorloge(h);
		//mmimpl.setEtatMarche(true);
		
		MoteurMetronomeController mcci = new MoteurMetronomeControllerImpl(m,mmimpl);
	}

}
