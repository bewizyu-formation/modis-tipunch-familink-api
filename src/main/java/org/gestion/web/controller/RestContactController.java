package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Contact;
import org.gestion.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class RestContactController {

	@Autowired
	@Qualifier("contactServiceJpa")
	private IContactService contactServiceJpa;

	@Autowired
	@Qualifier("contactServiceRepository")
	private IContactService contactServiceRepository;

	@Autowired
	private RestProfileController restProfileController;

	// ********************************** //
	// ******* GET LIST contacts ********** //
	// ********************************** //

	@RequestMapping(path = "/contacts", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Contact> getContactsWithJPA() {

		return contactServiceJpa.getContacts();
	}

	
	// *********************************** //
	// ******* GET contact BY ID ********** //
	// *********************************** //

	@RequestMapping(path = "/{idContact}", method = RequestMethod.GET)
	@ResponseBody
	public Contact getContactById(@PathVariable("idContact") String idContact) {
		return contactServiceRepository.getContactById(Integer.parseInt(idContact));
	}

	// *********************************** //
	// ********** CREATE contacts ********** //
	// *********************************** //

	@RequestMapping(path = "/createContact", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public void createContact(@RequestBody Contact nouveauContact) {

		System.out.println(nouveauContact.getIdProfil());

		Contact newContact = new Contact(nouveauContact.getEmail(), nouveauContact.getNom(), nouveauContact.getPrenom(),
				nouveauContact.getGravatar(), nouveauContact.getNumTel(), nouveauContact.getAdresse(),
				nouveauContact.getCodePostal(), nouveauContact.getVille(),
				restProfileController.getProfilById(Integer.toString(nouveauContact.getIdProfil())));
		System.out.println(newContact);
		contactServiceRepository.create(newContact);

	}

	// *********************************** //
	// ******* UPDATE contact BY ID ******** //
	// *********************************** //

	
	
	
	//Update= la requete est bonne et on recupère bien les infos modifiées mais celles-ci ne s'inscrivent pas en base.
	
	@RequestMapping(path = "/update/{idContact}", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public void updateContact(@RequestBody Contact updateContact) {
		
		Contact upContact = new Contact(updateContact.getIdContact(), updateContact.getEmail(), updateContact.getNom(), updateContact.getPrenom(),
				updateContact.getGravatar(), updateContact.getNumTel(), updateContact.getAdresse(),
				updateContact.getCodePostal(),updateContact .getVille(),
				restProfileController.getProfilById(Integer.toString(updateContact.getIdProfil())));

		contactServiceRepository.update(upContact);
		System.out.println(upContact);
		
		
		
		
		
	}

	//
	// *********************************** //
	// ******* DELETE contact BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "/delete/{idContact}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteContact(@PathVariable("idContact") String idContact) {
		contactServiceRepository.deleteContact(Integer.parseInt(idContact));

	}
}