package com.techtransformers.lostnfound.service;

import java.util.List;

import com.techtransformers.lostnfound.entity.LostAndFoundEntity;

public interface LostAndFoundService {

	Integer insertLostAndFoundItem(LostAndFoundEntity lostAndFoundItem);
	List<LostAndFoundEntity> getLostAndFoundItems(String category);
}
