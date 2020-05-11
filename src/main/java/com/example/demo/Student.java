package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;



@Component
@Entity(name="studentdb")
@Table(name ="student")

public class Student {
	@Id
	@Column(name="student_id" , unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")//not working
	@SequenceGenerator(name = "student_generator", allocationSize = 50, sequenceName = "studentid_seq")//not working
	//@GeneratedValue( generator = "system-uuid")
	//@GenericGenerator(name="system-uuid", strategy = "uuid")
	//@SequenceGenerator(name = "system-uuid", allocationSize = 1, sequenceName = "studentid_seq")
	private Long id;
	
	@Column(name="student_name")
	private String name;
	@Column(name="student_age")
	private Long  age;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Long getAge() {
		return age;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
	
	
	

}
