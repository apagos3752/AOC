package v1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import v1.controller.CommandeEteindreLED;
import v1.utils.Horloge;

/**
 *  Cette classe est la vue de l'application
 */
 
public class MoteurMetronomeViewImpl extends JFrame implements MoteurMetronomeView {

	/**
	 *  Horloge interne de la vue
	 */
	Horloge h;
	
	/**
	 *  Couleur représentant une LED allumée
	 */
	static Color LED_ON = Color.decode("#ff0000");
	
	/**
	 *  Couleur représentant une LED eteinte
	 */
	static Color LED_OFF = Color.decode("#a90b0b");
	
	/**
	 *  Defini la précision du slider (nombre de valeur)
	 */
	int ACCURACY = 180;
	
	
	//Composant graphiques
	JButton inc;
	JButton dec;
	JButton start;
	JButton stop;
	JSlider molette;
	JPanel tempo;
	JPanel mesure;
	JLabel mesureTxt;
	Font mesureTxtFont;
	ArrayList<JPanel> ledList;
	
	public MoteurMetronomeViewImpl(){
		
		this.setUp();
		
	}
	
	/**
	 *  Methode à utiliser pour injecter les listeners des différents bouttons
	 */
	public void setMoletteListener(ChangeListener cl){
		molette.addChangeListener(cl);
	}
	
	/**
	 *  Methode à utiliser pour injecter les listeners des différents bouttons
	 */
	public void setIncListener(MouseListener ml){
		inc.addMouseListener(ml);
	}
	
	/**
	 *  Methode à utiliser pour injecter les listeners des différents bouttons
	 */
	public void setDecListener(MouseListener ml){
		dec.addMouseListener(ml);
	}
	
	/**
	 *  Methode à utiliser pour injecter les listeners des différents bouttons
	 */
	public void setStartListener(MouseListener ml){
		start.addMouseListener(ml);
	}
	
	/**
	 *  Methode à utiliser pour injecter les listeners des différents bouttons
	 */
	public void setStopListener(MouseListener ml){
		stop.addMouseListener(ml);
	}
	
	/**
	 *  Methode détaillant les différentes actions à effectuer pour faire flasher une LED
	 *  @param ledNumber Le numéro de la LED à flasher
	 */
	public void flashLED(int ledNumber){
		JPanel led = ledList.get(ledNumber);
		led.setBackground(this.LED_ON);
		h.activerApresDelai(new CommandeEteindreLED(ledNumber,this), 50);
	}
	
	/**
	 *  Methode détaillant les différentes actions à effectuer pour faire éteindre une LED
	 *  @param ledNumber Le numéro de la LED à éteindre
	 */
	public void LEDOff(int ledNumber){
		
		JPanel led = ledList.get(ledNumber);
		led.setBackground(this.LED_OFF);
		
	}
	
	/**
	 *  Methode de mise en place de la vue
	 */
	public void setUp(){
		
		this.setSize(350, 240);
		this.setPreferredSize(getSize());
		
		//Initialisation des objets		
		inc = new JButton("inc");
		dec = new JButton("dec");
		start = new JButton("start");
		stop = new JButton("stop");
		molette = new JSlider(0, this.ACCURACY, 0);
		tempo = new JPanel();
		tempo.setSize(100, 100);
		tempo.setPreferredSize(tempo.getSize());
		mesure = new JPanel();
		mesure.setSize(100, 100);
		mesure.setPreferredSize(mesure.getSize());
		mesureTxt = new JLabel("60");
		mesureTxt.setSize(100,100);
		mesureTxt.setPreferredSize(mesureTxt.getSize());
		mesureTxtFont = new Font("", 1, 60);
		mesureTxt.setFont(mesureTxtFont);
		mesureTxt.setHorizontalAlignment(SwingConstants.CENTER);
		ledList = new ArrayList<JPanel>();
		ledList.add(mesure);
		ledList.add(tempo);
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
		
		tempo.setBackground(this.LED_OFF);
		mesure.setBackground(this.LED_OFF);
		
		northPanel.add(tempo,BorderLayout.EAST);
		northPanel.add(mesure,BorderLayout.WEST);
		northPanel.add(mesureTxt,BorderLayout.CENTER);
		
		this.add(southPanel,BorderLayout.SOUTH);
		this.add(northPanel,BorderLayout.NORTH);
	}

	/**
	 *  Retourne la valeur de la molette
	 *  @return la valeur de la molette
	 */
	public float getTempo() {
		return (float)molette.getValue()/this.ACCURACY;
	}

	/**
	 *  Met en place l'horloge interne de la vue
	 *  @param h l'horloge à utiliser
	 */
	public void setHorloge(Horloge h) {
		
		this.h = h;
		
	}
	
	/**
	 *  Methode modifiant l'affichage de l'afficheur de la vue
	 *  @param txt le text à afficher
	 */
	public void setText(String txt){
	
		this.mesureTxt.setText(txt);
		
	}

		/**
		 *  Methode détaillant les différentes actions à effectuer pour faire un clic sonore
		 *  
		 */
	public void clic(){
	
		Toolkit.getDefaultToolkit().beep();
		
	}
	
}
