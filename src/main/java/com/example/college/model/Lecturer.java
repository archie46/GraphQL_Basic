package com.example.college.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lecturer {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long lecturerId;
	String lecturerName;
	String address;
	String department;
	String eMail;
	Long phone;
	String courseHandled;
	
	
}