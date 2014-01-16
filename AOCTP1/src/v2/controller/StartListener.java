package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Clavier;
import model.MoteurMetronomeImpl;

public class StartListener implements MouseListener{


	private Clavier clavier;
	
	public StartListener(Clavier clavier){
		
		this.clavier = clavier;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mousePressed(MouseEvent e) {
		clavier.setTrue(2);		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		clavier.setFalse(2);		
	}

}
