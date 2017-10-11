package org.gestion.services.test;

import java.util.List;

import org.gestion.entite.Utilisateur;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Grade} que doit posséder une classe
 * d'implémentation
 *
 * @author DIGINAMIC
 */
public interface IUtilisateurService {

	/**
	 * Sauvegarde un nouveau grade
	 *
	 * @param nouveauUtilisateur nouveau Utilisateur
	 */
	Utilisateur create(Utilisateur nouveauUtilisateur);

	/**
	 * Mise à jour d'un grade
	 *
	 * @param grade
	 */
	void update(Utilisateur grade);

	/**
	 * Extrait tous les grades existants
	 *
	 * @return
	 */
	List<Utilisateur> getGrades();

	/**
	 * Récupération d'un grade par son id
	 * @param id
	 * @return
	 */
	Utilisateur getGradeById (final int id);

	/**
	 * Suppression d'un Grade
	 * @param id
	 */
	void deleteUtilisateur(final int id);
}
