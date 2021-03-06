package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Contact;
import org.gestion.entite.ContactForm;
import org.gestion.services.IContactService;
import org.json.JSONArray;
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

	@RequestMapping(path = "", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
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

	@RequestMapping(path = "", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public String updateContact(@RequestBody ContactForm updateContact) {

		Contact upContact = new Contact(updateContact.getIdContact(), updateContact.getEmail(), updateContact.getNom(),
				updateContact.getPrenom(), updateContact.getGravatar(), updateContact.getNumTel(),
				updateContact.getAdresse(), updateContact.getCodePostal(), updateContact.getVille(),
				restProfileController.getProfilById(Integer.toString(updateContact.getIdProfil())));

		contactServiceRepository.update(upContact);
		return new JSONObject().toString();

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

	//
	// *********************************** //
	// **** Get contact list by group **** //
	// *********************************** //

	@RequestMapping(path = "/group", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Contact> getContactsByGroupId() {

		return contactServiceJpa.getContactsByGroupId();
	}

	// ********************************** //
	// ******* GET LIST groupes d'un contact ********** //
	// ********************************** //

	@RequestMapping(path = "/{idUtilisateur}/groupes", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getContactsByIdGroupe(@PathVariable("idUtilisateur") String idUtilisateur,
			@RequestHeader(value = "Authorization", required = true) String requestToken) {

		JSONObject jObj;
		jObj = new JSONObject();
		JSONArray jsonArrayResultat = new JSONArray();

		try {
			Contact monContact = new Contact();
			monContact = contactServiceRepository.getContactById(Integer.parseInt(idUtilisateur));
			contactServiceJpa.getListeGroupes(Integer.parseInt(idUtilisateur));

			jObj.put("action", "lister groupes du contact");
			jObj.put("description", "liste créé");
			for (int i = 0; i < contactServiceJpa.getListeGroupes(Integer.parseInt(idUtilisateur)).size(); i++) {
				jsonArrayResultat.put(contactServiceJpa.getListeGroupes(Integer.parseInt(idUtilisateur)).get(i));
			}
			jObj.put("groupes", jsonArrayResultat);

		} catch (Exception e) {

			jObj.put("action", "lister groupes du contact");
			jObj.put("description", "liste non créée");

		}
		return jObj.toString();

	}

}
