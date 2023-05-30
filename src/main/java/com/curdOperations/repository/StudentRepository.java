package com.curdOperations.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.curdOperations.enitity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
