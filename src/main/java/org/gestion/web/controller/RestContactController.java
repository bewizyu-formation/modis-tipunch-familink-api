package org.gestion.web.controller;

import org.gestion.entite.Contact;
import org.gestion.entite.Profil;
import org.gestion.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class RestContactController {
	
	
	@Autowired
	@Qualifier("contactServiceJpa")
	private IContactService contactServiceJpa;

	@Autowired
	@Qualifier("contactServiceRepository")
	private IContactService contactServiceRepository;

	
	// ********************************** //
		// ******* GET LIST contacts ********** //
		// ********************************** //

		@RequestMapping(path = "/contacts", method = RequestMethod.GET, produces = "application/json")
		@ResponseBody
		public List<Contact> getContactsWithJPA() {

			return contactServiceJpa.getContacts();
		}

		/*@RequestMapping(path = "/withRepository", method = RequestMethod.GET, produces = "application/json")
		@ResponseBody
		public List<Contact> getContactsWithRepository() {
			return contactServiceRepository.getContacts();
		}
*/
		// *********************************** //
		// ******* GET contact BY ID ********** //
		// *********************************** //

		@RequestMapping(path = "/{idContact}", method = RequestMethod.GET)
		@ResponseBody
		public Contact getContactByIdWithPathParam(@PathVariable("idContact") String idContact) {
			return contactServiceRepository.getContactById(Integer.parseInt(idContact));
		}


		// *********************************** //
		// ********** CREATE contacts ********** //
		// *********************************** //


	    @RequestMapping(path="/createContact", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	    @ResponseBody
	    public void createContact (@RequestBody Contact nouveauContact) {
	       
	        Profil nouveauProfil = new Profil("MEDECIN","#FFFF00");
		Contact newContact = new Contact("jean.jacques@paul.fr", "paul", "pierre", "http://dggggs.fr", "0645124679", "2 rue des peupliers", "56600", "hugg", nouveauProfil);
	        

	        // utilisateurServiceJpa.create(newUtlilisateur);
	 
	         contactServiceRepository.create(newContact);
		}

		// *********************************** //
		// ******* UPDATE contact BY ID ******** //
		// *********************************** //

		@RequestMapping(path = "/{idContact}", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
		@ResponseBody
		public void updateContact(@RequestBody Contact updateContact) {

			contactServiceRepository.update(updateContact);
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


	
