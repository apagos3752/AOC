package v2.controller;

public class CommandeMarquerTemps implements Commande {

	private MoteurMetronomeController mmc;

	public CommandeMarquerTemps(MoteurMetronomeController mmc){
		
		this.mmc = mmc;
		
	}
	
	@Override
	public void execute() {
		mmc.marquerTemps();
	}

}
