package v1.model;

import java.util.Observable;

import v1.controller.Commande;
import v1.controller.CommandeTicTac;
import v1.utils.Horloge;

/**
 *  Modèle de l'application
 */
 
public class MoteurMetronomeImpl extends Observable implements MoteurMetronome {

	/**
	 *  Valeur du tempo
	 */
	private double tempo;
	
	/**
	 *  Valeur de la mesure
	 */
	private int mesure;
	
	/**
	 *  Compteur de battements pour battre la mesure
	 */
	private int tempoLaps;
	
	/**
	 *  Etat actuel de l'application
	 */
	private boolean etat;
	
	/**
	 *  Horloge interne au modèle
	 */
	private Horloge horloge;
	
	/**
	 *  Les différente commandes internes au modèle
	 */
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

	/**
	 *  Retourne le tempo
	 *  @return tempo actuel
	 */
	@Override
	public double getTempo() {
		return tempo;
	}

	
	/**
	 *  Retourne la  mesure
	 *  @return Valeur actuelle de la mesure
	 */
	@Override
	public int getTempoParMesure() {
		return mesure;
	}

	
	/**
	 *  Met en place le tempo
	 *  @param tempo Le tempo à mettre en place. 
	 */
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

	/**
	 *  Allume ou etteind le métronome
	 *  @param etat change l'état à true ou false
	 */
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

	
	/**
	 *  Met en place la commande pour marquer la mesure
	 *  @param cmd la commande à utiliser
	 */
	@Override
	public void setCommandeMarquerMesure(Commande cmd) {
		commandeMarquerMesure = cmd;
	}

	/**
	 *  Met en place la commande pour marquer la tempo
	 *  @param cmd la commande à utiliser
	 */
	@Override
	public void setCommandeMarquerTemps(Commande cmd) {
		commandeMarquerTemps = cmd;
	}

	/**
	 *  Met en place la commande à lancer à chaque tic d'horloge
	 *  @param cmd la commande à utiliser
	 */
	@Override
	public void setCommandeTicTac(Commande cmd) {
		commandeTicTac = cmd;
	}

	/**
	 *  Met en place l'horloge interne
	 *  @param h L'horloge à utiliser
	 */
	
	public void setHorloge(Horloge h) {
		horloge = h;
	}

	/**
	 *  Liste d'action à faire à chaque tic d'horloge
	 *  
	 */
	public void tictac() {
		commandeMarquerTemps.execute();
		tempoLaps++;

		if (tempoLaps == mesure) {
			commandeMarquerMesure.execute();
			tempoLaps = 0;
		}
	}

	/**
	 *  Récupère la valeur de la mesure
	 *  @return la mesure actuelle
	 */
	@Override
	public int getMesure() {
		// TODO Auto-generated method stub
		return mesure;
	}

	/**
	 *  Met en place la valeur de la mesure
	 *  @param mesure la valeur de la mesure à set
	 */
	@Override
	public void setMesure(int mesure) {
		if (mesure > 0) {
			this.mesure = mesure;
			this.tempoLaps = mesure - 1;
		}
	}


}
