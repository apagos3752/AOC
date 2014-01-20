package v2.view;

import v2.utils.Horloge;

public class Materiel {
	
	private static Horloge h;
	private static Clavier clavier;
	private static Molette molette;
	private static EmetteurSonore emetteur;
	private static Afficheur afficheur;
	private static MoteurMetronomeView mmv;
	
	public static void setUp(Horloge h){
		
		Materiel.mmv = new MoteurMetronomeViewImpl();
		Materiel.h = h;
		Materiel.clavier = new ClavierImpl();
		Materiel.molette = new MoletteImpl(mmv);
		Materiel.emetteur = new EmetteurSonoreImpl(mmv);
		Materiel.afficheur = new AfficheurImpl(mmv);
		
	}
	
	public static Horloge getHorloge(){return h;};
	public static Clavier getClavier(){return clavier;};
	public static Molette getMolette(){return molette;};
	public static EmetteurSonore getEmetteurSonore(){return emetteur;};
	public static Afficheur getAfficheur(){return afficheur;};
}
