package com.example.college.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.college.model.Lecturer;
import com.example.college.repository.LecturerRepository;


@Service
public class LecturerService {
	@Autowired
	private LecturerRepository lecturerRepository;
	
	public Long saveLecturer(Lecturer lecturer) {
		lecturerRepository.save(lecturer);
		return lecturer.getLecturerId();
	}
	
	public List<Lecturer> findAllLecturers(){
		List<Lecturer> allLecturers = new ArrayList<>();
		for( Lecturer lecturer: lecturerRepository.findAll()) {
			allLecturers.add(lecturer);
		}
		return allLecturers;
	}
	public Lecturer findLecturerById(Long id) {
		Optional<Lecturer> lecturer = lecturerRepository.findById(id);
        return lecturer.orElse(null);
	}
	public List<Lecturer> findLecturerByDep(String dep){
		return new ArrayList<>(lecturerRepository.findByDepartment(dep));
	}
	
	public void deleteLecturer(Lecturer lecturer) {
		lecturerRepository.delete(lecturer);
	}
	

}
