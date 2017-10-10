package org.gestion.services.impl;

import org.gestion.entite.Message;
import org.gestion.repository.MessageRepository;
import org.gestion.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Van-Rottana YOU
 */
@Service(value = "messageServiceRepository")
public class MessageServiceRepository implements IMessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public void deleteMessage(int id) {
		messageRepository.delete(id);
	}

	@Override
	public Message getMessageById(int id) {
		return messageRepository.findOne(id);
	}

	@Override
	public Message create(Message nouveauMessage) {
		return messageRepository.save(nouveauMessage);
	}

	@Override
	public void update(Message message) {

		final Message toUpdate = messageRepository.findOne(message.getIdMessage());

		if (toUpdate != null) {
			toUpdate.setDateDeCreation(message.getDateDeCreation());
			toUpdate.setIdContactDestinataire(message.getIdContactEmmetteur());
			toUpdate.setIdContactEmmetteur(message.getIdContactEmmetteur());
			toUpdate.setGroupe(message.getGroupe());
			toUpdate.setStatut(message.isStatut());
			toUpdate.setTexte(message.getTexte());
			messageRepository.save(toUpdate);
		}

	}

	@Override
	public List<Message> getMessages() {
		return messageRepository.findAll();
	}
}
