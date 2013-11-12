package model;

import controller.Command;

public class MoteurMetronomeImpl implements MoteurMetronome {
	private double tempo;
	private int mesure;
	private boolean etat;
	
	public MoteurMetronomeImpl(){
		this.tempo = 100.0;
		this.mesure = 4;
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
	public void setGestionTempsMesure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEtatMarche(boolean etat) {
		this.etat = etat;
	}

	@Override
	public void setCommand(Command cmd, String commandName) {
		
	}

}
