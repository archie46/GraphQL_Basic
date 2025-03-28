package com.example.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.college.model.Lecturer;
import com.example.college.service.LecturerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/lecturers")
@Tag(name = "Lecturer Management", description = "APIs for managing lecturers in the college")
public class LecturerRestController {
    
    @Autowired
    private LecturerService lecturerService;

    @GetMapping
    @Operation(summary = "Get All Lecturers", description = "Fetches a list of all lecturers available in the database.")
    public ResponseEntity<List<Lecturer>> getAllLecturers() {
        return new ResponseEntity<>(lecturerService.findAllLecturers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Lecturer by ID", description = "Fetches details of a specific lecturer by their ID.")
    public ResponseEntity<Lecturer> getLecturer(@PathVariable Long id) {
        return new ResponseEntity<>(lecturerService.findLecturerById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    @Operation(summary = "Create a Lecturer", description = "Creates a new lecturer record and returns the assigned ID.")
    public ResponseEntity<String> createLecturer(@RequestBody Lecturer lecturer) {
        return new ResponseEntity<>("Lecturer Created with ID: " + lecturerService.saveLecturer(lecturer), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(summary = "Update Lecturer Details", description = "Updates the details of an existing lecturer.")
    public ResponseEntity<String> updateLecturer(@RequestBody Lecturer lecturer) {
        Lecturer existingLecturer = lecturerService.findLecturerById(lecturer.getLecturerId());
        existingLecturer.setLecturerName(lecturer.getLecturerName());
        existingLecturer.setAddress(lecturer.getAddress());
        existingLecturer.setDepartment(lecturer.getDepartment());
        existingLecturer.setEMail(lecturer.getEMail());
        existingLecturer.setPhone(lecturer.getPhone());
        existingLecturer.setCourseHandled(lecturer.getCourseHandled());

        return new ResponseEntity<>("Lecturer Updated with ID: " + lecturerService.saveLecturer(existingLecturer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Lecturer", description = "Deletes a lecturer record by their ID.")
    public ResponseEntity<String> deleteLecturer(@PathVariable Long id) {
        lecturerService.deleteLecturer(lecturerService.findLecturerById(id));
        return new ResponseEntity<>("Lecturer Deleted Successfully", HttpStatus.OK);
    }
}

