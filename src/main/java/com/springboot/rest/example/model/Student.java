/**
 * 
 */
package com.springboot.rest.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Atul Sharma
 *
 *         https://github.com/sourac
 */
@Entity
public class Student {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String passportNumber;

	public Student() {
	}

}
