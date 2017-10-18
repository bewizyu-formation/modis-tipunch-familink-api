package org.gestion.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//Cette classe est ajoutée pour la suite afin de rajouter des contacts favoris dans les groupes


@Entity
@Table(name = "FAVORIS")
public class Favoris {

	/**
	 * idGroupe : Int
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFavoris;


	public Favoris() {
		super();
	}


	public int getIdFavoris() {
		return idFavoris;
	}

}
