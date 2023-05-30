package com.curdOperations.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curdOperations.enitity.Student;
import com.curdOperations.service.StudentService;

@RestController
@RequestMapping (path = "/crud/student")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	//save student in database
	@PostMapping (path = "/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		try {
			return this.studentService.saveStudent(student);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<> ("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//update student in database
	@PutMapping (path = "/update/{id}")
	public ResponseEntity<String> updateStudent (@RequestBody Student student, @PathVariable Integer id){
		try {
			return   this.studentService.updateStudent(student, id);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<> ("Something wend wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//get student by student id
	@GetMapping (path = "/get/{id}")
	public ResponseEntity<Student> getStudent (@PathVariable Integer id){
		try {
			return this.studentService.getStudentById(id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<> (new Student(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//get all students from the database
	@GetMapping (path = "/getall")
	public ResponseEntity<List<Student>> getAllStudents (){
		try {
			return this.studentService.getAllStudent();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<> (new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//delete student record from the database
	@DeleteMapping (path = "/delete/{id}")
	public ResponseEntity <String> deleteStudentById (@PathVariable Integer id){
		try {
			return this.studentService.deleteStudentById(id);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<> ("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	

}
