package org.gestion.services;

import java.util.List;
import java.util.Set;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;

/**
 * Interface qui liste les méthodes de persistence pour la classe
 * {@link Contact} que doit posséder une classe d'implémentation
 *
 * @author van-rottana YOU
 */
public interface IContactService {

	/**
	 * Sauvegarde un nouveau Contact
	 *
	 * @param nouveauGrade
	 *            nouveau Contact
	 */
	Contact create(Contact nouveauContact);

	/**
	 * Mise à jour d'un Contact
	 *
	 * @param Contact
	 */
	void update(Contact contact);

	/**
	 * Extrait tous les Contacts existants
	 *
	 * @return
	 */
	List<Contact> getContacts();

	/**
	 * Récupération d'un Contact par son id
	 * 
	 * @param id
	 * @return
	 */
	Contact getContactById(final int id);

	/**
	 * Suppression d'un Contact
	 * 
	 * @param id
	 */
	void deleteContact(final int id);

	/**
	 * Récupération d'une liste de contacts pour un groupe
	 * 
	 * @param id
	 */
	List<Contact> getContactsByGroupId();

	/**
	 * Récupération d'une liste de groupes pour un contact
	 * 
	 * @param id
	 */
	List<Groupe> getListeGroupes(int idcontact);

	/**
	 * Récupération d'une liste de groupes pour un contact
	 * 
	 * @param id
	 */
	void updateListeGroupes(int idcontact, Set<Groupe> listeContactsGroupe);

}
