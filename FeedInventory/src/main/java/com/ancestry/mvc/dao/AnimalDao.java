package com.ancestry.mvc.dao;


import java.util.List;
import com.ancestry.mvc.model.AddAnimal;
import com.ancestry.mvc.model.AnimalAvgFeed;
import com.ancestry.mvc.model.AvgFeedTimes;
import com.ancestry.mvc.model.FeedEntry;
import com.ancestry.mvc.model.FeedShipArrival;
import com.ancestry.mvc.model.Zoo;
import com.ancestry.mvc.model.ZooAnimalCompareFeed;
import com.ancestry.mvc.model.ZooWastage;

/**
 * Developer: Madan Dendi
 * Created Date: 12-21-2016
 * Name: AnimalDao
 * Its DAO interface .
 */

public interface AnimalDao {
	public void saveAnimal(AddAnimal animaladd);
	public void saveFeedShipment(FeedShipArrival addfeedship);
	public List<AddAnimal> getAnimals();
	public Boolean saveAnimalFeed(FeedEntry feedentry);
	public List<Zoo> getZooList();
	public  List<AnimalAvgFeed> avgAnimalFeed();
	public List<ZooWastage> zooWastage();
	public List<AvgFeedTimes> avgFeedTimes();
	 public List<ZooAnimalCompareFeed> compareAnimalFeedAvgZoo();


}
