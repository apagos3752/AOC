package view;

public class AfficheurImpl implements Afficheur {

	private MoteurMetronomeView mmv;

	public AfficheurImpl(MoteurMetronomeView mmv) {
		this.mmv = mmv;
	}

	@Override
	public void allumerLED(int numLED) {
		mmv.LEDOn(numLED);
	}

	@Override
	public void eteindreLED(int numLED) {
		mmv.LEDOff(numLED);
	}

	@Override
	public void afficherTempo(int valeurTempo) {
		Integer txt = new Integer(valeurTempo);
		mmv.setText(txt.toString());
	}

}
