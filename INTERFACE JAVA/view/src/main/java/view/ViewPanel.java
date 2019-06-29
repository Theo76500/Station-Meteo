package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

class ViewPanel extends JPanel implements Observer {

	private ViewFrame viewFrame;
	private static final long serialVersionUID	= -998294702363713521L;

	private Image thermometre;
	private Image humidity;
	private Font police;
	private boolean observerSet = false;

	ViewPanel(final ViewFrame viewFrame) {

		this.setViewFrame(viewFrame);
		setObservateur();
		try {
			thermometre = ImageIO.read(new File("thermometre.png"));
			humidity = ImageIO.read(new File("humidity.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	public void setObservateur() {
		viewFrame.getModel().getObservable().addObserver(this);
		this.observerSet = true;
	}

	@Override
	protected void paintComponent(final Graphics graphics) {

		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.drawImage(thermometre, 0, 0, 350, 350, this);
		graphics.drawImage(humidity, 70, 400, 194, 259, this);
		Font font = new Font("TimesRoman", Font.BOLD, 100);
		graphics.setFont(font);
		graphics.setColor(Color.black);

		graphics.drawString(" = ", 250, 200);
		graphics.drawString(" = ", 250, 580);

		graphics.drawString(String.valueOf(this.getViewFrame().getModel().getTemperature() + " °C"), 400, 200);
		graphics.drawString(String.valueOf(this.getViewFrame().getModel().getHumidity() + " %"), 400, 580);

		repaint();
	}
}
