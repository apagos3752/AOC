package controller;

import adapteur.IAdapteur;
import view.MoteurMetronomeView;

public class CommandeEteindreLED implements Commande {

	int ledNumber;	
	IAdapteur mmv;
	
	public CommandeEteindreLED (int ledNumber, IAdapteur mmv){
		
		this.mmv = mmv;
		
		
		this.ledNumber = ledNumber;
		
	}
	
	@Override
	public void execute() {
		
		mmv.ledOFF(ledNumber);
		
	}

}
