/**
 * 
 */
package com.springboot.rest.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.example.model.Student;
import com.springboot.rest.example.respository.StudentNotFoundException;
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
	
	@GetMapping("/student/{id}")
	public Student retrieveStudent(@PathVariable long id) {
		// java-8 feature of optional to deal with null pointer exception, loving it..
		Optional<Student> student=studentRepository.findById(id);
		if(!student.isPresent()) {
			throw new StudentNotFoundException("Student with id : " + id + ",  not in the database.");
		}	
		return student.get();
	}

}
