package org.gestion.repository;

import java.util.Date;
import java.util.List;

import org.gestion.entite.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MessageRepository extends JpaRepository<Message, Integer> {

	// List<Message> findById(Integer id);

	// @Query("select t from Message t")
	List<Message> findAll();

	// @Query("select u from Message u where u.id = :Id")
	// Contact findById(@Param("Id") Integer id);
	Message findByIdMessage(int idMessage);

	// création d'une méthode update au lieu d'utiliser save
	@Modifying
	@Query("update Message u set u.groupe = ?1, u.texte = ?2, u.dateDeCreation = ?3, u.statut = ?4, u.contactEmmetteur = ?5, u.contactDestinataire = ?6 where u.idMessage = ?7")
	int setUpdate(int idGroupe, String texte, Date dateDeCreation, String statut, int idContactEmmetteur,
			int idContactDestinataire, int idMessage);
}
