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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

}
