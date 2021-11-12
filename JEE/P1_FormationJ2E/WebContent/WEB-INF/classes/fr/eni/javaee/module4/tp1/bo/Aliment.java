package fr.eni.javaee.module4.tp1.bo;

import java.io.Serializable;

public class Aliment implements Serializable {
	private static final long serialVersionUID = 1L;

	private int identifiant;
	private String nom;

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Aliment() {

	}

	public Aliment(String nom) {
		super();
		this.nom = nom;
	}

	public Aliment(int identifiant, String nom) {
		this(nom);
		this.identifiant = identifiant;
	}

	@Override
	public String toString() {
		return "Aliment [id=" + identifiant + ", nom=" + nom + "]";
	}

}
