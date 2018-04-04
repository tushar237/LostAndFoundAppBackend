package com.techtransformers.lostnfound.dao;

import com.techtransformers.lostnfound.entity.Student;

public interface StudentDao {

	Student findByRollNo(Integer rollNo);
}
