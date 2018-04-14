package com.techtransformers.lostnfound.dao;

import com.techtransformers.lostnfound.entity.LostAndFoundEntity;

public interface LostAndFoundDao {

	Integer insertLostItem(LostAndFoundEntity item);

	Integer insertFoundItem(LostAndFoundEntity item);
}
