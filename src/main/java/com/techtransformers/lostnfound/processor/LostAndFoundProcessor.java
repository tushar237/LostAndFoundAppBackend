package com.techtransformers.lostnfound.processor;

import com.techtransformers.lostnfound.entity.LostAndFoundEntity;
import com.techtransformers.lostnfound.model.LostAndFound;

public class LostAndFoundProcessor {

	public static LostAndFoundEntity convertLostItemBeanToEntity(LostAndFound lostItem) {

		LostAndFoundEntity lostitem = new LostAndFoundEntity();

		if (null != lostItem) {
			lostitem.setCreatedOn(lostItem.getCreatedOn());
			lostitem.setCategory(lostItem.getData().getCategory());
			lostitem.setName(lostItem.getData().getName());
			lostitem.setEmail(lostItem.getData().getEmail());

			lostitem.setAttachment(lostItem.getData().getAttachment());
			lostitem.setDescription(lostItem.getData().getDescription());
			lostitem.setLostRcvDate(lostItem.getData().getLostRcvDate());
		}
		return lostitem;
	}

	public static LostAndFoundEntity convertFoundItemBeanToEntity(LostAndFound foundItem) {

		LostAndFoundEntity founditem = new LostAndFoundEntity();

		if (null != foundItem) {
			founditem.setCreatedOn(foundItem.getCreatedOn());
			founditem.setCategory(foundItem.getData().getCategory());
			founditem.setName(foundItem.getData().getName());
			founditem.setEmail(foundItem.getData().getEmail());

			founditem.setAttachment(foundItem.getData().getAttachment());
			founditem.setDescription(foundItem.getData().getDescription());
			founditem.setLostRcvDate(foundItem.getData().getLostRcvDate());
		}
		return founditem;
	}

}
