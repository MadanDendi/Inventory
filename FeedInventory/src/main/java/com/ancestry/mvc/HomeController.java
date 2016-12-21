package com.ancestry.mvc;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ancestry.mvc.model.AddAnimal;
import com.ancestry.mvc.model.FeedEntry;
import com.ancestry.mvc.model.FeedShipArrival;
import com.ancestry.mvc.service.AnimalService;




/**
 * Developer: Madan Dendi
 * Created Date: 12-21-2016
 * Name: HomeController
 * Handles all requests works as handler mapper.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	AnimalService animalService;

	/*
	 * Maps to the Home page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		return "home";
	}
	@RequestMapping(value = "home")
	public String home() {
        
		return "home";
	}

	/*
	 * Maps to the animals add form page , in order to add new animals
	 */
	@RequestMapping(value = "addanimal")
	public String addAnimal(Model model)
	{
		if(!model.containsAttribute("animaladd")) model.addAttribute("animaladd", new AddAnimal());
		model.addAttribute("","");
		return "addanimals";	
	}

	/*
	 * Perform function calling to save animals which got from form 
	 */
	
	@RequestMapping(value = "animaladd", method = RequestMethod.POST)
	public String Animal( @Valid @ModelAttribute("animaladd") AddAnimal animaladd, 
			BindingResult binding, 
			RedirectAttributes redirectAttributes,Model model){

		/*
		 * We use Try block in order to catch the exception if record already exist 
		 */
		try{

			animalService.saveAnimal(animaladd);
			model.addAttribute("msg","Saved Animals !!");
			return "home";
		}catch(Exception ie){
			model.addAttribute("msg","Animal Already exist !!");
			return "home";
		}

	}


	/*
	 * Maps to feedentry form
	 */

	@RequestMapping(value = "feedentries")
	public String feedEntry(Model model)
	{
		if(!model.containsAttribute("feedentry")) model.addAttribute("feedentry", new FeedEntry());
		List<AddAnimal> animallist=animalService.getAnimals();
		model.addAttribute("animallist", animallist);
		model.addAttribute("","");
		return "feedentry";	
	}
	/*
	 * Perform function calling to save animals feeding entries
	 */

	@RequestMapping(value = "feedentry", method = RequestMethod.POST)
	public String FeedEntryForm( @Valid @ModelAttribute("feedentry") FeedEntry feedentry, 
			BindingResult binding, 
			RedirectAttributes redirectAttributes,Model model,HttpServletRequest request){

		String slotdate_str=request.getParameter("feedtime").toString();
		DateFormat readFormat = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm");
		DateFormat writeFormat = new SimpleDateFormat( "MM/dd/yyyy HH:mm:sss");
		Date date = null;

		try {
			date = readFormat.parse( slotdate_str );
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		String formattedDate = "";
		if( date != null ) {
			formattedDate = writeFormat.format( date );
		}

		try {
			System.out.println(formattedDate);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date slotDate = simpleDateFormat.parse(formattedDate);
			DateTime datetime=new DateTime(slotDate);
			Timestamp aucStarttimeStamp = new Timestamp(datetime.getMillis());
			System.out.println("DATETIME IS :"+aucStarttimeStamp);
			feedentry.setFeedtime(aucStarttimeStamp);
			Boolean valid= animalService.saveAnimalFeed(feedentry);
			if(!valid)
			{
				model.addAttribute("msg","There is no sufficient feed !!");
				return "home";
			}

			model.addAttribute("msg","You have Feeded successfully !!");
			return "home";
		}catch(Exception ie){
			model.addAttribute("msg","Already Exist !!");
			return "home";

		}



	}
	/*
	 * Maps to feed shipment form
	 */

	@RequestMapping(value="feedshipment")
	public String feedShipment(Model model)
	{
		if(!model.containsAttribute("animaladd")) model.addAttribute("addfeedship", new FeedShipArrival());
		List<AddAnimal> zoolist=animalService.getZooList();

		model.addAttribute("zoolist", zoolist);
		model.addAttribute("","");
		return "dayfeedship";
	}

	/*
	 * Perform function calling to save feed arrival data
	 */
	@RequestMapping(value = "addfeedship", method = RequestMethod.POST)
	public String AddFeedShip( @Valid @ModelAttribute("addfeedship") FeedShipArrival addfeedship, 
			BindingResult binding, 
			RedirectAttributes redirectAttributes,Model model){
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		addfeedship.setCurrentdate(sqlDate);
		try{
			animalService.saveFeedShipment(addfeedship);
			model.addAttribute("msg","Feed Arrival Entries are saved !!");
			return "home";
		}
		catch(Exception ie){
			model.addAttribute("msg","Feed Arrival Entries already Exist !!");
			return "home";
		}
	}

	@RequestMapping(value="viewreports")
	public String viewReports(Model model)
	{

		return "viewreports";
	}


}
