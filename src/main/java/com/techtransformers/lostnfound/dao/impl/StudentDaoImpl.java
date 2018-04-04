package com.techtransformers.lostnfound.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techtransformers.lostnfound.dao.StudentDao;
import com.techtransformers.lostnfound.entity.Student;

@Repository("studentDao")
@Transactional
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Student findByRollNo(Integer rollNo) {
		return sessionFactory.getCurrentSession().get(Student.class, rollNo);
	}
	
	
}
