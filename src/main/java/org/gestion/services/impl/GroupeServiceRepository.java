package org.gestion.services.impl;

import org.gestion.entite.Groupe;
import org.gestion.entite.Utilisateur;
import org.gestion.repository.GroupeRepository;
import org.gestion.services.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Van-Rottana YOU
 */
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
			toUpdate.setContactsDuGroupe(groupe.getContactsDuGroupe());
			toUpdate.setDateDeCreation(groupe.getDateDeCreation());
			toUpdate.setIdUtilisateur(groupe.getIdUtilisateur());
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
		// TODO Auto-generated method stub
		return null;
	}
}
