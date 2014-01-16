package view;

public class ClavierImpl implements Clavier {

	private Boolean[] tab;
	@Override
	public Boolean touchePressée(int i) {
		return tab[i];
	}

}
