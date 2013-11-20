package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.Timer;

import controller.Commande;

public class HorlogeImpl implements Horloge{
	
	public HorlogeImpl() {
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


}
