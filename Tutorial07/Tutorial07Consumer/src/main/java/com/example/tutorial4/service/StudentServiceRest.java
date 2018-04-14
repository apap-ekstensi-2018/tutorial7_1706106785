package com.example.tutorial4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.tutorial4.dao.StudentDAO;
import com.example.tutorial4.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class StudentServiceRest implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public StudentModel selectStudent(String npm) {
		// TODO Auto-generated method stub
		log.info("REST - select student with npm {}",npm);
		return studentDAO.selectStudent(npm);
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		// TODO Auto-generated method stub
		log.info("REST - select all students");
		return studentDAO.selectAllStudent();
	}

	@Override
	public void addStudent(StudentModel student) {}

	@Override
	public void deleteStudent(String npm) {}

	@Override
	public void updateStudent(StudentModel student) {}

}
