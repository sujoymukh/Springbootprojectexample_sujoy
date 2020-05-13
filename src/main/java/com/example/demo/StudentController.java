package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
@RequestMapping("/Student")
public class StudentController {
	public static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	StudentService s;

	@PostMapping(path="/createstudentdata")
	public  Student createStudent(@RequestBody Student stud) 
	{
		return s.addstudent(stud);

		
		//return "student  information saved successfully ::."+ stud.getId()+ " " +stud.getName()+ " " +stud.getAge();
		
	}
	
	
	@GetMapping("/getallstudent") 
	public ResponseEntity<Iterable<Student>> student()
	{
		
		Iterable<Student> std= s.getStudentList();
		 if (std==null) {
	            return new ResponseEntity<Iterable<Student>>(HttpStatus.NO_CONTENT);
		//return std;
		 }
		 return new ResponseEntity<Iterable<Student>>(std, HttpStatus.OK);
	}
		 


  @GetMapping("/getstudentbyid/{studentId}") 
  public ResponseEntity<Optional<Student>> retrieveStudent(@PathVariable Long studentId )
  {
	  if (s == null) {
          logger.error("User with id {} not found.", studentId);
          return new ResponseEntity(new CustomErrorType("User with id " + studentId 
                  + " not found"), HttpStatus.NOT_FOUND);
      }
	  return new ResponseEntity<Optional<Student>>( s.retrieveStudent(studentId),HttpStatus.OK); 
			  
  }
  @DeleteMapping("/deletestudent/{id}")
  public ResponseEntity <?>  deleteStudent(@PathVariable Long id) {
	  if (s == null) {
          logger.error("Unable to delete. User with id {} not found.", id);
          return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                  HttpStatus.NOT_FOUND);
	  }
  	s.deleteById(id);
  	return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
  }
  @PutMapping("/updatestudent")
  public Student updateStudent(@RequestBody Student student)
  {
      return s.updatestudent(student);
  }
	
}

  
   
   
  
  
  
 
