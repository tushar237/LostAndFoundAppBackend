package com.techtransformers.lostnfound.service;

import com.techtransformers.lostnfound.entity.Student;

public interface StudentService {

	Student findByRollNo(Integer rollNo);
}
