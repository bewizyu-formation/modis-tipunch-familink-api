package org.gestion.services;

import java.util.List;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;
import org.gestion.entite.Utilisateur;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Groupe}
 * que doit posséder une classe d'implémentation
 *
 * @author van-rottana YOU
 */
public interface IGroupeService {

	/**
	 * Sauvegarde un nouveau Groupe
	 *
	 * @param nouveauGrade
	 *            nouveau Groupe
	 */
	Groupe create(Groupe nouveauGroupe);

	/**
	 * Mise à jour d'un Groupe
	 *
	 * @param Groupe
	 */
	void update(Groupe groupe);

	/**
	 * Extrait tous les Groupes existants
	 *
	 * @return
	 */
	List<Groupe> getGroupes();

	/**
	 * Récupération d'un Groupe par son id
	 * 
	 * @param id
	 * @return
	 */
	Groupe getGroupeById(final int id);

	/**
	 * Suppression d'un Groupe
	 * 
	 * @param id
	 */
	void deleteGroupe(final int id);

	/**
	 * Récupération d'un groupe par son idUtilisateur
	 * 
	 * @param id
	 * @return
	 */
	Groupe getGroupeByUtilisateur(final Utilisateur utilisateur);
	

	/**
	 *Ajout d'un contact à la liste de contact d'un groupe
	 * 
	 * @param ContactForm
	 * @return
	 */
	void addContactToGroup(Contact nouveauContact, int idGroupe);

}
