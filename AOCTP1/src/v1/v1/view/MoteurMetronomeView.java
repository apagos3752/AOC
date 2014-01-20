package v1.view;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;
public interface MoteurMetronomeView{
	
	public void setIncListener(MouseListener ml);
	
	public void setStartListener(MouseListener ml);
	
	public void setStopListener(MouseListener ml);
	
	public void setMoletteListener(ChangeListener cl);
	
	public void setDecListener(MouseListener ml);

	public float getTempo();

	public void setUp();
	
	public void LEDOff(int ledNumber);
	
	public void flashLED(int ledNumber);
	
	public void setText(String txt);
	
	public void clic();
	
}
