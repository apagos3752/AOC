package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.*;

public class MoteurMetronomeViewImpl extends JFrame implements MoteurMetronomeView {

	JButton inc;
	JButton dec;
	JButton start;
	JButton stop;
	JSlider molette;
	JPanel tempo;
	JPanel mesure;
	
	public MoteurMetronomeViewImpl(){
		
		this.setUp();
		
	}
	
	public void setUp(){
		
		this.setSize(400, 300);
		this.setPreferredSize(getSize());
		
		//Initialisation des objets		
		inc = new JButton("inc");
		dec = new JButton("dec");
		start = new JButton("start");
		stop = new JButton("stop");
		molette = new JSlider(0, 1, 0);
		
		//Mise en place du Layout
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//Mise en place du panel principal
		
		//Mise en place du Slider
		molette.setPaintTicks(true);
		molette.setSize(250, 30);
		molette.setPreferredSize(molette.getSize());
		
		//ajout des composants
		JPanel southPanel = new JPanel();

		southPanel.setLayout(new BorderLayout());
		JPanel southPanelBot = new JPanel();
		JPanel southPanelTop = new JPanel();
		
		southPanelBot.add(inc);
		southPanelBot.add(dec);	
		southPanelBot.add(start);
		southPanelBot.add(stop);
		southPanelTop.add(molette);
				
		southPanel.add(southPanelBot, BorderLayout.SOUTH);
		southPanel.add(southPanelTop, BorderLayout.NORTH);
		
		this.add(southPanel,BorderLayout.SOUTH);
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
