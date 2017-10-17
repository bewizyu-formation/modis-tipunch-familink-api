package org.gestion.entite;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.gestion.entite.Contact;

@Entity
@Table(name = "UTILISATEUR",uniqueConstraints={
        @UniqueConstraint(name="email", columnNames={"email"})})
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
	private Contact contact;

	

	public Utilisateur() {
		super();
	}

	public Utilisateur(String email, String motDePasse, Contact contact) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;
		this.contact = contact;
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
		return contact;
	}

	public void setContact(Contact idContact) {
		this.contact = idContact;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}
}
