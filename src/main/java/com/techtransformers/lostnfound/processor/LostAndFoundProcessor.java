package com.techtransformers.lostnfound.processor;

import com.techtransformers.lostnfound.entity.LostAndFoundEntity;
import com.techtransformers.lostnfound.model.LostAndFound;

public class LostAndFoundProcessor {

	public static LostAndFoundEntity convertLostItemBeanToEntity(LostAndFound lostAndFoundItem) {

		LostAndFoundEntity lostAndFoundEntity = new LostAndFoundEntity();

		if (null != lostAndFoundItem) {
			lostAndFoundEntity.setCreatedOn(lostAndFoundItem.getCreatedOn());
			lostAndFoundEntity.setCategory(lostAndFoundItem.getData().getCategory());
			lostAndFoundEntity.setName(lostAndFoundItem.getData().getName());
			lostAndFoundEntity.setEmail(lostAndFoundItem.getData().getEmail());

			lostAndFoundEntity.setAttachment(lostAndFoundItem.getData().getAttachment());
			lostAndFoundEntity.setDescription(lostAndFoundItem.getData().getDescription());
			lostAndFoundEntity.setLostRcvDate(lostAndFoundItem.getData().getLostRcvDate());
		}
		return lostAndFoundEntity;
	}
}
