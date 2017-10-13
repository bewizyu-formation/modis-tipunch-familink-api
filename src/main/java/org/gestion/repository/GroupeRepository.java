package org.gestion.repository;

import java.util.List;

import org.gestion.entite.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GroupeRepository extends JpaRepository<Groupe, Integer> {

	// List<Groupe> findById(Integer id);

	// @Query("select t from Groupe t")
	List<Groupe> findAll();

	// @Query("select u from Groupe u where u.id = :Id")
	// Groupe findById(@Param("Id") Integer id);
	Groupe findByIdGroupe(int idGroupe);

	// création d'une méthode update au lieu d'utiliser save
	@Modifying
	@Query("update Groupe u set u.nom = ?1, u.dateDeCreation = ?2 where u.idGroupe = ?9")
	int setUpdate(String nomGroupe, String dateDeCreation, int idGroupe);
}
