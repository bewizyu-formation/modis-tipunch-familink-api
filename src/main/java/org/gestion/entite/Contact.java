
package org.gestion.entite;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CONTACT")
public class Contact {

	/**
	 * idContact : Int
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContact;

	/**
	 * nom : String
	 */
	@Column(name = "NOM", nullable = false, length = 40)
	private String nom;

	/**
	 * prenom : String
	 */
	@Column(name = "PRENOM", nullable = false, length = 40)
	private String prenom;

	/**
	 * gravatar : String
	 */
	@Column(name = "GRAVATAR", length = 255)
	private String gravatar;

	/**
	 * numTel : String
	 */
	@Column(name = "NUMTEL", nullable = false, length = 10)
	private String numTel;

	/**
	 * adresse : String
	 */
	@Column(name = "ADRESSE", length = 100)
	private String adresse;

	/**
	 * codePostal : String
	 */
	@Column(name = "CODE_POSTAL", length = 5)
	private String codePostal;

	/**
	 * ville : String
	 */
	@Column(name = "VILLE", length = 50)
	private String ville;

	/**
	 * email : String
	 */
	@Column(name = "EMAIL", length = 40)
	private String email;

	@OneToOne
	private Profil profil;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Groupe> listeGroupesContact= new HashSet<Groupe>();

	public Contact() {
		super();
	}

	public Contact(String email, String nom, String prenom, String gravatar, String numTel, String adresse,
			String codePostal, String ville, Profil profil) {
		super();

		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.gravatar = gravatar;
		this.numTel = numTel;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.profil = profil;
	}

	public Contact(int idContact, String email, String nom, String prenom, String gravatar, String numTel,
			String adresse, String codePostal, String ville, Profil profil) {
		super();
		this.idContact = idContact;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.gravatar = gravatar;
		this.numTel = numTel;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.profil = profil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getGravatar() {
		return gravatar;
	}

	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public int getIdContact() {
		return idContact;
	}
	
	public Set<Groupe> getListeGroupesContact() {
		return listeGroupesContact;
	}

	public void setListeGroupesContact(Set<Groupe> listeGroupesContact) {
		this.listeGroupesContact = listeGroupesContact;
	}

}
