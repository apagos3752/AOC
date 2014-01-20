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
		// TODO Auto-generated method stub		
		MoteurMetronomeViewImpl mmvi = new MoteurMetronomeViewImpl();
		mmvi.setVisible(true);
		
		MoteurMetronomeImpl mmimpl = new MoteurMetronomeImpl();
		
		Horloge h = new HorlogeImpl();
		
		mmimpl.setHorloge(h);
		mmvi.setHorloge(h);
		//mmimpl.setEtatMarche(true);
		
		MoteurMetronomeController mcci = new MoteurMetronomeControllerImpl(mmvi,mmimpl);
	}

}
