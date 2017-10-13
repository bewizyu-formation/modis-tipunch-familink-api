package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;
import org.gestion.entite.Token;
import org.gestion.services.IContactService;
import org.gestion.services.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




/**
 * @author Ahmet Celikbas
 */

@RestController
@RequestMapping("/groupes")
public class RestGroupesController {

	@Autowired
	@Qualifier("groupeServiceJpa")
	private IGroupeService groupeServiceJpa;

	private Token tokenHandler = new Token();
	
	/*
	@Autowired
	@Qualifier("groupeServiceRepository")
	private IGroupeService groupeServiceRepository;

	
	@Autowired
	private RestProfileController restProfileController;
	*/

	// ********************************** //
	// ******* GET LIST groupes ********** //
	// ********************************** //

	@RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Groupe> getGroupesWithJPA(@RequestHeader(value = "Authorization", required=true) String requestToken) {
		
		/* TODO :  vérifier la validiée du token */
		// System.out.println("requestToken = " + requestToken);		

		
		
		/* TODO : Retourner uniquement les groupes liés à l'utilisateur (IdUtilisateur contenu dans le token) */
		return groupeServiceJpa.getGroupes();
	}

	// *********************************** //
	// ******* GET contact BY ID ********** //
	// *********************************** //

	/*
	@RequestMapping(path = "/{idContact}", method = RequestMethod.GET)
	@ResponseBody
	public Contact getContactById(@PathVariable("idContact") String idContact) {
		return contactServiceRepository.getContactById(Integer.parseInt(idContact));
	}
	*/

	// *********************************** //
	// ********** CREATE contacts ********** //
	// *********************************** //

	/*
	@RequestMapping(path = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void createContact(@RequestBody Contact nouveauContact) {


		Contact newContact = new Contact(nouveauContact.getEmail(), nouveauContact.getNom(), nouveauContact.getPrenom(),
				nouveauContact.getGravatar(), nouveauContact.getNumTel(), nouveauContact.getAdresse(),
				nouveauContact.getCodePostal(), nouveauContact.getVille(),
				restProfileController.getProfilById(Integer.toString(nouveauContact.getIdProfil())));
		System.out.println(newContact);
		contactServiceRepository.create(newContact);

	}
	*/

	// *********************************** //
	// ******* UPDATE contact BY ID ******** //
	// *********************************** //

	/*
	@RequestMapping(path = "", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public void updateContact(@RequestBody Contact updateContact) {

		Contact upContact = new Contact(updateContact.getIdContact(), updateContact.getEmail(), updateContact.getNom(),
				updateContact.getPrenom(), updateContact.getGravatar(), updateContact.getNumTel(),
				updateContact.getAdresse(), updateContact.getCodePostal(), updateContact.getVille(),
				restProfileController.getProfilById(Integer.toString(updateContact.getIdProfil())));

		contactServiceRepository.update(upContact);

	}
	*/

	//
	// *********************************** //
	// ******* DELETE contact BY ID ******** //
	// *********************************** //

	/*
	@RequestMapping(path = "/{idContact}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteContact(@PathVariable("idContact") String idContact) {
		contactServiceRepository.deleteContact(Integer.parseInt(idContact));

	}
	*/
}