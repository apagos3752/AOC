package v1.controller;



public class CommandeMarquerMesure implements Commande {

	
	private MoteurMetronomeController mmc;

	public CommandeMarquerMesure(MoteurMetronomeController mmc){
		
		this.mmc = mmc;
		
	}
	
	@Override
	public void execute() {
		mmc.marquerMesure();
	}

}
