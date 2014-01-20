package test;

import model.MoteurMetronomeImpl;
import utils.Horloge;
import utils.HorlogeImpl;
import view.MoteurMetronomeViewImpl;
import controller.CommandeMarquerMesure;
import controller.CommandeMarquerTemps;
import controller.CommandeTicTac;
import controller.MoteurMetronomeController;
import controller.MoteurMetronomeControllerImpl;


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
