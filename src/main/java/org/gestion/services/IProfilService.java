package org.gestion.services;

import java.util.List;

import org.gestion.entite.Profil;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Profil} que doit posséder une classe
 * d'implémentation
 *
 * @author DIGINAMIC
 */
public interface IProfilService {

	/**
	 * Sauvegarde un nouveau Profil
	 *
	 * @param nouveauGrade nouveau Profil
	 * @return 
	 */
	void create(Profil nouveauProfil);

	/**
	 * Mise à jour d'un Profil
	 *
	 * @param Profil
	 */
	void update(Profil Profil);

	/**
	 * Extrait tous les Profils existants
	 *
	 * @return
	 */
	List<Profil> getProfils();

	/**
	 * Récupération d'un Profil par son id
	 * @param id
	 * @return
	 */
	Profil getProfilById (final int id);

	/**
	 * Suppression d'un Profil
	 * @param id
	 */
	void deleteProfil(final int id);
}
