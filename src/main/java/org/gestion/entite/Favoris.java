package org.gestion.entite;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FAVORIS")
public class Favoris {

	/**
	 * idGroupe : Int
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFavoris;

	@OneToMany(mappedBy = "listeFavorisGroupe")
	private Set<Groupe> listeGroupes;

	@OneToMany(mappedBy = "listeFavoris")
	private Set<Utilisateur> ListeUtilisateurs;

	@OneToMany(mappedBy = "listeFavorisContact")
	private Set<Contact> ListeContacts;

	public Favoris() {
		super();
	}

	public Favoris(Set<Groupe> listeGroupes, Set<Utilisateur> ListeUtilisateurs, Set<Contact> ListeContacts) {
		super();
		this.listeGroupes = listeGroupes;
		this.ListeUtilisateurs = ListeUtilisateurs;
		this.ListeContacts = ListeContacts;
	}

	public Set<Groupe> getGroupes() {
		return listeGroupes;
	}

	public void setGroupe(Set<Groupe> listeGroupes) {
		this.listeGroupes = listeGroupes;
	}

	public Set<Utilisateur> getUtilisateur() {
		return ListeUtilisateurs;
	}

	public void setUtilisateur(Set<Utilisateur> ListeUtilisateurs) {
		this.ListeUtilisateurs = ListeUtilisateurs;
	}

	public Set<Contact> getContact() {
		return ListeContacts;
	}

	public void setContact(Set<Contact> ListeContacts) {
		this.ListeContacts = ListeContacts;
	}

	public int getIdFavoris() {
		return idFavoris;
	}

}
