package group.service;

import group.entily.Course;

public interface CourseService {

    Course create(String title, String description);

    boolean update(Course course);

    boolean delete(Course course);
}