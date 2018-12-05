package fr.paquet.ihm.frame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.frame.Frame;
import fr.paquet.ihm.main.MainFrame;

public class PanelGlobal extends JPanel {

	/**
	 * @author paquet
	 */

	private static final long serialVersionUID = 1L;
	private Frame frame = null;
	private PanelConstruction panelConstruction = null;

	/**
	 * Constructeur de la class<br/>
	 * 
	 * @param panelEntete
	 */
	public PanelGlobal(Frame frame) {

		super();
		setFrame(frame);
		MainFrame.getUniqInstance().add(this);

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Données du projet"));
		setLayout(new GridBagLayout());

		// creation du panel resp
		setPanelConstruction(new PanelConstruction(this));

		// Affichage des component sur la panelProj
		add(getPanelConstruction(), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		add(new JPanel(), new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.LAST_LINE_START,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

	}

	private PanelConstruction getPanelConstruction() {
		return panelConstruction;
	}

	private void setPanelConstruction(PanelConstruction panelConstruction) {
		this.panelConstruction = panelConstruction;
	}

	public Frame getFrame() {
		return frame;
	}

	private void setFrame(Frame frame) {
		this.frame = frame;
	}

	/**
	 * 
	 * @return le Panel de l'entête<br/>
	 */

}
