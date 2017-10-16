package org.gestion.entite;

import java.util.Date;
import java.util.Set;

public class GroupeForm {

	private int idGroupe;
	private int idUtilisateurProprietaire;
	private String nom;
	private Date dateDeCreation;
	private Set<Contact> contactsDuGroupe ;
	/**
	 * 
	 */
	public GroupeForm() {
		super();
	}

	public GroupeForm(int idUtilisateurProprietaire, String nom, Date dateDeCreation, Set<Contact> contactsDuGroupe) {
		super();
		this.idUtilisateurProprietaire = idUtilisateurProprietaire;
		this.nom = nom;
		this.dateDeCreation = dateDeCreation;
		this.contactsDuGroupe = contactsDuGroupe;
	}

	public GroupeForm(int idGroupe, int idUtilisateurProprietaire, String nom, Date dateDeCreation, Set<Contact> contactsDuGroupe) {
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

	/**
	 * @return the contactsDuGroupe
	 */
	public Set<Contact> getContactsDuGroupe() {
		return contactsDuGroupe;
	}

	/**
	 * @param contactsDuGroupe the contactsDuGroupe to set
	 */
	public void setContactsDuGroupe(Set<Contact> contactsDuGroupe) {
		this.contactsDuGroupe = contactsDuGroupe;
	}

}
