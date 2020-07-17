/**
 * 
 */
package com.springboot.rest.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.example.model.Student;
import com.springboot.rest.example.respository.StudentRepository;

/**
 * @author Atul Sharma
 *
 *         https://github.com/sourac
 */

@RestController
public class StudentResouceController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

}
