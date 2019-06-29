package view;

import javax.swing.SwingUtilities;

import contract.IModel;

public final class View implements Runnable {


	private final ViewFrame viewFrame;

	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	public void run() {
		this.viewFrame.setVisible(true);
	}
}
