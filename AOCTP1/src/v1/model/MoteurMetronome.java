package model;

import controller.Command;

public interface MoteurMetronome {

	public double getTempo();
	public int getTempoParMesure();
	public void setTempo(float tempo);
	public void setGestionTempsMesure();
	public void setEtatMarche(boolean etat);
	public void setCommand(Command cmd, String commandName);
	
}
