package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Clavier;
import view.Materiel;



public class StopListener implements MouseListener{

	
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
		Materiel.getClavier().setTrue(3);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Materiel.getClavier().setFalse(3);
	}

}
