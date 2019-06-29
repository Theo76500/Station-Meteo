package model;

import com.fazecast.jSerialComm.SerialPort;
import contract.IModel;

import java.util.Observable;

public final class Model extends Observable implements IModel {

	private String message;
	public ArduinoUpdate arduinoUpdate;
	private Information info;
	private boolean infoSet = false;

	public Model() {
		SerialPort sp = SerialPort.getCommPort("COM9");
		sp.openPort();
		arduinoUpdate = new ArduinoUpdate(sp,this);
		sp.addDataListener(arduinoUpdate);
		setInformation();

	}

	private void setInformation() {
		this.info = new Information();
		this.infoSet = true;
	}

	public boolean getInfoSet() {
		return this.infoSet;
	}

	public Observable getObservable() {
		return info.getObservable();
	}

	public void action(String message) {
		this.message = message;
		String[] values = this.message.split("/");
		for (int i = 0; i < 2; i++) {
			try {
				switch (i) {
					case 0:
						this.info.setHumidity(values[i]);
						break;
					case 1:
						this.info.setTemperature(values[i]);
						break;
					default:
						break;
				}
			} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Input was not read !");
			}
		}
		this.info.setDonneesExiste(true);
	}

	public boolean close() {
		if (this.arduinoUpdate.ClosePort())
			return true;
		else
			return false;
	}

	public boolean open() {
		if (this.arduinoUpdate.OpenPort())
			return true;
		else
			return false;
	}

	public int getHumidity() {
		return this.info.getHumidity();
	}

	public float getTemperature() {
		return this.info.getTemperature();
	}


	public boolean getValeurExiste() {
		return arduinoUpdate.getValeurExiste();
	}

}
