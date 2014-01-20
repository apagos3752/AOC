package v1.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class StopListener implements MouseListener{


	MoteurMetronomeControllerImpl controller;
	
	public StopListener(MoteurMetronomeControllerImpl ctrl){
		
		this.controller = ctrl;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		controller.stop();
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
