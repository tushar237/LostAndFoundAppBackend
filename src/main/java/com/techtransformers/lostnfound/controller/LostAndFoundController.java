package com.techtransformers.lostnfound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techtransformers.lostnfound.entity.LostAndFoundEntity;
import com.techtransformers.lostnfound.model.LostAndFound;
import com.techtransformers.lostnfound.service.LostAndFoundService;

@RestController
public class LostAndFoundController {
	
	@Autowired
	private LostAndFoundService lostAndFoundService;
	
	@RequestMapping(value="/report/lost", method = RequestMethod.POST, headers="Accept=application/json")
    public void insertLostItem(@RequestBody LostAndFound lostItem) {
		
		 LostAndFoundEntity lostitem = new LostAndFoundEntity();
		 
		 lostitem.setCreatedOn(lostItem.getCreatedOn());
		 lostitem.setCategory(lostItem.getData().getCategory());
		 lostitem.setName(lostItem.getData().getName());
		 lostitem.setEmail(lostItem.getData().getEmail());
		 
		 lostitem.setAttachment(lostItem.getData().getAttachment());
		 lostitem.setDescription(lostItem.getData().getDescription());
		 lostitem.setLostRcvDate(lostItem.getData().getLostRcvDate());
		 
         lostAndFoundService.insertLostItem(lostitem);
    }
	
	@RequestMapping(value="/report/found", method = RequestMethod.POST, headers="Accept=application/json")
    public void insertFoundItem(@RequestBody LostAndFound foundItem) {
		
		 LostAndFoundEntity founditem = new LostAndFoundEntity();
		 
		 founditem.setCreatedOn(foundItem.getCreatedOn());
		 founditem.setCategory(foundItem.getData().getCategory());
		 founditem.setName(foundItem.getData().getName());
		 founditem.setEmail(foundItem.getData().getEmail());
		 
		 founditem.setAttachment(foundItem.getData().getAttachment());
		 founditem.setDescription(foundItem.getData().getDescription());
		 founditem.setLostRcvDate(foundItem.getData().getLostRcvDate());
		 
         lostAndFoundService.insertFoundItem(founditem);
    }
	
}
