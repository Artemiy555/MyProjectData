package com.rest.core.service;

import com.rest.api.request.parameters.CreateStudentParameters;
import com.rest.core.dao.StudentRepository;
import com.rest.core.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    public Long create(CreateStudentParameters params) {
        Student student = new Student();
        student.setName(params.getName());
        student.setSurname(params.getSurname());
        student.setAge(params.getAge());
        return repository.saveAndFlush(student).getId();
    }

}
