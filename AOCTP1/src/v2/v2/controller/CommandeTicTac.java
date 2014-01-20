package v2.controller;

import v2.model.MoteurMetronome;

public class CommandeTicTac implements Commande {

	private MoteurMetronome mm;
	
	public CommandeTicTac(MoteurMetronome mm){
		this.mm = mm;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		mm.tictac();
	}

}
