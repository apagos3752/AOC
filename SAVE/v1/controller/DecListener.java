package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.MoteurMetronomeImpl;

public class DecListener implements MouseListener{


	MoteurMetronomeControllerImpl controller;
	
	public DecListener(MoteurMetronomeControllerImpl ctrl){
		
		this.controller = ctrl;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		controller.decMesure();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
