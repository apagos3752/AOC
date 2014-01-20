package v1.controller;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import v1.view.MoteurMetronomeView;

public class MoletteListener implements ChangeListener{

	MoteurMetronomeController controller;
	MoteurMetronomeView view;
	
	public MoletteListener(MoteurMetronomeController ctrl, MoteurMetronomeView view){
		this.view = view;
		this.controller = ctrl;
		
	}
	

	@Override
	public void stateChanged(ChangeEvent e) {
		
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			controller.setTempo(view.getTempo());
		}
	}

}
