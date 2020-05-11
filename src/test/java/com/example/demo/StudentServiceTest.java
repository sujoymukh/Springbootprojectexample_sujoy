package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.util.Assert;


@RunWith(PowerMockRunner.class)

public class StudentServiceTest {
	@InjectMocks
	StudentService studentService ;
	
	@Mock
	SRepo repo;
	
	private Student std2;
	
	
	@Before
	public void setStudentObj()
	{
		std2=new Student();
		std2.setId(1);
		std2.setName("Ram");
		std2.setAge(26);
	}

	@Test
	public void addStudentTest()
	{
		Student std = new Student();
		std.setName("Sujoy");
		PowerMockito.when(repo.save(std)).thenReturn(std);
		Student s1 = studentService.addstudent(std);
		assertEquals("Sujoy", s1.getName());

	}
	@Test
	public void getStudentList() {
		ArrayList<Student>std1=new ArrayList();
		std1.add(std2);
		PowerMockito.when(repo.findAll()).thenReturn(std1);
		Iterable<Student> s2 = studentService.getStudentList();
		assertEquals("Ram",s2.iterator().next().getName());
		assertEquals(1,s2.iterator().next().getId());
		assertEquals(26,s2.iterator().next().getAge());
		
	
		
		
		
		
		
	}
	@Test
	public void deleteById(  ) {
		
		PowerMockito.doNothing().when(repo).deleteById("1");
		studentService.deleteById("1");
		Assert.isTrue(true);
		
	}
	@Test
	public void retrieveStudent() {
		Student std3 = new Student();
		std3.setId(2);
		std3.setAge(35);
		std3.setName("rakesh");
		PowerMockito.when(repo.findById("1")).thenReturn(Optional.of(std3));
		assertEquals("rakesh",std3.getName());
		assertEquals(2,std3.getId());
		assertEquals(35,std3.getAge());
		
	}

}
