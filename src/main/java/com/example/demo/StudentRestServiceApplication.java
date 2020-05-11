package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class StudentRestServiceApplication {

	public static void main(String[] args) {
		System.out.println("i am busy");
		SpringApplication.run(StudentRestServiceApplication.class, args);
		System.out.println("sunday is holioday");
	}
	@PostConstruct
	public void test() {
		System.out.println("hellow : how are you ---------------------->");
	}

}

