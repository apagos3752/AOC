package v2.launcher;

import v2.controller.MoteurMetronomeController;
import v2.controller.MoteurMetronomeControllerImpl;
import v2.model.MoteurMetronomeImpl;
import v2.utils.Horloge;
import v2.utils.HorlogeImpl;
import v2.view.Materiel;


public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Horloge h = new HorlogeImpl();
		
		Materiel.setUp(h);
		
		MoteurMetronomeImpl mmimpl = new MoteurMetronomeImpl();
		mmimpl.setHorloge(h);
		
		MoteurMetronomeController mcci = new MoteurMetronomeControllerImpl(mmimpl);
	}

}
