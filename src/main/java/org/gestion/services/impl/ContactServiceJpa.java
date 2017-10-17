package org.gestion.services.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;
import org.gestion.services.IContactService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

		Contact contact = getContactById(id);
		em.remove(contact);

	}

	@Override
	public Contact getContactById(int id) {

		Contact contact = em.find(Contact.class, id);

	    return contact;
	}
	
	@Override
	public List<Contact> getContactsByGroupId(){
		TypedQuery<Contact> query = em.createQuery("SELECT idContact FROM Contact c WHERE c.idGroupe=:IdGroupe", Contact.class );
		return query.getResultList();		
	}

	@Override
	public List<Groupe> getListeGroupes(int IdUtilisateur) {

		Query q = em.createNativeQuery("SELECT * FROM groupe INNER JOIN groupe_contact ON groupe.idGroupe = groupe_contact.Groupe_idGroupe "
				+ "INNER JOIN utilisateur on groupe_contact.contactsDuGroupe_idContact = utilisateur.contact_idContact where utilisateur.idUtilisateur = ?"
				);
		q.setParameter(1, IdUtilisateur);
		List<Groupe> groupes = q.getResultList();
		return groupes;
	}
	
	@Override
	@Transactional
	public void updateListeGroupes(int idcontact, Set<Groupe> listeGroupesContacts) {
		Contact contact = getContactById(idcontact);
		contact.setListeGroupesContact(listeGroupesContacts);
		em.persist(contact);
	}

}
