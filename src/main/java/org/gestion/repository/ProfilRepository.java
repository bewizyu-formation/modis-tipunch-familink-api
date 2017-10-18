package org.gestion.repository;

import java.util.List;

import org.gestion.entite.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProfilRepository extends JpaRepository<Profil, Integer> {

	// List<Profil> findById(Integer id);

	// @Query("select t from Profil t")
	List<Profil> findAll();

	// @Query("select u from Profil u where u.id = :Id")
	// Profil findById(@Param("Id") int id);
	Profil findByIdProfil(int idProfil);

	// création d'une méthode update au lieu d'utiliser save
	@Modifying
	@Query("update Profil u set u.nom = ?1, u.couleur = ?2 where u.idProfil = ?3")
	int setUpdate(String nom, String couleur, int id);
}
