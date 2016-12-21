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
 * it will have mapping between form elements to Database table for Feed Arrivals
 */

@Entity
@Table(name="feedarrival")
public class FeedShipArrival implements Serializable {

@Column(name="feedquantity")
int feedquantity;

@Id
@Column(name = "currentdate")
java.sql.Date currentdate;

@Id
@Column(name="zooname")
String zooname;


public int getFeedquantity() {
	return feedquantity;
}

public void setFeedquantity(int feedquantity) {
	this.feedquantity = feedquantity;
}

public java.sql.Date getCurrentdate() {
	return currentdate;
}

public void setCurrentdate(java.sql.Date currentdate) {
	this.currentdate = currentdate;
}

public String getZooname() {
	return zooname;
}

public void setZooname(String zooname) {
	this.zooname = zooname;
}


}

