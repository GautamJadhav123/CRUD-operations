package com.curdOperations.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.curdOperations.enitity.Student;
import com.curdOperations.repository.StudentRepository;
import com.curdOperations.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public ResponseEntity<String> saveStudent(Student student) {
	
		this.studentRepository.save(student);
		return new ResponseEntity<> ("Student record created successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updateStudent(Student student, Integer id) {
		
		Optional<Student> optional = this.studentRepository.findById(id);
		optional.get().setFirstName(student.getFirstName());
		optional.get().setLastName(student.getLastName());
		optional.get().setEmail(student.getEmail());
		optional.get().setCity(student.getCity());
		optional.get().setMobileNo(student.getMobileNo());
		
		this.studentRepository.save(optional.get());
		return new ResponseEntity<> ("Record updated successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Student> getStudentById(Integer id) {
		
		return new ResponseEntity<> (this.studentRepository.findById(id).get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Student>> getAllStudent() {
		
		return new ResponseEntity<> (this.studentRepository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteStudentById(Integer id) {
		try {
		Optional<Student> optional = this.studentRepository.findById(id);
		if (!Objects.isNull(optional)) {
			this.studentRepository.delete(optional.get());
			return new ResponseEntity<> ("Record deleted Successfully", HttpStatus.OK);
		}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<> ("Record does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
