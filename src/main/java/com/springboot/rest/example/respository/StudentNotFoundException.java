/**
 * 
 */
package com.springboot.rest.example.respository;

/**
 * @author Atul Sharma
 *
 *         https://github.com/sourac
 */
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(String msg) {
		super(msg);
	}

}
