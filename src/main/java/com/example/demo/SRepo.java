package com.example.demo;


import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SRepo extends CrudRepository<Student,Long> {

}
