package utils;

import controller.Commande;

public interface Horloge {

	public void activerPeriodiquement(Commande cmd, double periodeActivation);
	public void activerApresDelai(Commande cmd, double delai);
	public void desactiverCommande(Commande cmd);

}
