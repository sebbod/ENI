package fr.eni.papeterie.bo;

public class Stylo extends Article {

	private String couleur;

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Stylo(Integer idArticle, String marque, String ref, String designation, float prixUnitaire, int qteStock,
			String couleur) {
		super(idArticle, ref, marque, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	public Stylo(String marque, String ref, String designation, float prixUnitaire, int qteStock, String couleur) {
		super(ref, marque, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	public Stylo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getIdArticle() {
		// TODO Auto-generated method stub
		return super.getIdArticle();
	}

	@Override
	public void setIdArticle(Integer idArticle) {
		// TODO Auto-generated method stub
		super.setIdArticle(idArticle);
	}

	@Override
	public String getReference() {
		// TODO Auto-generated method stub
		return super.getReference();
	}

	@Override
	public void setReference(String reference) {
		// TODO Auto-generated method stub
		super.setReference(reference);
	}

	@Override
	public String getMarque() {
		// TODO Auto-generated method stub
		return super.getMarque();
	}

	@Override
	public void setMarque(String marque) {
		// TODO Auto-generated method stub
		super.setMarque(marque);
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}

	@Override
	public void setDesignation(String designation) {
		// TODO Auto-generated method stub
		super.setDesignation(designation);
	}

	@Override
	public float getPrixUnitaire() {
		// TODO Auto-generated method stub
		return super.getPrixUnitaire();
	}

	@Override
	public void setPrixUnitaire(float prixUnitaire) {
		// TODO Auto-generated method stub
		super.setPrixUnitaire(prixUnitaire);
	}

	@Override
	public int getQteStock() {
		// TODO Auto-generated method stub
		return super.getQteStock();
	}

	@Override
	public void setQteStock(int qteStock) {
		// TODO Auto-generated method stub
		super.setQteStock(qteStock);
	}

	@Override
	public String toString() {
		return super.toString() + " Stylo [couleur=" + couleur + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}
