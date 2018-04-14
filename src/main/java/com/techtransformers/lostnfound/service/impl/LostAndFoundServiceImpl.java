package com.techtransformers.lostnfound.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtransformers.lostnfound.dao.LostAndFoundDao;
import com.techtransformers.lostnfound.entity.LostAndFoundEntity;
import com.techtransformers.lostnfound.service.LostAndFoundService;

@Service("lostAndFoundService")
public class LostAndFoundServiceImpl implements LostAndFoundService {

	@Autowired
	private LostAndFoundDao lostAndFoundDao;

	public Integer insertLostItem(LostAndFoundEntity lostItem) {
		return lostAndFoundDao.insertLostItem(lostItem);
	}

	public Integer insertFoundItem(LostAndFoundEntity foundItem) {
		return lostAndFoundDao.insertFoundItem(foundItem);
	}

}
