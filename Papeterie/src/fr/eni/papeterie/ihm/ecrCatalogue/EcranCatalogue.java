package fr.eni.papeterie.ihm.ecrCatalogue;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.eni.papeterie.ihm.ArticleController;

public class EcranCatalogue extends JFrame {

	private TableCatalogue tblCatalogue;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcranCatalogue frame = new EcranCatalogue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EcranCatalogue() {
		super("Catalogue");

		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// icone de la fenêtre
		Toolkit tk = Toolkit.getDefaultToolkit();
		this.setIconImage(tk.getImage(getClass().getResource("../resources/aim.png")));

		initComposants();

	}

	private void initComposants() {
		JPanel mainContent = new JPanel();
		mainContent.setOpaque(true);

		mainContent.setLayout(new GridLayout(1, 0));
		tblCatalogue = new TableCatalogue(ArticleController.get().getCatalogue());

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(tblCatalogue);

		// Add the scroll pane to this panel.
		mainContent.add(scrollPane);

		this.setContentPane(mainContent);
	}

	public void notifierChangementArticle() {
		((TableCatalogueModel) tblCatalogue.getModel()).fireTableDataChanged();
		System.out.println("notifierChangementArticle");
	}

}
