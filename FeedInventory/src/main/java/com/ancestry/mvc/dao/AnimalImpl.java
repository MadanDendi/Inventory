package com.ancestry.mvc.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ancestry.mvc.model.AddAnimal;
import com.ancestry.mvc.model.FeedEntry;
import com.ancestry.mvc.model.FeedShipArrival;

/**
 * Developer: Madan Dendi
 * Created Date: 12-21-2016
 * Name: AnimalImpl
 * Its implementation class for AnimalDao, perform functionalities 
 */


public class AnimalImpl implements AnimalDao{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//Perform functionality to save Animals,zoo names accordingly 
	@Override
	public void saveAnimal(AddAnimal animaladd) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(animaladd);
		session.getTransaction().commit();
		
	}

	//Perform functionality to save Feed Arrival Quantity ,zoo names accordingly 
	@Override
	public void saveFeedShipment(FeedShipArrival addfeedship) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(addfeedship);
		session.getTransaction().commit();
		
	}
	
	//Perform functionality which returns Animals,Zoo names accordingly  

	@Override
	public List<AddAnimal> getAnimals() {
		
		Session session = sessionFactory.openSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		org.hibernate.Query query = session.createSQLQuery("select * from animal");
		
		Map<String,Object> row = null;
		List<Object[]> list = query.list();
		List<AddAnimal> animallist = new ArrayList<AddAnimal>();
		for(Object[] objs:list){
			AddAnimal ditem=new AddAnimal();
			System.out.println("Animal"+objs[0]);
			ditem.setZooname(objs[0].toString());
			ditem.setAnimalname(objs[1].toString());
			
			animallist.add(ditem);
		}
		
		return animallist;
	}
	
	//Perform functionality which saves  Animals feeds  

	@Override
	public Boolean saveAnimalFeed(FeedEntry feedentry) {
		
		
		
		Session session=sessionFactory.openSession();
		org.hibernate.Query query = session.createSQLQuery("select a.feedquantity-sum(b.quantity) from feedarrival a,feedentries b "
				+ "where a.zooname=b.zooname and b.zooname=:zooname and currentdate=CURDATE()");
		query.setParameter("zooname", feedentry.getZooname());
		int value=((Number) query.uniqueResult()).intValue();
		System.out.println("Result value is :"+value);
		if((value-feedentry.getQuantity()) >=0)
		{
		session.beginTransaction();
		session.save(feedentry);
		session.getTransaction().commit();
		}
		else
		{
			return false;
		}
		return true;
		
	}

	@Override
	public List<AddAnimal> getZooList() {
		Session session = sessionFactory.openSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		org.hibernate.Query query = session.createSQLQuery("select  * from animal");
		
		Map<String,Object> row = null;
		List<Object[]> list = query.list();
		List<AddAnimal> zoolist = new ArrayList<AddAnimal>();
		for(Object[] objs:list){
			AddAnimal dItem=new AddAnimal();
			//System.out.println("Zoo"+objs.toString());
			dItem.setAnimalname(objs[1].toString());
			dItem.setZooname(objs[0].toString());
			
			zoolist.add(dItem);
		}
		
		return zoolist;
		
	}
}
