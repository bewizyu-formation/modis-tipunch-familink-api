package org.gestion.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.gestion.entite.Utilisateur;
import org.gestion.services.IUtilisateurService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "utilisateurServiceJpa")
public class UtilisateurServiceJpa implements IUtilisateurService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Utilisateur create(Utilisateur nvUtilisateur) {
		em.persist(nvUtilisateur);

		return nvUtilisateur;

	}

	@Override
	@Transactional
	public void update(Utilisateur utilisateur) {
		Query query = em.createQuery("FROM Utilisateur c WHERE c.email=:email");
		Utilisateur oldUtilisateur = (Utilisateur) query.getSingleResult();
		if (!oldUtilisateur.equals(null)) {
			oldUtilisateur.setEmail(utilisateur.getEmail());
			oldUtilisateur.setContact(utilisateur.getContact());
			oldUtilisateur.setMotDePasse(utilisateur.getMotDePasse());
			em.merge(oldUtilisateur);
			em.flush();
		}
	}

	@Override
	public List<Utilisateur> getUtilisateurs() {
		TypedQuery<Utilisateur> query = em.createQuery("FROM Utilisateur", Utilisateur.class);
		return query.getResultList();
	}

	@Override
	public void deleteUtilisateur(int id) {

		Utilisateur utilisateur = getUtilisateurById(id);
		em.remove(utilisateur);

	}

	@Override
	public Utilisateur getUtilisateurById(int id) {
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		return utilisateur;
	}

	/**
	 * Récupération d'un utilisateur par son email
	 * 
	 * @param email
	 * @return utilisateur
	 */
	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
		TypedQuery<Utilisateur> query = em.createQuery("select u from Utilisateur u where u.email = :Email",
				Utilisateur.class);
		return query.setParameter("Email", email).getSingleResult();

	}

	public Utilisateur getUtilisateurByMotDePasse(String motDePasse) {
		return null;
	}

}
