package com.techtransformers.lostnfound.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtransformers.lostnfound.dao.LostAndFoundDao;
import com.techtransformers.lostnfound.entity.LostAndFoundEntity;
import com.techtransformers.lostnfound.service.LostAndFoundService;

@Service("lostAndFoundService")
public class LostAndFoundServiceImpl implements LostAndFoundService {

	@Autowired
	private LostAndFoundDao lostAndFoundDao;

	public Integer insertLostAndFoundItem(LostAndFoundEntity lostAndFoundItem) {
		return lostAndFoundDao.insertLostAndFoundItem(lostAndFoundItem);
	}

	public List<LostAndFoundEntity> getLostAndFoundItems(String category) {
		
		List<LostAndFoundEntity> lostAndFoundItem = new ArrayList<LostAndFoundEntity>();
		if(category != null && !category.isEmpty()) {
			lostAndFoundItem = lostAndFoundDao.getLostAndFoundItems(category);
		}
		return lostAndFoundItem;
	}
}
