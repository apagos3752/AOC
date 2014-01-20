package v1.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.Timer;

import v1.controller.Commande;

public class HorlogeImpl implements Horloge{
	
	private HashMap<Commande,Timer> hm;
	
	public HorlogeImpl() {
		hm = new HashMap<Commande,Timer>();
	}

	@Override
	public void activerPeriodiquement(final Commande cmd, double periodeActivation) {
		
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd.execute();
			}
		};	
		
		Timer t = new Timer((int) periodeActivation, taskPerformer);
		t.start();
		hm.put(cmd, t);
		
	}

	@Override
	public void activerApresDelai(final Commande cmd, double delai) {
		
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd.execute();
			}
		};
		
		Timer t = new Timer((int) delai, taskPerformer);
		t.setRepeats(false);
		t.start();
	}

	@Override
	public void desactiverCommande(Commande cmd) {
		hm.get(cmd).stop();
		hm.remove(cmd);
	}


}
