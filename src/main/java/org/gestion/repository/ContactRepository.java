package org.gestion.repository;

import java.util.List;

import org.gestion.entite.Contact;
import org.gestion.entite.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ContactRepository extends JpaRepository<Contact, Integer> {

//	List<Contact> findById(Integer id);
	
//	@Query("select t from Contact t")
	List<Contact> findAll();
	
//	@Query("select u from Contact u where u.id = :Id")
//	Contact findById(@Param("Id") Integer id);
	Contact findByIdContact(int idContact);
	
// création d'une méthode update au lieu d'utiliser save	
	@Modifying
	@Query("update Contact u set u.nom = ?1, u.prenom = ?2, u.gravatar = ?3, u.numTel = ?4, u.adresse = ?5, u.codePostal = ?6, u.ville = ?7, u.profil = ?8 where u.idContact = ?9")
	int setUpdate(String nom, String prenom, String gravatar, String numTel, String adresse, String code_postal, String ville, Profil profil, int idContact);
}
