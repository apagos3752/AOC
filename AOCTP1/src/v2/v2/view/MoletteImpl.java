package v2.view;

public class MoletteImpl implements Molette {

	private MoteurMetronomeView mmv;

	public MoletteImpl(MoteurMetronomeView mmv) {
		this.mmv = mmv;
	}

	@Override
	public float position() {
		return mmv.getTempo();
	}

}
