package view;

public class ClavierImpl implements Clavier {

	private Boolean[] tab;
	@Override
	public Boolean touchePress�e(int i) {
		return tab[i];
	}

}
