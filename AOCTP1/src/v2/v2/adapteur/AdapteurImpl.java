package v2.adapteur;

import v2.controller.Commande;
import v2.controller.CommandeCheckMateriel;
import v2.controller.CommandeEteindreLED;
import v2.controller.MoteurMetronomeController;
import v2.utils.Horloge;
import v2.view.Materiel;

/**
 *  Classe adaptant l'interface au controlleur
 */
public class AdapteurImpl implements IAdapteur{

		private Commande commandeCheckMateriel;
		private Horloge horloge;
		private MoteurMetronomeController mmc;
		private float lastTempo;
		
		public AdapteurImpl(MoteurMetronomeController mmc){
			this.commandeCheckMateriel = new CommandeCheckMateriel(this);
			this.mmc = mmc;
			this.horloge = Materiel.getHorloge();
			this.horloge.activerPeriodiquement(commandeCheckMateriel, 10);
			this.lastTempo = 0;
		}
		
		/**
		 *  Methode s'occupant de regarder si l'état de l'interface à changé
		 *  
		 */
		@Override
		public void checkMateriel() {
			for(int i=0; i < 4; i++){
				if(	Materiel.getClavier().touchePressee(i) ){
					switch(i){
						case 0: mmc.incMesure();break;
						case 1: mmc.decMesure();break;
						case 2: mmc.start();break;
						case 3: mmc.stop();break;
					}
				}
			}
			
			float currentTempo = Materiel.getMolette().position();
			
			if(lastTempo != currentTempo){
				mmc.setTempo(currentTempo);
				lastTempo = currentTempo;
			}
		}

		@Override
		public void setHorloge(Horloge h) {
			this.horloge = h;
		}
		
		
		/**
		 *  Methode détaillant les différentes actions à effectuer pour faire flasher une LED
		 *  @param i Le numéro de la LED à flasher
		 */
		@Override
		public void flashLED(int i) {
			Materiel.getAfficheur().allumerLED(i);
			horloge.activerApresDelai(new CommandeEteindreLED(i,this), 50);
		}

		/**
		 *  Methode détaillant les différentes actions à effectuer pour faire éteindre une LED
		 *  @param i Le numéro de la LED à éteindre
		 */
		@Override
		public void ledOFF(int i) {
			Materiel.getAfficheur().eteindreLED(i);			
		}


		/**
		 *  Methode détaillant les différentes actions à effectuer pour faire un clic sonore
		 *  
		 */
		@Override
		public void clic() {
			Materiel.getEmetteurSonore().emettreClic();
		}

		
		/**
		 *  Methode modifiant l'affichage de l'afficheur de la vue
		 *  @param tempo le text à afficher
		 */
		@Override
		public void setText(String tempo) {
			Materiel.getAfficheur().afficherTempo(Integer.parseInt(tempo));
		}
}
