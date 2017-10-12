package org.gestion.services.impl;

import org.gestion.entite.Contact;
import org.gestion.repository.ContactRepository;
import org.gestion.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Van-Rottana YOU
 */
@Service(value = "contactServiceRepository")
public class ContactServiceRepository implements IContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void deleteContact(int id) {
		contactRepository.delete(id);
	}

	@Override
	public Contact getContactById(int id) {
		return contactRepository.findOne(id);
	}

	@Override
	public Contact create(Contact nouveauContact) {
		return contactRepository.save(nouveauContact);
	}

	@Override
	public void update(Contact contact) {

		final Contact toUpdate = contactRepository.findOne(contact.getIdContact());

		if (toUpdate != null) {
			toUpdate.setAdresse(contact.getAdresse());
			toUpdate.setCodePostal(contact.getCodePostal());
			toUpdate.setGravatar(contact.getGravatar());
			toUpdate.setNom(contact.getNom());
			toUpdate.setNumTel(contact.getNumTel());
			toUpdate.setPrenom(contact.getPrenom());
			toUpdate.setProfil(contact.getProfil());
			toUpdate.setVille(contact.getVille());
			contactRepository.save(toUpdate);
		}

	}

	@Override
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}
}
