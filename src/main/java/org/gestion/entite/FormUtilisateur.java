package org.gestion.entite;

public class FormUtilisateur {

	private String email;
	private String password;
	private String confirmPassword;
	private String nom;
	private String prenom;
	private int idProfil;
	private String gravatar;
	private String adresse;
	private String codePostal;
	private String numTel;
	private String ville;

	public FormUtilisateur() {
		super();
	}

	public FormUtilisateur(String email, String password, String confirmPassword, String nom, String prenom,
			int idProfil, String gravatar, String adresse, String codePostal, String numTel) {
		super();
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.nom = nom;
		this.prenom = prenom;
		this.idProfil = idProfil;
		this.gravatar = gravatar;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.numTel = numTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}

	public String getGravatar() {
		return gravatar;
	}

	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
