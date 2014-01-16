package adapteur;

import utils.Horloge;
import view.Materiel;

public interface IAdapteur {

	void checkMateriel();

	void setHorloge(Horloge h);

	void setMateriel(Materiel m);

	void flashLED(int i);

	void clic();

	void setText(String string);

	void ledOFF(int i);

}
