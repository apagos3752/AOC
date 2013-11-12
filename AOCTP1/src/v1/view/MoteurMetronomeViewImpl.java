package view;

import javax.swing.JFrame;

public class MoteurMetronomeViewImpl extends JFrame implements MoteurMetronomeView {

	public MoteurMetronomeViewImpl(){
		
		this.setUp();
		
	}
	
	public void setUp(){
		
		this.setSize(500, 500);
		this.setPreferredSize(getSize());
		
	}
	
	@Override
	public void marquerTemps() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIncListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStartListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStopListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMoletteListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDecListener() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		
		MoteurMetronomeViewImpl mmvi = new MoteurMetronomeViewImpl();
		mmvi.setVisible(true);

	}

}
