/**
 * 
 */
package com.springboot.rest.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.example.model.Student;

/**
 * @author Atul Sharma
 *
 * https://github.com/sourac
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
