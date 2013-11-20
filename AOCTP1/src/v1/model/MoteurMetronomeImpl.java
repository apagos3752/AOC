package model;

import java.util.Hashtable;
import java.util.Observable;

import utils.Horloge;
import controller.Commande;

public class MoteurMetronomeImpl extends Observable implements MoteurMetronome {
	private double tempo;
	private int mesure;
	private int tempoLaps;
	private boolean etat;
	private Horloge horloge;
	private Commande commandeMarquerMesure;
	private Commande commandeMarquerTemps;
	private Commande commandeTicTac;
	
	public MoteurMetronomeImpl(){
		this.tempo = 60.0;
		this.mesure = 4;
		this.tempoLaps = 0;
		this.etat = false;
	}
	
	@Override
	public double getTempo() {
		return tempo;
	}

	@Override
	public int getTempoParMesure() {
		return mesure;
	}

	@Override
	public void setTempo(float tempo) {
		this.tempo = tempo;
	}

	@Override
	public void setEtatMarche(boolean etat) {
		if(etat){
			double top = 60/tempo;
			horloge.activerPeriodiquement(commandeTicTac, top);	
		}
		else{
			//horloge.desactiverCommande(commandeTicTac);
		}

		this.etat = etat;
	}

	@Override
	public void setCommandeMarquerMesure(Commande cmd){
		commandeMarquerMesure = cmd;
	}
	
	@Override
	public void setCommandeMarquerTemps(Commande cmd){
		commandeMarquerTemps = cmd;
	}
	
	@Override
	public void setCommandeTicTac(Commande cmd){
		commandeTicTac = cmd;
	}
	
	public void setHorloge(Horloge h){
		horloge = h;
	}
	
	public void tictac(){
		commandeMarquerTemps.execute();
		tempoLaps++;
		
		if(tempoLaps == mesure){
			commandeMarquerMesure.execute();
			tempoLaps = 0;
		}
	}	

}
