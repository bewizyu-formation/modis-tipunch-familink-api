package org.gestion.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;
import org.gestion.entite.Utilisateur;
import org.gestion.services.IGroupeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "groupeServiceJpa")
public class GroupeServiceJpa implements IGroupeService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Groupe create(Groupe nvGroupe) {
		em.persist(nvGroupe);
		return nvGroupe;
	}

	@Override
	@Transactional
	public void update(Groupe groupe) {
		Query query = em.createQuery("FROM Groupe c WHERE c.idGroupe=:IdGroupe");
		query.setParameter("idGroupe", groupe.getIdGroupe());

		Groupe oldGroupe = (Groupe) query.getSingleResult();
		if (!oldGroupe.equals(null)) {
			oldGroupe.setNom(groupe.getNom());
			em.merge(oldGroupe);
			em.flush();
		}
	}

	@Override
	@Transactional
	public void addContactToGroup(Contact nouveauContact, int idGroupe) {

	}

	@Override
	public List<Groupe> getGroupes() {
		TypedQuery<Groupe> query = em.createQuery("FROM Groupe", Groupe.class);
		return query.getResultList();
	}

	@Override
	public void deleteGroupe(int id) {
		// em.getTransaction().begin();
		Groupe groupe = getGroupeById(id);
		em.remove(groupe);
		// em.getTransaction().commit();
	}

	@Override
	public Groupe getGroupeById(int id) {
		// em.getTransaction().begin();
		Groupe groupe = em.find(Groupe.class, id);
		// em.getTransaction().commit();
		return groupe;
	}

	/**
	 * Récupération d'un groupe par son idUtlisateur
	 * 
	 * @param IdUtilisateur
	 * @return groupe
	 */
	public Groupe getGroupeByUtilisateur(Utilisateur utilisateur) {

		TypedQuery<Groupe> query = em.createQuery("select u from Groupe u where u.idUtilisateur = :IdUtilisateur",
				Groupe.class);
		return query.setParameter("IdUtilisateur", utilisateur).getSingleResult();

	}

}
