package controller;

import java.util.Observable;

import adapteur.IAdapteur;
import adapteur.AdapteurImpl;

import model.MoteurMetronome;
import model.MoteurMetronomeImpl;
import view.Materiel;
import view.MoteurMetronomeView;

public class MoteurMetronomeControllerImpl implements MoteurMetronomeController {
	
	private MoteurMetronome mm;
	private IAdapteur mmv;
	private static int RANGE = 240;
	private static int BASE = 60;
	
	public MoteurMetronomeControllerImpl(MoteurMetronome mm){
			this.mm = mm;
			((MoteurMetronomeImpl)mm).addObserver(this);
			this.setCommandes();
			this.mmv = new AdapteurImpl(this);
	}
	
	public void setCommandes() {
		mm.setCommandeMarquerMesure(new CommandeMarquerMesure(this));
		mm.setCommandeMarquerTemps(new CommandeMarquerTemps(this));	
	}

	@Override
	public void marquerTemps() {
		mmv.flashLED(1);
		mmv.clic();
	}

	@Override
	public void marquerMesure() {
		mmv.flashLED(0);
	}

	@Override
	public void decMesure() {
		mm.setMesure(mm.getMesure()-1);
	}

	@Override
	public void incMesure() {
		mm.setMesure(mm.getMesure()+1);		
	}

	@Override
	public void setTempo(float tempo) {
		
		mm.setTempo(Math.round(((RANGE-BASE)*tempo)+BASE));
	}

	@Override
	public void start() {
		mm.setEtatMarche(true);
	}

	@Override
	public void stop() {
		mm.setEtatMarche(false);		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Integer newText = new Integer((int)((MoteurMetronome) arg0).getTempo());
		mmv.setText(newText.toString());	
	}

	@Override
	public void setListeners() {
		// TODO Auto-generated method stub
		
	}

}
