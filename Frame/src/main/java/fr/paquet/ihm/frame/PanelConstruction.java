package fr.paquet.ihm.frame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

public class PanelConstruction extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelGlobal panelGlobal = null;
	private JTextField url = null;
	private JTextField weight = null;
	private JTextField hight = null;
	private JButton buttonOk = null;

	public PanelConstruction(PanelGlobal panel) {
		super();
		setPanelGlobal(panel);
		setButtonOk(new JButton("Générer la frame"));
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
				"Données de pour construire une frame"));

		// layout
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);

		// Panel jLabel / JtextField
		AddLineJLabelJTextField lurl = new AddLineJLabelJTextField(this, "URL", "url : ", 20, 0, 0, 1, 1, 0, 0,
				GridBagConstraints.NONE);
		AddLineJLabelJTextField lWeight = new AddLineJLabelJTextField(this, "WEIGHT", "largeur : ", 20, 0, 1, 1, 1, 0,
				0, GridBagConstraints.NONE);
		AddLineJLabelJTextField lHight = new AddLineJLabelJTextField(this, "HIGHT", "hauteur : ", 20, 0, 2, 1, 1, 0, 0,
				GridBagConstraints.NONE);

		// set JTextField
		setUrl(lurl.getTextField());
		setWeight(lWeight.getTextField());
		setHight(lHight.getTextField());

		// ajout du bouton
		add(getButtonOk(), new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.LAST_LINE_END,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	}

	public PanelGlobal getPanelGlobal() {
		return panelGlobal;
	}

	private void setPanelGlobal(PanelGlobal panelGlobal) {
		this.panelGlobal = panelGlobal;
	}

	public JTextField getUrl() {
		return url;
	}

	private void setUrl(JTextField url) {

		url.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (url != null && !url.getText().equals(""))
					getPanelGlobal().getFrame().setUrl(url.getText());
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.url = url;
	}

	public JTextField getWeight() {
		return weight;
	}

	private void setWeight(JTextField weight) {

		weight.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (weight != null && !weight.getText().equals("")) {

					try {
						Double.parseDouble(weight.getText());
					} catch (Exception e1) {
						e1.printStackTrace(System.out);
						new AlertWindow(AlertType.ERREUR, "Vous devez saisir un nombre");
						weight.setText("");
					}
					getPanelGlobal().getFrame().setWeight(weight.getText());
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.weight = weight;
	}

	public JTextField getHight() {
		return hight;
	}

	private void setHight(JTextField hight) {

		hight.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (hight != null && !hight.getText().equals("")) {

					try {
						Double.parseDouble(hight.getText());
					} catch (Exception e1) {
						e1.printStackTrace(System.out);
						new AlertWindow(AlertType.ERREUR, "Vous devez saisir un nombre");
						hight.setText("");
					}

					getPanelGlobal().getFrame().setHight(hight.getText());

				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.hight = hight;
	}

	private JButton getButtonOk() {
		return buttonOk;
	}

	private void setButtonOk(JButton buttonOk) {
		buttonOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getPanelGlobal().getFrame().getFrame() != null) {

					Toolkit toolKit = Toolkit.getDefaultToolkit();
					Clipboard cb = toolKit.getSystemClipboard();
					cb.setContents(new StringSelection(getPanelGlobal().getFrame().getFrame()), null);
					new AlertWindow(AlertType.INFORMATION, "votre frame est copié dans le presse papier");

				} else {
					new AlertWindow(AlertType.ERREUR, "La frame n'a pas pu être générée");
				}

			}
		});
		this.buttonOk = buttonOk;
	}

}
