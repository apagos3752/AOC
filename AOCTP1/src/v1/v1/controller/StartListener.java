package v1.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartListener implements MouseListener{


	MoteurMetronomeControllerImpl controller;
	
	public StartListener(MoteurMetronomeControllerImpl ctrl){
		
		this.controller = ctrl;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		controller.start();
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
