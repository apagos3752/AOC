package adapteur;

import utils.Horloge;
import view.Materiel;
import controller.Commande;
import controller.CommandeCheckMateriel;
import controller.CommandeEteindreLED;
import controller.MoteurMetronomeController;

public class AdapteurImpl implements IAdapteur{

		private Commande commandeCheckMateriel;
		private Horloge horloge;
		private MoteurMetronomeController mmc;
		private float lastTempo;
		
		public AdapteurImpl(MoteurMetronomeController mmc){
			this.commandeCheckMateriel = new CommandeCheckMateriel(this);
			this.mmc = mmc;
			this.horloge = Materiel.getHorloge();
			this.horloge.activerPeriodiquement(commandeCheckMateriel, 100);
			this.lastTempo = 0;
		}
		
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
		

		@Override
		public void flashLED(int i) {
			Materiel.getAfficheur().allumerLED(i);
			horloge.activerApresDelai(new CommandeEteindreLED(i,this), 50);
		}
		
		@Override
		public void ledOFF(int i) {
			Materiel.getAfficheur().eteindreLED(i);			
		}

		@Override
		public void clic() {
			Materiel.getEmetteurSonore().emettreClic();
		}

		@Override
		public void setText(String tempo) {
			Materiel.getAfficheur().afficherTempo(Integer.parseInt(tempo));
		}
}
