package view;

public class ClavierImpl implements Clavier {

	private Boolean[] tab = new Boolean[4];
	@Override
	public Boolean touchePressée(int i) {
		return tab[i];
	}
	@Override
	public void setTrue(int i) {
		tab[i] = true;
	}
	@Override
	public void setFalse(int i) {
		tab[i] = false;
	}

}
