package com.example.college.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.college.model.Lecturer;

import java.util.List;

public interface LecturerRepository extends CrudRepository<Lecturer,Long> {
	
	List<Lecturer> findByDepartment(String dep);

}
