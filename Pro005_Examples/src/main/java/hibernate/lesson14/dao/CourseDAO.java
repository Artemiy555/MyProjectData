package hibernate.lesson14.dao;

import hibernate.lesson14.entity.Course;

import java.util.List;

public interface CourseDAO {

    Long create(Course course);

    Course read(Long id);

    boolean update(Course course);

    boolean delete(Long id);

    List<Course> findAll();
}
