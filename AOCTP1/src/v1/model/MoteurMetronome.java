package model;

import controller.Commande;

public interface MoteurMetronome {

	public double getTempo();
	public int getTempoParMesure();
	public void setTempo(float tempo);
	public void setEtatMarche(boolean etat);
	public void tictac();
	void setCommandeMarquerMesure(Commande cmd);
	void setCommandeMarquerTemps(Commande cmd);
	void setCommandeTicTac(Commande cmd);
	
}
