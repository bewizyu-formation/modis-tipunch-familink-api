package org.gestion.services.impl;

import org.gestion.entite.Message;
import org.gestion.services.IMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service(value = "messageServiceJpa")
public class MessageServiceJpa implements IMessageService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Message create(Message nvMessage) {
		em.persist(nvMessage);
		return nvMessage;
	}

	@Override
	@Transactional
	public void update(Message message) {
		Query query = em.createQuery("FROM Message c WHERE c.idMessage=:IdMessage");
		query.setParameter("idMessage", message.getIdMessage());

		Message oldMessage = (Message) query.getSingleResult();
		if (!oldMessage.equals(null)) {
			oldMessage.setDateDeCreation(message.getDateDeCreation());
			oldMessage.setIdContactDestinataire(message.getIdContactEmmetteur());
			oldMessage.setIdContactEmmetteur(message.getIdContactEmmetteur());
			oldMessage.setGroupe(message.getGroupe());
			oldMessage.setStatut(message.isStatut());
			oldMessage.setTexte(message.getTexte());
			em.merge(oldMessage);
			em.flush();
		}
	}

	@Override
	public List<Message> getMessages() {
		TypedQuery<Message> query = em.createQuery("FROM Message", Message.class);
		return query.getResultList();
	}

	@Override
	public void deleteMessage(int id) {
		//em.getTransaction().begin();
		Message message = getMessageById(id);
		em.remove(message);
		//em.getTransaction().commit();
	}

	@Override
	public Message getMessageById(int id) {
		//em.getTransaction().begin();
		Message message = em.find(Message.class, id);
		//em.getTransaction().commit();
	    return message;
	}

}
