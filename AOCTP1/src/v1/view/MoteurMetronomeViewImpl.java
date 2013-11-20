package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.*;

public class MoteurMetronomeViewImpl extends JFrame implements MoteurMetronomeView {

	Integer INITMESURE = new Integer(4);
	String MESUREPREFIX = "1|";
	JButton inc;
	JButton dec;
	JButton start;
	JButton stop;
	JSlider molette;
	JPanel tempo;
	JPanel mesure;
	JLabel mesureTxt;
	Font mesureTxtFont;
	
	public MoteurMetronomeViewImpl(){
		
		this.setUp();
		
	}
	
	public void setUp(){
		
		this.setSize(350, 240);
		this.setPreferredSize(getSize());
		
		//Initialisation des objets		
		inc = new JButton("inc");
		dec = new JButton("dec");
		start = new JButton("start");
		stop = new JButton("stop");
		molette = new JSlider(0, 1000, 0);
		tempo = new JPanel();
		tempo.setSize(100, 100);
		tempo.setPreferredSize(tempo.getSize());
		mesure = new JPanel();
		mesure.setSize(100, 100);
		mesure.setPreferredSize(mesure.getSize());
		mesureTxt = new JLabel("1|"+this.INITMESURE.toString());
		mesureTxt.setSize(100,100);
		mesureTxt.setPreferredSize(mesureTxt.getSize());
		mesureTxtFont = new Font("", 1, 60);
		mesureTxt.setFont(mesureTxtFont);
		mesureTxt.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		JPanel northPanel = new JPanel();
		
		northPanel.setLayout(new BorderLayout());
		
		tempo.setBackground(Color.decode("#c0362c"));
		mesure.setBackground(Color.decode("#c0362c"));
		
		northPanel.add(tempo,BorderLayout.WEST);
		northPanel.add(mesure,BorderLayout.EAST);
		northPanel.add(mesureTxt,BorderLayout.CENTER);
		
		this.add(southPanel,BorderLayout.SOUTH);
		this.add(northPanel,BorderLayout.NORTH);
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
