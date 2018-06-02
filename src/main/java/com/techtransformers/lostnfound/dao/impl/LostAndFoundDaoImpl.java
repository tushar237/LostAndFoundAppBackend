package com.techtransformers.lostnfound.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techtransformers.lostnfound.constants.LostAndFoundConstants;
import com.techtransformers.lostnfound.constants.LostAndFoundQueries;
import com.techtransformers.lostnfound.dao.LostAndFoundDao;
import com.techtransformers.lostnfound.entity.LostAndFoundEntity;

@Repository("lostAndFoundDao")
@Transactional
public class LostAndFoundDaoImpl implements LostAndFoundDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer insertLostAndFoundItem(LostAndFoundEntity lostAndFoundItem) {
		return (Integer) sessionFactory.getCurrentSession().save(lostAndFoundItem);
	}

	@SuppressWarnings("unchecked")
	public List<LostAndFoundEntity> getLostAndFoundItems(String category) {
		
		List<LostAndFoundEntity> items = new ArrayList<LostAndFoundEntity>();
		Query query = sessionFactory.getCurrentSession().createNativeQuery(LostAndFoundQueries.LOST_FOUND_ITEM_QUERY, LostAndFoundEntity.class);
		query.setParameter(LostAndFoundConstants.ONE, category);
		items = (List<LostAndFoundEntity>)query.getResultList();
		return items;
	}
}
