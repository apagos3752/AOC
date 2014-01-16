package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Afficheur;
import view.Clavier;
import model.MoteurMetronomeImpl;

public class DecListener implements MouseListener{


	private Clavier clavier;
	
	public DecListener(Clavier clavier){
		
		this.clavier = clavier;
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		clavier.setTrue(1);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		clavier.setFalse(1);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
