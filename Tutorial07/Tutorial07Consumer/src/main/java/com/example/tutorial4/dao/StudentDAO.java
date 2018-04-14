package com.example.tutorial4.dao;

import java.util.List;

import com.example.tutorial4.model.StudentModel;

public interface StudentDAO {
	
	StudentModel selectStudent(String npm);
	List<StudentModel> selectAllStudent();
	}

