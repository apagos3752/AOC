package adapteur;

import utils.Horloge;
import view.Materiel;
import controller.Commande;
import controller.CommandeCheckMateriel;
import controller.CommandeEteindreLED;
import controller.MoteurMetronomeController;

public class AdapteurImpl implements IAdapteur{

		private Commande commandeCheckMateriel;
		private Materiel materiel;
		private Horloge horloge;
		private MoteurMetronomeController mmc;
		private float lastTempo;
		
		public AdapteurImpl(Materiel materiel, MoteurMetronomeController mmc){
			this.commandeCheckMateriel = new CommandeCheckMateriel();
			this.materiel = materiel;
			this.mmc = mmc;
			this.horloge = this.materiel.getHorloge();
			this.horloge.activerPeriodiquement(commandeCheckMateriel, 100);
			this.lastTempo = 0;
		}
		
		@Override
		public void checkMateriel() {
			for(int i=0; i < 4; i++){
				if(	materiel.getClavier().touchePressee(i) ){
					switch(i){
						case 0: mmc.incMesure();break;
						case 1: mmc.decMesure();break;
						case 2: mmc.start();break;
						case 3: mmc.stop();break;
					}
				}
			}
			
			float currentTempo = materiel.getMolette().position();
			
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
		public void setMateriel(Materiel m) {
			this.materiel = m;
		}

		@Override
		public void flashLED(int i) {
			materiel.getAfficheur().allumerLED(i);
			horloge.activerApresDelai(new CommandeEteindreLED(i,this), 50);
		}
		
		@Override
		public void ledOFF(int i) {
			materiel.getAfficheur().eteindreLED(i);			
		}

		@Override
		public void clic() {
			materiel.getEmetteurSonore().emettreClic();
		}

		@Override
		public void setText(String tempo) {
			materiel.getAfficheur().afficherTempo(Integer.parseInt(tempo));
		}
}
