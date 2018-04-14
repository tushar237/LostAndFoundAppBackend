package com.techtransformers.lostnfound.dao;

import com.techtransformers.lostnfound.entity.LostAndFoundEntity;

public interface LostAndFoundDao {

	void insertLostItem(LostAndFoundEntity item);
	void insertFoundItem(LostAndFoundEntity item);
}
