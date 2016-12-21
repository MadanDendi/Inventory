package com.ancestry.mvc.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ancestry.mvc.model.AddAnimal;
import com.ancestry.mvc.model.AnimalAvgFeed;
import com.ancestry.mvc.model.AvgFeedTimes;
import com.ancestry.mvc.model.FeedEntry;
import com.ancestry.mvc.model.FeedShipArrival;
import com.ancestry.mvc.model.Zoo;
import com.ancestry.mvc.model.ZooWastage;

/**
 * Developer: Madan Dendi
 * Created Date: 12-21-2016
 * Name: AnimalImpl
 * Its implementation class for AnimalDao, perform functionalities 
 */


public class AnimalImpl implements AnimalDao{
	@Autowired
	private SessionFactory sessionFactory;

	/*public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

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

		org.hibernate.Query query = session.createSQLQuery("select * from animal");
		
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
		//System.out.println("Result value is :"+value);
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
	public List<Zoo> getZooList() {
		Session session = sessionFactory.openSession();

		org.hibernate.Query query = session.createSQLQuery("select  * from zoo");
		
		List<Object[]> list = query.list();
		List<Zoo> zoolist = new ArrayList<Zoo>();
		for(Object[] objs:list){
			Zoo dItem=new Zoo();
			//System.out.println("Zoo"+objs.toString());
			dItem.setZooname(objs[0].toString());
			//System.out.println("Distinct Zoo"+objs[0].toString());
			zoolist.add(dItem);
		}
		
		return zoolist;
		
	}

	@Override
	public List<AnimalAvgFeed> avgAnimalFeed() {
		
		Session session = sessionFactory.openSession();

		org.hibernate.Query query = session.createSQLQuery("select animal,avg(quantity) from feedentries group by animal");
		List<Object[]> list = query.list();
		
		List<AnimalAvgFeed> animalavgfeed = new ArrayList<AnimalAvgFeed>();
		for(Object[] objs:list){
			AnimalAvgFeed dItem=new AnimalAvgFeed();
			dItem.setAnimalname(objs[0].toString());
			dItem.setAvgfeed(Double.parseDouble(objs[1].toString()));
			
			
			animalavgfeed.add(dItem);
		}
		
		
		return animalavgfeed;
	}

	@Override
	public List<ZooWastage> zooWastage() {
		Session session = sessionFactory.openSession();

		org.hibernate.Query query = session.createSQLQuery("select a.zooname,a.feedquantity-IFNULL(sum(b.quantity),0) from feedarrival a LEFT JOIN feedentries b"
				+ " on a.zooname=b.zooname and a.currentdate=CURDATE() group by zooname;");
	
		List<Object[]> list = query.list();
		
		List<ZooWastage> zoowastage = new ArrayList<ZooWastage>();
		for(Object[] objs:list){
			ZooWastage dItem=new ZooWastage();
			dItem.setZooname((objs[0].toString()));
			dItem.setWaste(Double.parseDouble(objs[1].toString()));
			
			
			zoowastage.add(dItem);
		}
		
		
		return zoowastage;
	}

	@Override
	public List<AvgFeedTimes> avgFeedTimes() {
		Session session = sessionFactory.openSession();

		org.hibernate.Query query = session.createSQLQuery("select animal,count(animal) from feedentries where DATE(feedtime)=CURDATE() group by animal");
		org.hibernate.Query query1=session.createSQLQuery("select animal,count(*) from (select distinct animal,zooname from feedentries) as a group by animal");
		List<Object[]> list = query.list();
		List<Object[]> list1 = query1.list();
		List<AvgFeedTimes> avgfeedtimes = new ArrayList<AvgFeedTimes>();
		for(Object[] objs:list){
			AvgFeedTimes dItem=new AvgFeedTimes();
			for(Object[] objs2:list1)
			{
				if(objs[0].equals(objs2[0]))
				{
				 // System.out.println(objs[0].toString()+" "+ Math.ceil(Integer.parseInt(objs[1].toString())/Integer.parseInt(objs2[1].toString())));
					dItem.setAnimalname(objs[0].toString());
					dItem.setAvgoftimes(Math.ceil(Integer.parseInt(objs[1].toString())/Integer.parseInt(objs2[1].toString())));
					avgfeedtimes.add(dItem);
				}
			}
		}
		return avgfeedtimes;
		
	}
	
	
}
