package org.gestion.services.impl;

import org.gestion.entite.Contact;
import org.gestion.entite.Utilisateur;
import org.gestion.services.IContactService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service(value = "contactServiceJpa")
public class ContactServiceJpa implements IContactService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Contact create(Contact nvContact) {
		em.persist(nvContact);
		return nvContact;
	}

	@Override
	@Transactional
	public void update(Contact contact) {
		Query query = em.createQuery("FROM Contact c WHERE c.idContact=:IdContact");
		query.setParameter("idContact", contact.getIdContact());

		Contact oldContact = (Contact) query.getSingleResult();
		if (!oldContact.equals(null)) {
			oldContact.setAdresse(contact.getAdresse());
			oldContact.setCodePostal(contact.getCodePostal());
			oldContact.setGravatar(contact.getGravatar());
			oldContact.setNom(contact.getNom());
			oldContact.setNumTel(contact.getNumTel());
			oldContact.setPrenom(contact.getPrenom());
			oldContact.setProfil(contact.getProfil());
			oldContact.setVille(contact.getVille());
			em.merge(oldContact);
			em.flush();
		}
	}

	@Override
	public List<Contact> getContacts() {
		TypedQuery<Contact> query = em.createQuery("FROM Contact", Contact.class);
		return query.getResultList();
	}

	@Override
	public void deleteContact(int id) {
		//em.getTransaction().begin();
		Contact contact = getContactById(id);
		em.remove(contact);
		//em.getTransaction().commit();
	}

	@Override
	public Contact getContactById(int id) {
		//em.getTransaction().begin();
		Contact contact = em.find(Contact.class, id);
		//em.getTransaction().commit();
	    return contact;
	}

	@Override
	public List<Contact> getContactByIdGroupe(int idGroupe) {

		TypedQuery<Contact> query = em.createQuery("select u from Contact u where u.idGroupe = :IdGroupe", Contact.class);
		return query.setParameter("IdGroupe", idGroupe).getResultList();
		
	}

}
