package org.gestion.entite;

import java.util.Date;
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

import org.gestion.entite.Contact;
import org.gestion.entite.Utilisateur;

@Entity
@Table(name = "GROUPE")
public class Groupe {
	
	/**
	 * idGroupe : Int
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGroupe;
	
	@OneToOne
	private Utilisateur idUtilisateur;
	
	/**
	 * nomGroupe : String
	 */
	@Column(name = "NOM_GROUPE", nullable = false, length = 40)
	private String nomGroupe;
	
	/**
	 * dateDeCreation : Date
	 */
	@Column(name = "DATE_DE_CREATION", nullable = false)
	private Date dateDeCreation;

	@OneToMany
    private Set<Contact> contactsDuGroupe ;
		
	@OneToMany
	@JoinColumn(name="ID_GROUPE")
    private Set<Favoris> listeFavorisGroupe ;
	
	public Groupe() {
		super();
	}

	public Groupe(Utilisateur idUtilisateur, String nomGroupe, Date dateDeCreation) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nomGroupe = nomGroupe;
		this.dateDeCreation = dateDeCreation;
	}

	public Utilisateur getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Utilisateur idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public Set<Contact> getContactsDuGroupe() {
		return contactsDuGroupe;
	}

	public void setContactsDuGroupe(Set<Contact> contactsDuGroupe) {
		this.contactsDuGroupe = contactsDuGroupe;
	}

	public int getIdGroupe() {
		return idGroupe;
	}
	
	
	

}
