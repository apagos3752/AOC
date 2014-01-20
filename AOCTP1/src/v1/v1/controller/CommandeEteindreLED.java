package v1.controller;

import v1.view.MoteurMetronomeView;

public class CommandeEteindreLED implements Commande {

	int ledNumber;	
	MoteurMetronomeView mmv;
	public CommandeEteindreLED (int ledNumber,MoteurMetronomeView mmv){
		
		this.mmv = mmv;
		this.ledNumber = ledNumber;
		
	}
	
	@Override
	public void execute() {
		
		mmv.LEDOff(ledNumber);
		
	}

}
