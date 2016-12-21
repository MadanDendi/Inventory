package com.ancestry.mvc.service;

import java.util.List;
import java.util.Map;

import com.ancestry.mvc.dao.AnimalDao;
import com.ancestry.mvc.model.AddAnimal;
import com.ancestry.mvc.model.AnimalAvgFeed;
import com.ancestry.mvc.model.FeedEntry;
import com.ancestry.mvc.model.FeedShipArrival;
import com.ancestry.mvc.model.Zoo;
import com.ancestry.mvc.model.ZooWastage;

public class AnimalService {
	
	private AnimalDao animalDao=null;

	public AnimalDao getAnimalDao() {
		return animalDao;
	}

	public void setAnimalDao(AnimalDao animalDao) {
		this.animalDao = animalDao;
	}
	
	public void saveAnimal(AddAnimal animaladd)
	{
		animalDao.saveAnimal(animaladd);
	}
	public void saveFeedShipment(FeedShipArrival addfeedship) {
	 animalDao.saveFeedShipment(addfeedship);
	}

	public List<AddAnimal> getAnimals() {
	 return animalDao.getAnimals();
	}
	public Boolean saveAnimalFeed(FeedEntry feedentry) {
		return animalDao.saveAnimalFeed(feedentry);
	}
	
	public List<Zoo> getZooList() 
	{
		return animalDao.getZooList();
	}
	public  List<AnimalAvgFeed> avgAnimalFeed()
	{
		return animalDao.avgAnimalFeed();
	}
	public List<ZooWastage> zooWastage()
	{
		return animalDao.zooWastage();
	}
}
