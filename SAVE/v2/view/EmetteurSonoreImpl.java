package view; 

public class EmetteurSonoreImpl implements EmetteurSonore {

	private MoteurMetronomeView mmv;

	public EmetteurSonoreImpl(MoteurMetronomeView mmv) {
		this.mmv = mmv;
	}

	@Override
	public void emettreClic() {
		mmv.clic();
	}

}
