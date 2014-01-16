package view;

import utils.Horloge;

public class Materiel {
	
	private Horloge h;
	private Clavier clavier;
	private Molette molette;
	private EmetteurSonore emetteur;
	private Afficheur afficher;
	private MoteurMetronomeView mmv;
	
	public Materiel(Horloge h){
		
		this.mmv = new MoteurMetronomeViewImpl();
		this.h = h;
		this.clavier = new ClavierImpl();
		this.molette = new MoletteImpl(mmv);
		this.emetteur = new EmetteurSonoreImpl(mmv);
		this.afficher = new AfficheurImpl(mmv);
		
	}
	
	static Horloge getHorloge();
	static Clavier getClavier();
	static Molette getMolette();
	static EmetteurSonore getEmetteurSonore();
	static Afficheur getAfficheur();
}
