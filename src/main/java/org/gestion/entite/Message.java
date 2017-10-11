package org.gestion.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;

@Entity
@Table(name = "MESSAGE")
public class Message {
	
	/**
	 * idGroupe : Int
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMessage;
	
	@OneToOne
	private Groupe groupe;
	
	/**
	 * texte : String
	 */
	@Column(name = "TEXTE", nullable = false, length = 140)
	private String texte;
	
	/**
	 * dateDeCreation : Date
	 */
	@Column(name = "DATE_DE_CREATION", nullable = false)
	private Date dateDeCreation;
	
	/**
	 * status : String
	 */
	@Column(name = "STATUS")
	private boolean statut=false;
	
	@OneToOne
	private Contact contactEmmetteur;
	
	@OneToOne
	private Contact contactDestinataire;

	public Message() {
		super();
	}

	public Message(Groupe Groupe, String texte, Date dateDeCreation, boolean statut,
			Contact ContactEmmetteur, Contact ContactDestinataire) {
		super();
		this.groupe = Groupe;
		this.texte = texte;
		this.dateDeCreation = dateDeCreation;
		this.statut = statut;
		this.contactEmmetteur = ContactEmmetteur;
		this.contactDestinataire = ContactDestinataire;
	}

	public Groupe getGroupe() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public Contact getIdContactEmmetteur() {
		return contactEmmetteur;
	}

	public void setIdContactEmmetteur(Contact contactEmmetteur) {
		this.contactEmmetteur = contactEmmetteur;
	}

	public Contact getIdContactDestinataire() {
		return contactDestinataire;
	}

	public void setIdContactDestinataire(Contact contactDestinataire) {
		this.contactDestinataire = contactDestinataire;
	}

	public int getIdMessage() {
		return idMessage;
	}
	
	
}
