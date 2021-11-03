package fr.eni.papeterie.ihm;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;

public class EcranArticle extends JFrame {

	/* Formulaire de saisie */
	private JTextField txtReference, txtDesignation, txtMarque, txtStock, txtPrix;
	private JRadioButton radioRamette, radioStylo;
	private JPanel panelType, panelGrammage;
	private JCheckBox chk80, chk100;
	private JComboBox<String> cboCouleur;
	private JTextField txtQteStock;

	/* Boutons */
	private PanelBoutons panelBoutons;

	/* idArticle affiché à l'écran */
	private Integer idCourant;

	public EcranArticle() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 400);
		setResizable(false);
		setTitle("Détail article");
		initIhm();
	}

	private void initIhm() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(5, 5, 5, 5);

		// Ligne 1
		gbc.gridy = 0;
		gbc.gridx = 0;
		panelPrincipal.add(new JLabel("Référence"), gbc);

		gbc.gridx = 1;
		panelPrincipal.add(getTxtReference(), gbc);

		// Ligne 2
		gbc.gridy = 1;
		gbc.gridx = 0;
		panelPrincipal.add(new JLabel("Désignation"), gbc);

		gbc.gridx = 1;
		panelPrincipal.add(getTxtDesignation(), gbc);

		// Ligne 3
		gbc.gridy = 2;
		gbc.gridx = 0;
		panelPrincipal.add(new JLabel("Marque"), gbc);

		gbc.gridx = 1;
		panelPrincipal.add(getTxtMarque(), gbc);

		// Ligne 4
		gbc.gridy = 3;
		gbc.gridx = 0;
		panelPrincipal.add(new JLabel("Stock"), gbc);

		gbc.gridx = 1;
		panelPrincipal.add(getTxtStock(), gbc);

		// Ligne 5
		gbc.gridy = 4;
		gbc.gridx = 0;
		panelPrincipal.add(new JLabel("Type"), gbc);

		gbc.gridx = 1;
		gbc.gridheight = 1;
		panelPrincipal.add(getPanelType(), gbc);

		// Ligne 6
		gbc.gridy = 5;
		gbc.gridx = 0;
		panelPrincipal.add(new JLabel("Grammage"), gbc);

		gbc.gridx = 1;
		panelPrincipal.add(getPanelGrammage(), gbc);

		// Ligne 7
		gbc.gridy = 6;

		gbc.gridx = 0;
		panelPrincipal.add(new JLabel("Couleur"), gbc);

		gbc.gridx = 1;
		panelPrincipal.add(getCboCouleur(), gbc);

		// Ligne 8
		gbc.gridy = 7;

		gbc.gridx = 0;
		gbc.gridwidth = 2;
		panelPrincipal.add(getPanelBoutons(), gbc);

		setContentPane(panelPrincipal);
	}

	public JTextField getTxtReference() {
		if (txtReference == null) {
			txtReference = new JTextField(30);
		}
		return txtReference;
	}

	public JTextField getTxtDesignation() {
		if (txtDesignation == null) {
			txtDesignation = new JTextField(30);
		}
		return txtDesignation;
	}

	public JTextField getTxtMarque() {
		if (txtMarque == null) {
			txtMarque = new JTextField(30);
		}
		return txtMarque;
	}

	public JTextField getTxtStock() {
		if (txtStock == null) {
			txtStock = new JTextField(30);
		}
		return txtStock;
	}

	public JTextField getTxtPrix() {
		if (txtPrix == null) {
			txtPrix = new JTextField(30);
		}
		return txtPrix;
	}

	public JPanel getPanelType() {
		if (panelType == null) {
			panelType = new JPanel();
			panelType.setLayout(new BoxLayout(panelType, BoxLayout.Y_AXIS));
			panelType.add(getRadioRamette());
			panelType.add(getRadioStylo());
			ButtonGroup bg = new ButtonGroup();
			bg.add(getRadioRamette());
			bg.add(getRadioStylo());
		}
		return panelType;
	}

	public JPanel getPanelGrammage() {
		if (panelGrammage == null) {
			panelGrammage = new JPanel();
			panelGrammage.setLayout(new BoxLayout(panelGrammage, BoxLayout.Y_AXIS));
			panelGrammage.add(getChk80());
			panelGrammage.add(getChk100());
			ButtonGroup bg = new ButtonGroup();
			bg.add(getChk80());
			bg.add(getChk100());
		}

		return panelGrammage;
	}

	public JRadioButton getRadioRamette() {
		if (radioRamette == null) {
			radioRamette = new JRadioButton("Ramette");
			radioRamette.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					getChk100().setEnabled(true);
					getChk80().setEnabled(true);
					getCboCouleur().setEnabled(false);

				}

			});
		}
		return radioRamette;
	}

	public JRadioButton getRadioStylo() {
		if (radioStylo == null) {
			radioStylo = new JRadioButton("Stylo");
			radioStylo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					getChk100().setEnabled(false);
					getChk80().setEnabled(false);
					getCboCouleur().setEnabled(true);

				}

			});

		}

		return radioStylo;
	}

	public JCheckBox getChk80() {
		if (chk80 == null) {
			chk80 = new JCheckBox("80 grammes");
		}
		return chk80;
	}

	public JCheckBox getChk100() {
		if (chk100 == null) {
			chk100 = new JCheckBox("100 grammes");
		}

		return chk100;
	}

	public JComboBox<String> getCboCouleur() {
		if (cboCouleur == null) {
			String[] couleurs = { "bleu", "rouge", "noir", "vert" };
			cboCouleur = new JComboBox<String>(couleurs);
		}
		return cboCouleur;
	}

	public void afficherNouveau() {
		// Par défaut un article est une rammette
		Ramette a = new Ramette(null, "", "", "", 0.0f, 0, 0);

		afficherArticle(a);

	}

	public void afficherArticle(Article a) {

		idCourant = a.getIdArticle();
		// Autres caractéristiques de l'article
		getTxtReference().setText(a.getReference() + "");
		getTxtMarque().setText(a.getMarque() + "");
		getTxtDesignation().setText(a.getDesignation() + "");
		getTxtPrix().setText(String.valueOf(a.getPrixUnitaire()) + "");
		getTxtStock().setText(new Integer(a.getQteStock()) + "");

		if (a.getClass().equals(Stylo.class)) {
			// Cas du stylo
			// sélectionner le bouton radio correspondant
			getRadioStylo().setSelected(true);
			// activer le choix des couleurs
			getCboCouleur().setEnabled(true);
			// Sélectionner la bonne couleur
			getCboCouleur().setSelectedItem(((Stylo) a).getCouleur());
			// Désactiver les cases à cocher
			getChk80().setEnabled(false);
			getChk100().setEnabled(false);
		} else {
			// Cas de la ramette
			// activer le bouton radio
			getRadioRamette().setSelected(true);
			// activer les cases à cocher
			getChk80().setEnabled(true);
			getChk100().setEnabled(true);
			// Papier de 80g par défaut
			getChk80().setSelected(((Ramette) a).getGrammage() == 80);
			getChk100().setSelected(((Ramette) a).getGrammage() == 100);
			// Désactiver les champs inutiles
			getCboCouleur().setSelectedItem(null);
			getCboCouleur().setEnabled(false);
		}
		getRadioStylo().setEnabled(a.getIdArticle() == null);
		getRadioRamette().setEnabled(a.getIdArticle() == null);

	}

	public void precedent() {
		ArticleController.get().precedent();

	}

	public void suivant() {
		ArticleController.get().suivant();

	}

	public void nouveau() {
		ArticleController.get().nouveau();

	}

	public void enregistrer() {
		ArticleController.get().enregistrer();

	}

	public void supprimer() {
		ArticleController.get().supprimer();

	}

	public PanelBoutons getPanelBoutons() {
		if (panelBoutons == null) {
			panelBoutons = new PanelBoutons();
			panelBoutons.addPanelBoutonObserver(new IPanelBoutonObserver() {

				@Override
				public void precedent() {
					ArticleController.get().precedent();
				}

				@Override
				public void suivant() {
					ArticleController.get().suivant();
				}

				@Override
				public void nouveau() {
					ArticleController.get().nouveau();

				}

				@Override
				public void enregistrer() {
					ArticleController.get().enregistrer();

				}

				@Override
				public void supprimer() {
					ArticleController.get().supprimer();
				}

			});

		}

		return panelBoutons;
	}

	public Article getArticle() {
		Article article = null;
		if (getRadioStylo().isSelected()) {
			article = new Stylo();
		} else {
			article = new Ramette();
		}
		try {
			article.setIdArticle(idCourant);
			article.setReference(getTxtReference().getText());
			article.setMarque(getTxtMarque().getText());
			article.setDesignation(getTxtDesignation().getText());
			article.setPrixUnitaire(Float.parseFloat(getTxtPrix().getText()));
			article.setQteStock(Integer.parseInt(getTxtStock().getText()));
			if (getCboCouleur().isEnabled()) {
				((Stylo) article).setCouleur((String) getCboCouleur().getSelectedItem());
			} else {
				((Ramette) article).setGrammage(getChk80().isSelected() ? 80 : 100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	public void infoErreur(String msg) {
		JOptionPane.showMessageDialog(EcranArticle.this, msg, "", JOptionPane.ERROR_MESSAGE);
	}

}
