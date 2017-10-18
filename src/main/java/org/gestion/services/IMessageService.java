package org.gestion.services;

import java.util.List;

import org.gestion.entite.Message;

/**
 * Interface qui liste les méthodes de persistence pour la classe
 * {@link Message} que doit posséder une classe d'implémentation
 *
 * @author van-rottana YOU
 */
public interface IMessageService {

	/**
	 * Sauvegarde un nouveau Message
	 *
	 * @param nouveauGrade
	 *            nouveau Message
	 */
	Message create(Message nouveauMessage);

	/**
	 * Mise à jour d'un Message
	 *
	 * @param Message
	 */
	void update(Message message);

	/**
	 * Extrait tous les Messages existants
	 *
	 * @return
	 */
	List<Message> getMessages();

	/**
	 * Récupération d'un Message par son id
	 * 
	 * @param id
	 * @return
	 */
	Message getMessageById(final int id);

	/**
	 * Suppression d'un Message
	 * 
	 * @param id
	 */
	void deleteMessage(final int id);
}
