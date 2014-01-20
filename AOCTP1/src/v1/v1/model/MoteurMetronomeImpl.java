package v1.model;

import java.util.Observable;

import v1.controller.Commande;
import v1.controller.CommandeTicTac;
import v1.utils.Horloge;

public class MoteurMetronomeImpl extends Observable implements MoteurMetronome {
	private double tempo;
	private int mesure;
	private int tempoLaps;
	private boolean etat;
	private Horloge horloge;
	private Commande commandeMarquerMesure;
	private Commande commandeMarquerTemps;
	private Commande commandeTicTac;

	public MoteurMetronomeImpl() {
		this.tempo = 60.0;
		this.mesure = 4;
		this.tempoLaps = mesure - 1;
		this.etat = false;
		this.setCommandeTicTac(new CommandeTicTac(this));
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
		if (tempo > 0) {
			this.tempo = tempo;
			this.setChanged();
			if (etat) {
				horloge.desactiverCommande(commandeTicTac);
				double top = 60 / tempo;
				horloge.activerPeriodiquement(commandeTicTac, top * 1000);
			}
			this.notifyObservers(tempo);
		}
	}

	@Override
	public synchronized void setEtatMarche(boolean etat) {
		if (etat && this.etat != etat) {
			double top = 60 / tempo;
			horloge.activerPeriodiquement(commandeTicTac, top * 1000);

		} else if (this.etat != etat) {
			horloge.desactiverCommande(commandeTicTac);
		}
		this.etat = etat;
	}

	@Override
	public void setCommandeMarquerMesure(Commande cmd) {
		commandeMarquerMesure = cmd;
	}

	@Override
	public void setCommandeMarquerTemps(Commande cmd) {
		commandeMarquerTemps = cmd;
	}

	@Override
	public void setCommandeTicTac(Commande cmd) {
		commandeTicTac = cmd;
	}

	public void setHorloge(Horloge h) {
		horloge = h;
	}

	public void tictac() {
		commandeMarquerTemps.execute();
		tempoLaps++;

		if (tempoLaps == mesure) {
			commandeMarquerMesure.execute();
			tempoLaps = 0;
		}
	}

	@Override
	public int getMesure() {
		// TODO Auto-generated method stub
		return mesure;
	}

	@Override
	public void setMesure(int mesure) {
		if (mesure > 0) {
			this.mesure = mesure;
			this.tempoLaps = mesure - 1;
		}
	}


}
