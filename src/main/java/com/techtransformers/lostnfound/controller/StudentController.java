package com.techtransformers.lostnfound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtransformers.lostnfound.entity.Student;
import com.techtransformers.lostnfound.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/student/{rollNo}")
    public Student message(@PathVariable Integer rollNo) {
        return studentService.findByRollNo(rollNo);
    }
	
}
