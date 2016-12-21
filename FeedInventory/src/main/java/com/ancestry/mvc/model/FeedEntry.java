package com.ancestry.mvc.model;

import java.io.Serializable;
import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Developer: Madan Dendi
 * Created Date: 12-21-2016
 * Name: HomeController
 * Its Hibernate  class which acts as a interface to save data in database
 * it will have mapping between form elements to Database table for Feed Entries
 */

@Entity
@Table(name="feedentries")
public class FeedEntry implements Serializable {

	@Id
	@Column(name="zooname")
	String zooname;
@Id
@Column(name="animal")
String animal;


@Id
@Column(name = "feedtime", columnDefinition="DATETIME")
Timestamp feedtime;

@Column(name="quantity")
int quantity;

public Timestamp getFeedtime() {
	return feedtime;
}

public void setFeedtime(Timestamp feedtime) {
	this.feedtime = feedtime;
}

public String getAnimal() {
	return animal;
}

public void setAnimal(String animal) {
	this.animal = animal;
}



public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public String getZooname() {
	return zooname;
}

public void setZooname(String zooname) {
	this.zooname = zooname;
}


}

