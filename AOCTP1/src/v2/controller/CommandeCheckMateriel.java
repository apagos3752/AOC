package controller;

import adapteur.IAdapteur;

public class CommandeCheckMateriel implements Commande {

	private IAdapteur adapteur;
	
	@Override
	public void execute() {
		adapteur.checkMateriel();
	}
	
	
}
