package com.techtransformers.lostnfound.dao;

import java.util.List;

import com.techtransformers.lostnfound.entity.LostAndFoundEntity;

public interface LostAndFoundDao {

	Integer insertLostAndFoundItem(LostAndFoundEntity item);
	
	List<LostAndFoundEntity> getLostAndFoundItems(String category);
}
