/**
 * 
 */
package com.springboot.rest.example.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent()) {
			throw new StudentNotFoundException("Student with id : " + id + ",  not in the database.");
		}
		return student.get();
	}

	@DeleteMapping("/student/{id}")
	public void deleteByStudenId(@PathVariable long id) {
		studentRepository.deleteById(id);
	}

	@PostMapping("/students")
	public ResponseEntity<Object> createStudent(@RequestBody Student student){
	        Student saveStudent=studentRepository.save(student);
	        
	        URI location=ServletUriComponentsBuilder.fromCurrentRequest().
	        		path("/{id}").buildAndExpand(saveStudent.getId()).toUri();
	        
	        return ResponseEntity.created(location).build();
	}

	@PutMapping("/students/{id}")
	public void updateStudent(@RequestBody Student student,@PathVariable Long id){
		
		Optional<Student> studentOptional=studentRepository.findById(id);
		if(!studentOptional.isPresent()) {
			throw new StudentNotFoundException("student with id : " + id + ", not present ");
		}
		student.setId(id);
		studentRepository.save(student); 
	}
	

}
