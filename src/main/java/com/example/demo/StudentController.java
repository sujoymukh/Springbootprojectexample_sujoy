package com.example.demo;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	StudentService s;

	@PostMapping(path="/createstudentdata")
	public  Student createStudent(@RequestBody Student stud) 
	{
		return s.addstudent(stud);

		
		//return "student  information saved successfully ::."+ stud.getId()+ " " +stud.getName()+ " " +stud.getAge();
		
	}
	
	
	@GetMapping("/getallstudent") 
	public Iterable<Student> student()
	{
		
		Iterable<Student> std= s.getStudentList();
		return std;
	}


  @GetMapping("/getstudentbyid/{studentId}") 
  public Optional<Student> retrieveStudent(@PathVariable Long studentId )
  {
	  return s.retrieveStudent(studentId); 
			  
  }
  @DeleteMapping("/deletestudent/{id}")
  public void deleteStudent(@PathVariable Long id) {
  	s.deleteById(id);
  }
  @PutMapping("/updatestudent")
  public Student updateStudent(@RequestBody Student student)
  {
      return s.updatestudent(student);
  }
	
}

  
   
   
  
  
  
 
