package com.techtransformers.lostnfound.service;

import com.techtransformers.lostnfound.entity.LostAndFoundEntity;

public interface LostAndFoundService {

	Integer insertLostItem(LostAndFoundEntity lostItem);

	Integer insertFoundItem(LostAndFoundEntity foundItem);
}
