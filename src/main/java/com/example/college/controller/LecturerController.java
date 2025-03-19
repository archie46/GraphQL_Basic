package com.example.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.college.model.Lecturer;
import com.example.college.service.LecturerService;

@Controller
public class LecturerController {
	
	@Autowired
	public LecturerService lecturerService;
	
	
	
	@QueryMapping
	public List<Lecturer> findAll(){
		return lecturerService.findAllLecturers();
	}
	@QueryMapping
	public Lecturer getLecturerById(@Argument Long id) {
		return lecturerService.findLecturerById(id);
	}
	
	@MutationMapping
	public void createLecturer(@Argument String lecturerName,@Argument String address, @Argument String department ,@Argument String eMail,@Argument String phone,@Argument String courseHandled ) {
		Lecturer lecturer = new Lecturer();
		lecturer.setLecturerName(lecturerName);
		lecturer.setAddress(address);
		lecturer.setDepartment(department);
		lecturer.setEMail(eMail);
		lecturer.setPhone(Long.parseLong(phone));
		lecturer.setCourseHandled(courseHandled);
		lecturerService.saveLecturer(lecturer);
	}
	
	@MutationMapping
	public void updateLecturer(@Argument Long lecturerId ,@Argument String lecturerName,@Argument String address, @Argument String department ,@Argument String eMail,@Argument String phone,@Argument String courseHandled ) {
		Lecturer lecturer = lecturerService.findLecturerById(lecturerId);
		if (lecturerName != null)lecturer.setLecturerName(lecturerName);
		if (address != null)lecturer.setAddress(address);
		if(department != null)lecturer.setDepartment(department);
		if(eMail != null)lecturer.setEMail(eMail);
		if(phone != null)lecturer.setPhone(Long.parseLong(phone));
		if(courseHandled != null)lecturer.setCourseHandled(courseHandled);
		lecturerService.saveLecturer(lecturer);
	}
	
	@MutationMapping
	public void deleteLecturer(@Argument Long lecturerId) {
		lecturerService.deleteLecturer(lecturerService.findLecturerById(lecturerId));
	}

}
