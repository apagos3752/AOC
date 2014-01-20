package v1.controller;

import java.util.Observable;

import v1.model.MoteurMetronome;
import v1.model.MoteurMetronomeImpl;
import v1.view.MoteurMetronomeView;

/**
 *  Controlleur de l'application
 */
 
public class MoteurMetronomeControllerImpl implements MoteurMetronomeController {
	
	private MoteurMetronomeView mmv;
	private MoteurMetronome mm;
	
	/**
	 *  Valeur max de la vitesse du tempo.
	 */
	private static int RANGE = 240;
	
	/**
	 *  Valeur min de la vitesse du tempo.
	 */
	private static int BASE = 60;
	
	public MoteurMetronomeControllerImpl(MoteurMetronomeView mmv, MoteurMetronome mm){
			this.mmv = mmv;
			this.mm = mm;
			((MoteurMetronomeImpl)mm).addObserver(this);
			this.setListeners();
			this.setCommandes();
	}
	
	
	/**
	 *  Methode qui met en place les commandes internes au controlleur.
	 */
	public void setCommandes() {
		mm.setCommandeMarquerMesure(new CommandeMarquerMesure(this));
		mm.setCommandeMarquerTemps(new CommandeMarquerTemps(this));	
	}
	
	
	/**
	 *  Methode qui injecte les listeners à la vue.
	 */
	@Override
	public void setListeners() {
		
		mmv.setMoletteListener(new MoletteListener(this,mmv));
		mmv.setDecListener(new DecListener(this));
		mmv.setIncListener(new IncListener(this));
		mmv.setStartListener(new StartListener(this));
		mmv.setStopListener(new StopListener(this));
		
	}

	/**
	 *  Contiens la suite d'action à effectuer pour marquer un temps.
	 */
	@Override
	public void marquerTemps() {
		mmv.flashLED(1);
		mmv.clic();
	}

	
	/**
	 *  Contiens la suite d'action à effectuer pour marquer une mesure.
	 */
	@Override
	public void marquerMesure() {
		mmv.flashLED(0);
	}

	/**
	 *  Contiens la suite d'action à effectuer pour decrementer la mesure
	 */
	@Override
	public void decMesure() {
		mm.setMesure(mm.getMesure()-1);
	}

	
	/**
	 *  Contiens la suite d'action à effectuer pour incrementer la mesure
	 */
	@Override
	public void incMesure() {
		mm.setMesure(mm.getMesure()+1);		
	}

	
	/**
	 *  Change le tempo 
	 *  @param tempo La valeur du tempo comprise entre 0 et 1
	 */
	@Override
	public void setTempo(float tempo) {
		//Calcul utilisé pour effectuer un % de l'écart entre la borne min et la bordne max
		mm.setTempo(Math.round(((RANGE-BASE)*tempo)+BASE));
	}

	/**
	 *  Contiens la suite d'action à effectuer pour demarrer le battement du tempo
	 */
	@Override
	public void start() {
		mm.setEtatMarche(true);
	}

	/**
	 *  Contiens la suite d'action à effectuer pour stopper le battement du tempo
	 */
	@Override
	public void stop() {
		mm.setEtatMarche(false);		
	}

	
	/**
	 *  Implementation de l'interface Observer
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		Integer newText = new Integer((int)((MoteurMetronome) arg0).getTempo());
		mmv.setText(newText.toString());	
	}

}
