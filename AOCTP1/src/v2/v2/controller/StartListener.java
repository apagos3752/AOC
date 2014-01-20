package v2.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import v2.view.Materiel;

public class StartListener implements MouseListener{

	
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
		Materiel.getClavier().setTrue(2);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Materiel.getClavier().setFalse(2);

	}

}
