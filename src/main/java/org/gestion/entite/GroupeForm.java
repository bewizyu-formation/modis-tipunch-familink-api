package org.gestion.entite;

import java.util.Date;

public class GroupeForm {

	private int idGroupe;
	private int idUtilisateurProprietaire;
	private String nom;
	private Date dateDeCreation;

	/**
	 * 
	 */
	public GroupeForm() {
		super();
	}

	public GroupeForm(int idUtilisateurProprietaire, String nom, Date dateDeCreation) {
		super();
		this.idUtilisateurProprietaire = idUtilisateurProprietaire;
		this.nom = nom;
		this.dateDeCreation = dateDeCreation;
	}

	public GroupeForm(int idGroupe, int idUtilisateurProprietaire, String nom, Date dateDeCreation) {
		super();
		this.idGroupe = idGroupe;
		this.idUtilisateurProprietaire = idUtilisateurProprietaire;
		this.nom = nom;
		this.dateDeCreation = dateDeCreation;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the dateDeCreation
	 */
	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	/**
	 * @param dateDeCreation
	 *            the dateDeCreation to set
	 */
	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	/**
	 * @return the idUtilisateurProprietaire
	 */
	public int getIdUtilisateurProprietaire() {
		return idUtilisateurProprietaire;
	}

	/**
	 * @return the idContact
	 */
	public int getIdGroupe() {
		return idGroupe;
	}
}
