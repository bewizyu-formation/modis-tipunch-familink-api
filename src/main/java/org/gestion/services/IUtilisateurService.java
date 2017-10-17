package org.gestion.services;

import java.util.List;

import org.gestion.entite.Groupe;
import org.gestion.entite.Utilisateur;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Utilisateur} que doit posséder une classe
 * d'implémentation
 *
 * @author DIGINAMIC
 */
public interface IUtilisateurService {

	/**
	 * Sauvegarde un nouveau utilisateur
	 *
	 * @param Utilisateur nouveau utilisateur
	 */
	Utilisateur create(Utilisateur nouveauUtilisateur);

	/**
	 * Mise à jour d'un utilisateur
	 *
	 * @param utilisateur
	 */
	void update(Utilisateur utilisateur);

	/**
	 * Extrait tous les utilisateurs existants
	 *
	 * @return
	 */
	List<Utilisateur> getUtilisateurs();

	/**
	 * Récupération d'un utilisateur par son id
	 * @param id
	 * @return
	 */
	Utilisateur getUtilisateurById (final int id);
	
	/**
	 * Suppression d'un utilisateur par son id
	 * @param id
	 */
	void deleteUtilisateur(final int id);
	
	/**
	 * Récupération d'un utilisateur par son email
	 * @param id
	 * @return
	 */
	Utilisateur getUtilisateurByEmail (final String email);
	
	/**
	 * Récupération d'un utilisateur par son mot de passe
	 * @param id
	 * @return
	 */
	Utilisateur getUtilisateurByMotDePasse (final String motDePasse);

	/**
	 * Retourne la liste des groupes auxquels l'utilisateur appartient
	 *
	 * @return List<Utilisateur>
	 */
	List<Groupe> getListeGroupeUtilisateur( Utilisateur utilisateur );

}
