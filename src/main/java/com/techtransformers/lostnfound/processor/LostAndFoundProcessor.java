package com.techtransformers.lostnfound.processor;

import java.util.ArrayList;
import java.util.List;

import com.techtransformers.lostnfound.Utility.LostAndFoundUtility;
import com.techtransformers.lostnfound.entity.LostAndFoundEntity;
import com.techtransformers.lostnfound.model.Data;
import com.techtransformers.lostnfound.model.LostAndFound;

public class LostAndFoundProcessor {

	public static LostAndFoundEntity convertLostItemBeanToEntity(LostAndFound lostAndFoundItem) {

		LostAndFoundEntity lostAndFoundEntity = new LostAndFoundEntity();

		if (null != lostAndFoundItem) {
			lostAndFoundEntity.setCreatedOn(LostAndFoundUtility.convertDateToTimeStamp(lostAndFoundItem.getCreatedOn()));
			lostAndFoundEntity.setCategory(lostAndFoundItem.getData().getCategory());
			lostAndFoundEntity.setName(lostAndFoundItem.getData().getName());
			lostAndFoundEntity.setEmail(lostAndFoundItem.getData().getEmail());

			lostAndFoundEntity.setAttachment(lostAndFoundItem.getData().getAttachment());
			lostAndFoundEntity.setDescription(lostAndFoundItem.getData().getDescription());
			lostAndFoundEntity.setLostRcvDate(LostAndFoundUtility.convertDateToTimeStamp(lostAndFoundItem.getData().getLostRcvDate()));
		}
		return lostAndFoundEntity;
	}
	
	public static List<LostAndFound> convertLostItemBeanToResponse(List<LostAndFoundEntity> lostAndFoundEntities) {

		List<LostAndFound> lostAndFoundResponse = new ArrayList<LostAndFound>();

		for(LostAndFoundEntity lostAndFoundEntity : lostAndFoundEntities) {
			
			LostAndFound lostAndFound = new LostAndFound();
			Data data = new Data();
			
			lostAndFound.setCreatedOn(LostAndFoundUtility.convertTimestampToDate(lostAndFoundEntity.getCreatedOn()));
			data.setCategory(lostAndFoundEntity.getCategory());
			data.setName(lostAndFoundEntity.getName());
			data.setEmail(lostAndFoundEntity.getEmail());

			data.setAttachment(lostAndFoundEntity.getAttachment());
			data.setDescription(lostAndFoundEntity.getDescription());
			data.setLostRcvDate(LostAndFoundUtility.convertTimestampToDate(lostAndFoundEntity.getLostRcvDate()));
			
			lostAndFound.setData(data);
			
			lostAndFoundResponse.add(lostAndFound);
		}
		return lostAndFoundResponse;
	}
}
