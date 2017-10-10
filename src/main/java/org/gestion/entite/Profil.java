package org.gestion.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROFIL")
public class Profil {

	/**
	 * idProfil : Int
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProfil;
	
	/**
	 * nom : String
	 */
	@Column(name = "NOM", nullable = false, length = 40)
	private String nom;
	
	/**
	 * couleur : String
	 */
	@Column(name = "COULEUR", nullable = false, length = 7)
	private String couleur;

	public Profil() {
		super();
	}

	
	public Profil(String nom, String couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getIdProfil() {
		return idProfil;
	}
	
	
}
