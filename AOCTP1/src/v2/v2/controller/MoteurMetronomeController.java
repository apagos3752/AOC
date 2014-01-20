package v2.controller;

import java.util.Observable;
import java.util.Observer;

public interface MoteurMetronomeController extends Observer {
	public void setListeners();
	public void setCommandes();
	public void marquerTemps();
	public void marquerMesure();
	public void decMesure();
	public void incMesure();
	public void setTempo(float tempo);
	public void start();
	public void stop();
}
