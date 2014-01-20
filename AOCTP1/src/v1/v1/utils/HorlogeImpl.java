package v1.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.Timer;

import v1.controller.Commande;

/**
 *  Horloge de l'application
 */
public class HorlogeImpl implements Horloge{
	
	//Liste des commandes lancées périodiquement
	private HashMap<Commande,Timer> hm;
	
	public HorlogeImpl() {
		hm = new HashMap<Commande,Timer>();
	}

	/**
	 *  Ajoute une commande à lancer périodiquement
	 *  @param cmd La commande à lancer périodiquement
	 *  @param periodeActivation l'écart entre chaque lancement en millisecondes
	 */
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

	/**
	 *  Lance une commande après un délai
	 *  @param cmd La commande à lancer 
	 *  @param delai le délai avant le lancement en millisecondes
	 */
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

	/**
	 *  Désactive le lancement périodique d'une commande
	 *  @param cmd La commande à désactiver
	 */
	@Override
	public void desactiverCommande(Commande cmd) {
		hm.get(cmd).stop();
		hm.remove(cmd);
	}


}
