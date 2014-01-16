package model;

import controller.Commande;

public interface MoteurMetronome {

	public double getTempo();
	public int getTempoParMesure();
	public void setListeners();
	public void marquerTemps();
	public void marquerMesure();
	public void setTempo(float tempo);
	public int getMesure();
	public void setMesure(int mesure);
	public void setGestionTempsMesure();
	public void setEtatMarche(boolean etat);
	public void tictac();
	void setCommandeMarquerMesure(Commande cmd);
	void setCommandeMarquerTemps(Commande cmd);
	void setCommandeTicTac(Commande cmd);
	
}
