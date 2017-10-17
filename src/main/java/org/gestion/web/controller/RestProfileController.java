package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Profil;
import org.gestion.services.IProfilService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Damien Pickel
 */

@RestController
@RequestMapping("/profils")
@CrossOrigin(origins = "*", allowedHeaders = "authorization")
public class RestProfileController {

	@Autowired
	@Qualifier("profilServiceJpa")
	private IProfilService profilServiceJpa;

	@Autowired
	@Qualifier("profilServiceRepository")
	private IProfilService profilServiceRepository;

	// ********************************** //
	// ******** GET LIST profils ******** //
	// ********************************** //

	@RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Profil> getProfilList() {
		return profilServiceJpa.getProfils();
	}

	// *********************************** //
	// ******* GET utilisateur BY ID ********** //
	// *********************************** //

	@RequestMapping(path = "/{idProfil}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Profil getProfilById(@PathVariable("idProfil") String idProfil) {
		return profilServiceRepository.getProfilById(Integer.parseInt(idProfil));
	}

	// *********************************** //
	// ********** CREATE profil ********** //
	// *********************************** //

	@RequestMapping(path = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
	public String CreateProfil(@RequestBody Profil newProfil) {		
		profilServiceJpa.create(new Profil(newProfil.getNom(), newProfil.getCouleur()));
		return new JSONObject().toString();

	}

	// *********************************** //
	// ******* UPDATE utilisateur BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String updateProfil(@RequestBody Profil updateProfil) {
		profilServiceRepository.update(updateProfil);
		return new JSONObject().toString();
	}

	// *********************************** //
	// ******* DELETE utilisateur BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "/{idProfil}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteProfil(@PathVariable("idProfil") String idProfil) {
		profilServiceRepository.deleteProfil(Integer.parseInt(idProfil));

	}

}
