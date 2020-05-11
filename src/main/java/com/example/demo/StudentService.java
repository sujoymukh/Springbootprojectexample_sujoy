package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
@Autowired
SRepo repo;
	//static ArrayList<Student> StudentList= new ArrayList();
	
	public Student addstudent(Student s) {

		return repo.save(s);

	}
	public Iterable<Student> getStudentList(){
		return repo.findAll();
		//return  StudentList;
	}


	public  Optional<Student> retrieveStudent(Long studentId)
	{
		/*
		 * for (Student student : StudentList) { if (student.getId().equals(studentId))
		 * { return student; } } return null;
		 */
		return repo.findById(studentId);
	}
	
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	public Optional<Student> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public Student updatestudent(Student student) {
		// TODO Auto-generated method stub
		
		return repo.save(student);

	}
}



