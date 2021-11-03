package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {

	private float montant;
	private List<Ligne> lignes;

	public float getMontant() {
		montant = 0f;
		for (Ligne ligne : lignes) {
			montant += ligne.getArticle().getPrixUnitaire() * ligne.getQte();
		}
		return montant;
	}

	public Ligne getLigne(int index) {
		return lignes.get(index);
	}

	public List<Ligne> getLignesPanier() {
		return lignes;
	}

	public Panier() {
		lignes = new ArrayList<Ligne>();
	}

	public void addLigne(Article article, int qte) {
		lignes.add(new Ligne(article, qte));
		montant += article.getPrixUnitaire() * qte;
	}

	public void updateLigne(int index, int qte) {
		Ligne l = getLigne(index);
		l.setQte(qte);
	}

	public void removeLigne(int index) {
		lignes.remove(index);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Panier :\n");
		sb.append("\n");
		int i = 0;
		for (Ligne l : getLignesPanier()) {
			sb.append("ligne " + i++ + " :\t");
			sb.append(l.toString());
			sb.append("\n");
		}
		sb.append("\n");
		sb.append("Valeur du panier : " + getMontant());
		return sb.toString();
	}

}
