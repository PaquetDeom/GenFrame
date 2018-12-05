package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import fr.paquet.frame.Frame;
import fr.paquet.ihm.frame.PanelGlobal;


public class ActionNouveau extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ActionNouveau() {
		super();
		putValue(NAME, "Nouveau");
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Frame frame = new Frame();
		PanelGlobal pG = new PanelGlobal(frame);
		
		pG.setVisible(true);

	}



	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

}
