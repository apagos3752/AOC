package test;

import model.MoteurMetronomeImpl;
import utils.Horloge;
import utils.HorlogeImpl;
import view.MoteurMetronomeViewImpl;
import controller.CommandeMarquerMesure;
import controller.CommandeMarquerTemps;
import controller.CommandeTicTac;


public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		
		MoteurMetronomeViewImpl mmvi = new MoteurMetronomeViewImpl();
		mmvi.setVisible(true);
		
		MoteurMetronomeImpl mmimpl = new MoteurMetronomeImpl();
		
		Horloge h = new HorlogeImpl();
		
		CommandeMarquerMesure marquerMesure = new CommandeMarquerMesure();
		CommandeMarquerTemps marquerTemps = new CommandeMarquerTemps();
		CommandeTicTac tictac = new CommandeTicTac(mmimpl);
		
		mmimpl.setHorloge(h);
		mmimpl.setCommandeMarquerMesure(marquerMesure);
		mmimpl.setCommandeMarquerTemps(marquerTemps);
		mmimpl.setCommandeTicTac(tictac);
		mmimpl.setEtatMarche(true);
	}

}
