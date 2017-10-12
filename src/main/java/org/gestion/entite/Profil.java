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

	
	public Profil(int idProfile, String nom, String couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.idProfil = idProfile;
	}


	/**
	 * @return the idProfil
	 */
	public int getIdProfil() {
		return idProfil;
	}

	/**
	 * @return the nom
	 */

	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the couleur
	 */

	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profil other = (Profil) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profil [idProfil=" + idProfil + ", nom=" + nom + ", couleur=" + couleur + "]";
	}
	
	
}
