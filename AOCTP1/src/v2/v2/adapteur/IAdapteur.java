package v2.adapteur;

import v2.utils.Horloge;

public interface IAdapteur {

	void checkMateriel();

	void setHorloge(Horloge h);

	void flashLED(int i);

	void clic();

	void setText(String string);

	void ledOFF(int i);

}
