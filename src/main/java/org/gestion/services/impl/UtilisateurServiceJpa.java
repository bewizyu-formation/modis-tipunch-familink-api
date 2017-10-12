package org.gestion.services.impl;

import org.gestion.entite.Utilisateur;
import org.gestion.services.IUtilisateurService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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
		query.setParameter("email", utilisateur.getEmail());

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
		//em.getTransaction().begin();
		Utilisateur utilisateur = getUtilisateurById(id);
		em.remove(utilisateur);
		//em.getTransaction().commit();
	}

	@Override
	public Utilisateur getUtilisateurById(int id) {
		//em.getTransaction().begin();
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		//em.getTransaction().commit();
	    return utilisateur;
	}


	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getUtilisateurByMotDePasse(String motDePasse) {
		// TODO Auto-generated method stub
		return null;
	}

}
