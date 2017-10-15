package org.gestion.entite;

import java.util.Date;
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
	private Utilisateur proprietaire;
	
	/**
	 * nomGroupe : String
	 */
	@Column(name = "NOM_GROUPE", nullable = false, length = 40)
	private String nom;
	
	/**
	 * dateDeCreation : Date
	 */
	@Column(name = "DATE_DE_CREATION", nullable = false)
	private Date dateDeCreation;

	@OneToMany(fetch = FetchType.EAGER)
    private Set<Contact> contactsDuGroupe ;
		
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_GROUPE")
    private Set<Favoris> listeFavorisGroupe ;
	
	public Groupe() {
		super();
	}

	public Groupe(Utilisateur proprietaire, String nom, Date dateDeCreation) {
		super();
		this.proprietaire = proprietaire;
		this.nom = nom;
		this.dateDeCreation = dateDeCreation;
	}

	public Groupe(int idGroupe, Utilisateur proprietaire, String nom, Date dateDeCreation) {
		super();
		this.idGroupe = idGroupe;
		this.proprietaire = proprietaire;
		this.nom = nom;
		this.dateDeCreation = dateDeCreation;
	}

	public Utilisateur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
