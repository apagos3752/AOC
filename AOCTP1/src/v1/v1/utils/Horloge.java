package v1.utils;

import v1.controller.Commande;

/**
 *  Interface à implementer pour construire l'horloge de l'application
 */

public interface Horloge {

	public void activerPeriodiquement(Commande cmd, double periodeActivation);
	public void activerApresDelai(Commande cmd, double delai);
	public void desactiverCommande(Commande cmd);

}
