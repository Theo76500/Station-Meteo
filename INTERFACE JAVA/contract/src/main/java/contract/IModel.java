package contract;

import java.util.Observable;

public interface IModel {

	Observable getObservable();
	float getTemperature();
	int getHumidity();

	void action(String valeur);
}
