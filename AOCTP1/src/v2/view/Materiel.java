package view;

import utils.Horloge;

public class Materiel {
	
	private static Horloge h;
	private static Clavier clavier;
	private static Molette molette;
	private static EmetteurSonore emetteur;
	private static Afficheur afficheur;
	private static MoteurMetronomeView mmv;
	
	public Materiel(Horloge h){
		
		this.mmv = new MoteurMetronomeViewImpl();
		this.h = h;
		this.clavier = new ClavierImpl();
		this.molette = new MoletteImpl(mmv);
		this.emetteur = new EmetteurSonoreImpl(mmv);
		this.afficheur = new AfficheurImpl(mmv);
		
	}
	
	public static Horloge getHorloge(){return h;};
	public static Clavier getClavier(){return clavier;};
	public static Molette getMolette(){return molette;};
	public static EmetteurSonore getEmetteurSonore(){return emetteur;};
	public static Afficheur getAfficheur(){return afficheur;};
}
