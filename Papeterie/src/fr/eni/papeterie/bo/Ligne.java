package fr.eni.papeterie.bo;

public class Ligne {
	private int qte;
	private Article article;

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public float getPrix() {
		return qte * article.getPrixUnitaire();
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Ligne(Article article, int qte) {
		super();
		this.qte = qte;
		this.article = article;
	}

	public Ligne(int qte, Article article) {
		super();
		this.qte = qte;
		this.article = article;
	}

	@Override
	public String toString() {
		return "Ligne [qte=" + qte + ", getPrix()=" + getPrix() + ", article=" + article.toString() + "]";
	}

}
