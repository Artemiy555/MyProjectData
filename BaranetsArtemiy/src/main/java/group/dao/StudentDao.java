package group.dao;

import group.entily.Student;

import java.util.List;

public interface StudentDao {

    Long create(Student student);

    Student read(Long id);

    boolean update(Student student);

    boolean delete(Long id);

    List<Student> findAll();
}
