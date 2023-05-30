package com.curdOperations.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.curdOperations.enitity.Student;

public interface StudentService {
	
	public ResponseEntity<String> saveStudent (Student student);
	
	public ResponseEntity<String> updateStudent (Student student, Integer id);
	
	public ResponseEntity<Student> getStudentById (Integer id);
	
	public ResponseEntity<List<Student>> getAllStudent ();
	
	public ResponseEntity<String> deleteStudentById (Integer id);

}
