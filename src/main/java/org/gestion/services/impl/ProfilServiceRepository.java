package org.gestion.services.impl;

import org.gestion.entite.Profil;
import org.gestion.repository.ProfilRepository;
import org.gestion.services.IProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Van-Rottana YOU
 */
@Service(value = "profilServiceRepository")
public class ProfilServiceRepository implements IProfilService {

	@Autowired
	private ProfilRepository profilRepository;

	@Override
	public void deleteProfil(int id) {
		profilRepository.delete(id);
	}

	@Override
	public Profil getProfilById(int id) {
		return profilRepository.findOne(id);
	}

	@Override
	public void create(Profil nouveauProfil) {
		 profilRepository.save(nouveauProfil);

	}

	@Override
	public void update(Profil profil) {

		final Profil toUpdate = profilRepository.findOne(profil.getIdProfil());

		if (toUpdate != null) {
			toUpdate.setCouleur(profil.getCouleur());

			toUpdate.setNom(profil.getNom());

			profilRepository.save(toUpdate);
		}

	}

	@Override
	public List<Profil> getProfils() {
		return profilRepository.findAll();
	}
}
