package com.ancestry.mvc.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Developer: Madan Dendi
 * Created Date: 12-21-2016
 * Name: HomeController
 * Its Hibernate  class which acts as a interface to save data in database
 * it will have mapping between form elements to Database table for Animals
 */

@Entity
@Table(name="animal")
public class AddAnimal implements Serializable{
	
	@Id 
	@Column(name="zooname")
	private String zooname;
	
	@Id
	@Column(name="animalname")
	String animalname;


	public String getAnimalname() {
		return animalname;
	}

	public void setAnimalname(String animalname) {
		this.animalname = animalname;
	}

	public String getZooname() {
		return zooname;
	}

	public void setZooname(String zooname) {
		this.zooname = zooname;
	}

	

	

	
	
}
