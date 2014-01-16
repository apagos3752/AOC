package view;

public class ClavierImpl implements Clavier {

	private boolean[] tab;
	
	public ClavierImpl(){
		tab = new boolean[4];
		
		for(int i=0; i<4; i++) tab[i] = new Boolean(false);
	}
	@Override
	public Boolean touchePressee(int i) {
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
