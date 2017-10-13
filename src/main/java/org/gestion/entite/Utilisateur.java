package org.gestion.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Transient;

import org.gestion.entite.Contact;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {

	/**
	 * idUtilisateur : Int
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUtilisateur;


	/**
	 * email : String
	 */
	@Column(name = "EMAIL", nullable = false, length = 50)
	private String email;

	/**
	 * mot_de_passe : String
	 */
	@Column(name = "MOT_DE_PASSE")
	private String motDePasse;

	@OneToOne
	private Contact idContact;

	@OneToMany
	@JoinColumn(name = "ID_UTILISATEUR")
	private Set<Favoris> listeFavoris;

	@Transient
	private int newIdContact;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String email, String motDePasse, Contact idContact) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;
		this.idContact = idContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Contact getContact() {
		return idContact;
	}

	public void setContact(Contact idContact) {
		this.idContact = idContact;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @return the newIdContact
	 */
	@Transient
	public int getNewIdContact() {
		return newIdContact;
	}

	/**
	 * @param newIdContact
	 *            the newIdContact to set
	 */
	public void setNewIdContact(int newIdContact) {
		this.newIdContact = newIdContact;
	}
	
}
