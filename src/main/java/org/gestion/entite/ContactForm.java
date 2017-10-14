package org.gestion.entite;

import java.util.Set;

public class ContactForm {

	private int idContact;
	private String nom;
	private String prenom;
	private String gravatar;
	private String numTel;
	private String adresse;
	private String codePostal;
	private String ville;
	private String email;
	private Profil profil;
	private Set<Favoris> listeFavorisContact;
	private Integer idProfil;

	public ContactForm() {
		super();
	}

	public ContactForm(int idContact, String nom, String prenom, String gravatar, String numTel, String adresse,
			String codePostal, String ville, String email, Profil profil, Integer idProfil) {
		super();
		this.idContact = idContact;
		this.nom = nom;
		this.prenom = prenom;
		this.gravatar = gravatar;
		this.numTel = numTel;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.email = email;
		this.profil = profil;
		this.idProfil = idProfil;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the gravatar
	 */
	public String getGravatar() {
		return gravatar;
	}

	/**
	 * @param gravatar
	 *            the gravatar to set
	 */
	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}

	/**
	 * @return the numTel
	 */
	public String getNumTel() {
		return numTel;
	}

	/**
	 * @param numTel
	 *            the numTel to set
	 */
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal
	 *            the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the profil
	 */
	public Profil getProfil() {
		return profil;
	}

	/**
	 * @param profil
	 *            the profil to set
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	/**
	 * @return the listeFavorisContact
	 */
	public Set<Favoris> getListeFavorisContact() {
		return listeFavorisContact;
	}

	/**
	 * @param listeFavorisContact
	 *            the listeFavorisContact to set
	 */
	public void setListeFavorisContact(Set<Favoris> listeFavorisContact) {
		this.listeFavorisContact = listeFavorisContact;
	}

	/**
	 * @return the idProfil
	 */
	public Integer getIdProfil() {
		return idProfil;
	}

	/**
	 * @param idProfil
	 *            the idProfil to set
	 */
	public void setIdProfil(Integer idProfil) {
		this.idProfil = idProfil;
	}

	/**
	 * @return the idContact
	 */
	public int getIdContact() {
		return idContact;
	}

}
