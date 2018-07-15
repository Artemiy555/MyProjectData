package com.rest.test.util;

import com.rest.core.domain.Student;

public class StudentsUtil {

    public static Student createSingleStudent() {
        Student student = new Student();
        student.setName("Ivan");
        student.setSurname("Ivanov");
        student.setAge(25);
        return student;
    }

    public static Student createStudent() {
        Student student = new Student();
        student.setName("Vasilij");
        student.setSurname("Vasiliev");
        student.setAge(30);
        return student;
    }

}
