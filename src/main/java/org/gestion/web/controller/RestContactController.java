package org.gestion.web.controller;

import java.util.List;
import java.util.Set;

import org.gestion.entite.Contact;
import org.gestion.entite.ContactForm;
import org.gestion.entite.Groupe;
import org.gestion.services.IContactService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Julien Bertrand
 */

@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "*", allowedHeaders = "authorization")
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

	@RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json")
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

	@RequestMapping(path = "", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String createContact(@RequestBody ContactForm nouveauContact) {

		JSONObject jObj;
		jObj = new JSONObject();

		try {
			Contact newContact = new Contact(nouveauContact.getEmail(), nouveauContact.getNom(),
					nouveauContact.getPrenom(), nouveauContact.getGravatar(), nouveauContact.getNumTel(),
					nouveauContact.getAdresse(), nouveauContact.getCodePostal(), nouveauContact.getVille(),
					restProfileController.getProfilById(Integer.toString(nouveauContact.getIdProfil())));
			contactServiceRepository.create(newContact);

			jObj.put("action", "creation contact");
			jObj.put("description", "Contact créé");

		} catch (Exception e) {

			jObj.put("action", "creation contact");
			jObj.put("description", "Echec creation contact");

		}
		return jObj.toString();
	}

	// *********************************** //
	// ******* UPDATE contact BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public void updateContact(@RequestBody ContactForm updateContact) {

		Contact upContact = new Contact(updateContact.getIdContact(), updateContact.getEmail(), updateContact.getNom(),
				updateContact.getPrenom(), updateContact.getGravatar(), updateContact.getNumTel(),
				updateContact.getAdresse(), updateContact.getCodePostal(), updateContact.getVille(),
				restProfileController.getProfilById(Integer.toString(updateContact.getIdProfil())));

		contactServiceRepository.update(upContact);

	}

	//
	// *********************************** //
	// ******* DELETE contact BY ID ******** //
	// *********************************** //

	@RequestMapping(path = "/{idContact}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteContact(@PathVariable("idContact") String idContact) {
		contactServiceRepository.deleteContact(Integer.parseInt(idContact));

	}

	@RequestMapping(path = "/group", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Contact> getContactsByGroupId() {

		return contactServiceJpa.getContactsByGroupId();
	}

//	// ********************************** //
//	// ******* GET LIST groupes d'un contact ********** //
//	// ********************************** //
//
//	@RequestMapping(path = "/{idContact}/groupes", method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//	public Set<Groupe> getContactsByIdGroupe(@PathVariable("idContact") String idContact,
//			@RequestHeader(value = "Authorization", required = true) String requestToken) {
//
//		Contact monContact = new Contact();
//		monContact = contactServiceRepository.getContactById(Integer.parseInt(idContact));
//		return monContact.getListeGroupesContact();
//
//	}

}
