package org.gestion.services.impl;

import org.gestion.entite.Utilisateur;
import org.gestion.repository.UtilisateurRepository;
import org.gestion.services.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Van-Rottana YOU
 */
@Service(value = "utilisateurServiceRepository")
public class UtilisateurServiceRepository implements IUtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Override
	public void deleteUtilisateur(int id) {
		utilisateurRepository.delete(id);
	}

	@Override
	public Utilisateur getUtilisateurById(int id) {
		return utilisateurRepository.findOne(id);
	}

	@Override
	public Utilisateur create(Utilisateur nouveauUtilisateur) {

		return utilisateurRepository.save(nouveauUtilisateur);

	}

	@Override
	public void update(Utilisateur utilisateur) {

		final Utilisateur toUpdate = utilisateurRepository.findOne(utilisateur.getIdUtilisateur());

		if (toUpdate != null) {

			toUpdate.setEmail(utilisateur.getEmail());		
			toUpdate.setMotDePasse(utilisateur.getMotDePasse());
			utilisateurRepository.save(toUpdate);
		}

	}

	@Override
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurRepository.findAll();
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
