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

	public void insertLostItem(LostAndFoundEntity lostItem) {
		lostAndFoundDao.insertLostItem(lostItem);
	}

	public void insertFoundItem(LostAndFoundEntity foundItem) {
		lostAndFoundDao.insertFoundItem(foundItem);
	}

}