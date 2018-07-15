package com.rest.test.service;

import com.rest.api.request.parameters.CreateStudentParameters;
import com.rest.core.dao.StudentRepository;
import com.rest.core.domain.Student;
import com.rest.core.service.StudentService;
import com.rest.test.config.DBConfig;
import com.rest.test.util.StudentsUtil;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
@EnableAutoConfiguration
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
@EntityScan("com.rest.core.domain")
@EnableJpaRepositories("com.rest.core.dao")
@ComponentScan(basePackages = { "com.rest.core.service" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestStutentsService {

    @Configuration
    @Import(DBConfig.class)
    static class Config {}

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentService service;

    @Test
    public void testCreateStudent() {
        Student student = StudentsUtil.createSingleStudent();

        CreateStudentParameters parameters = new CreateStudentParameters();
        parameters.setName(student.getName());
        parameters.setSurname(student.getSurname());
        parameters.setAge(student.getAge());

        Long studentId = service.create(parameters);

        Student result = repository.findOne(studentId);

        Assert.assertEquals(student.getName(), result.getName());
        Assert.assertEquals(student.getSurname(), result.getSurname());
        Assert.assertEquals(student.getAge(), result.getAge());
    }
}
