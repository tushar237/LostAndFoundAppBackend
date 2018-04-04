package com.techtransformers.lostnfound.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtransformers.lostnfound.dao.StudentDao;
import com.techtransformers.lostnfound.entity.Student;
import com.techtransformers.lostnfound.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	public Student findByRollNo(Integer rollNo) {
		
		return studentDao.findByRollNo(rollNo);
	}
}
