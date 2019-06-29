package view;

import contract.IModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;


class ViewFrame extends JFrame {

	private IModel	model;
	private static final long serialVersionUID	= -697358409737458175L;


	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	protected IModel getModel() {
		return this.model;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		try {
			this.setIconImage(ImageIO.read(new File("thermometre.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Station Météo");
		this.setBackground(Color.gray);
		this.setContentPane(new ViewPanel(this));
		this.setSize(800 + this.getInsets().left + this.getInsets().right, 750 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
	}
}
