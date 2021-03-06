package org.gestion.services.impl;

import java.util.List;
import java.util.Set;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;
import org.gestion.entite.Utilisateur;
import org.gestion.repository.GroupeRepository;
import org.gestion.services.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "groupeServiceRepository")
public class GroupeServiceRepository implements IGroupeService {

	@Autowired
	private GroupeRepository groupeRepository;

	@Override
	public void deleteGroupe(int id) {
		groupeRepository.delete(id);
	}

	@Override
	public Groupe getGroupeById(int id) {
		return groupeRepository.findOne(id);
	}

	@Override
	public Groupe create(Groupe nouveauGroupe) {
		return groupeRepository.save(nouveauGroupe);
	}

	@Override
	public void update(Groupe groupe) {

		final Groupe toUpdate = groupeRepository.findOne(groupe.getIdGroupe());

		if (toUpdate != null) {
			toUpdate.setDateDeCreation(groupe.getDateDeCreation());
			toUpdate.setUtilisateur(groupe.getUtilisateur());
			toUpdate.setNom(groupe.getNom());
			groupeRepository.save(toUpdate);
		}

	}

	@Override
	public List<Groupe> getGroupes() {
		return groupeRepository.findAll();
	}

	@Override
	public Groupe getGroupeByUtilisateur(Utilisateur utilisateur) {

		return null;
	}

	@Override
	public void addContactToGroup(Contact nouveauContact, int idGroupe) {

		Groupe groupeToUpdate = getGroupeById(idGroupe);
		groupeToUpdate.getContactsDuGroupe().add(nouveauContact);

		if (groupeToUpdate != null) {
			groupeToUpdate.setContactsDuGroupe(groupeToUpdate.getContactsDuGroupe());
			groupeRepository.save(groupeToUpdate);
		}
	}

	@Override
	public void updateListeContacts(int idGroupe, Set<Contact> listeContactsGoupe) {

	}
}
