package v2.controller;

import v2.adapteur.IAdapteur;

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
