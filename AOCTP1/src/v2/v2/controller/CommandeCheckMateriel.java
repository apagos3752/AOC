package v2.controller;

import v2.adapteur.IAdapteur;

public class CommandeCheckMateriel implements Commande {

	private IAdapteur adapteur;
	
	public CommandeCheckMateriel(IAdapteur ad){
		this.adapteur = ad;
	}
	
	@Override
	public void execute() {
		adapteur.checkMateriel();
	}
	
	
}
