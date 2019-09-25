package group.service.impl;

import group.dao.StudentDao;
import group.dao.impl.StudentDAOImpl;
import group.entily.Group;
import group.entily.Student;
import group.service.StudentServise;

public class StudentServiseImpl implements StudentServise {

    private StudentDao studentDao;

    public StudentServiseImpl() {
        studentDao = new StudentDAOImpl();
    }

    @Override
    public Student create(
            Group course, String title) {
        if (course != null) {
            Student student = new Student(course, title);
            student.setIdRating(studentDao.create(student));
            return student;
        }
        return null;
    }




}
