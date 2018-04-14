package com.techtransformers.lostnfound.service;

import com.techtransformers.lostnfound.entity.LostAndFoundEntity;

public interface LostAndFoundService {

	void insertLostItem(LostAndFoundEntity lostItem);

	void insertFoundItem(LostAndFoundEntity foundItem);
}
