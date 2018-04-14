package com.example.tutorial4.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.tutorial4.model.StudentModel;

@Service
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	public StudentModel selectStudent(String npm)
	{
		StudentModel student = restTemplate.getForObject("http://localhost:8080/rest/student/view/"+npm, StudentModel.class);
		return student;
	}

	@Override
	public List<StudentModel> selectAllStudent() {
		ResponseEntity<StudentModel[]> studentList = restTemplate.getForEntity("http://localhost:8080/rest/student/viewall",StudentModel[].class);
        return Arrays.asList(studentList.getBody());
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
