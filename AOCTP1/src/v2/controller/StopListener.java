package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Clavier;



public class StopListener implements MouseListener{


	private Clavier clavier;
	
	public StopListener(Clavier clavier){
		
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
		clavier.setTrue(3);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		clavier.setFalse(3);
	}

}
