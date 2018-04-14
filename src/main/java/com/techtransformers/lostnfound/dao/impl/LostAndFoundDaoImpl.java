package com.techtransformers.lostnfound.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techtransformers.lostnfound.dao.LostAndFoundDao;
import com.techtransformers.lostnfound.entity.LostAndFoundEntity;

@Repository("lostAndFoundDao")
@Transactional
public class LostAndFoundDaoImpl implements LostAndFoundDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer insertLostItem(LostAndFoundEntity lostItem) {
		return (Integer) sessionFactory.getCurrentSession().save(lostItem);
	}

	public Integer insertFoundItem(LostAndFoundEntity foundItem) {
		return (Integer) sessionFactory.getCurrentSession().save(foundItem);
	}
}
