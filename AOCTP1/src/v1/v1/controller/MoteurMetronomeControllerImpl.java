package v1.controller;

import java.util.Observable;

import v1.model.MoteurMetronome;
import v1.model.MoteurMetronomeImpl;
import v1.view.MoteurMetronomeView;

public class MoteurMetronomeControllerImpl implements MoteurMetronomeController {
	
	private MoteurMetronomeView mmv;
	private MoteurMetronome mm;
	private static int RANGE = 240;
	private static int BASE = 60;
	
	public MoteurMetronomeControllerImpl(MoteurMetronomeView mmv, MoteurMetronome mm){
			this.mmv = mmv;
			this.mm = mm;
			((MoteurMetronomeImpl)mm).addObserver(this);
			this.setListeners();
			this.setCommandes();
	}
	
	public void setCommandes() {
		mm.setCommandeMarquerMesure(new CommandeMarquerMesure(this));
		mm.setCommandeMarquerTemps(new CommandeMarquerTemps(this));	
	}

	@Override
	public void setListeners() {
		
		mmv.setMoletteListener(new MoletteListener(this,mmv));
		mmv.setDecListener(new DecListener(this));
		mmv.setIncListener(new IncListener(this));
		mmv.setStartListener(new StartListener(this));
		mmv.setStopListener(new StopListener(this));
		
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

}
